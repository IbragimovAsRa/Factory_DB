package repository.impl;

import entity.Order;
import entity.Product;
import repository.OrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    Connection connection;

    public OrderRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Order getById(int id) throws SQLException {
        Order order = new Order();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE id_orders = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        order.setId_orders(resultSet.getInt("id_orders"));
        order.setOrder_date(resultSet.getDate("order_date"));
        order.setManager(resultSet.getString("manager"));
        order.setPrice_order(resultSet.getInt("price_order"));
        order.setPrice_delivery(resultSet.getInt("price_delivery"));
        resultSet.close();
        return order;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

        while (resultSet.next()) {
            Order order = new Order();
            order.setId_orders(resultSet.getInt("id_orders"));
            order.setOrder_date(resultSet.getDate("order_date"));
            order.setManager(resultSet.getString("manager"));
            order.setPrice_order(resultSet.getInt("price_order"));
            order.setPrice_delivery(resultSet.getInt("price_delivery"));
            orders.add(order);
        }
        resultSet.close();

        return orders;
    }

    @Override
    public List<Product> getProductForOrder(int orderId) throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        PreparedStatement preparedStatement = connection.prepareStatement("select product_name from orders_has_product left join product p on orders_has_product.product_id_product = p.id_product where orders_id_orders = ?");
        preparedStatement.setInt(1, orderId);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProduct_name(resultSet.getString(1));
            products.add(product);
        }
        resultSet.close();
        return products;

    }

    @Override
    public String getAmountMaterialsForOrder(int orderId) throws SQLException {
        String result = "";
        String request = "select material_name, amount_of_material from (select  materials_id_materials, sum(quantity_entity) as amount_of_material\n" +
                "from orders_has_product\n" +
                "         left join product_has_materials phm on orders_has_product.product_id_product = phm.product_id_product\n" +
                "where orders_id_orders = ?\n" +
                "group by materials_id_materials, orders_id_orders) as r left join materials as l on r.materials_id_materials = l.id_materials";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        int i = 1;
        while (resultSet.next()) {
            result = result + i + ".  " + resultSet.getString(1) + "  -  " + resultSet.getString(2) + "\n";
            i ++;
        }
        System.out.println(result);
        resultSet.close();
        return result;
    }
    // Чистая прибыль от заказов (стоимость заказа - стоимость материалов - стоимость доставки - стоимость оборудования)
    @Override
    public double getProfitForOrder(int orderId) throws SQLException {

        String request = "select id_orders, (price_order - price_delivery - equipment_costs - price_materials) as profit\n" +
                "from (select *\n" +
                "      from (select orders_id_orders, sum(materials_price) as price_materials\n" +
                "            from (select orders_id_orders, id_product\n" +
                "                  from orders_has_product\n" +
                "                           left join product p on\n" +
                "                      orders_has_product.product_id_product = p.id_product) as a\n" +
                "                     left join\n" +
                "                 (select product_id_product, sum(quantity_entity * unit_price) as materials_price\n" +
                "                  from product_has_materials\n" +
                "                           left join\n" +
                "                       materials m\n" +
                "                       on\n" +
                "                           m.id_materials = product_has_materials.materials_id_materials\n" +
                "                  group by product_id_product) as b\n" +
                "                 on id_product = product_id_product\n" +
                "            group by orders_id_orders) as c\n" +
                "\n" +
                "               left join orders as d\n" +
                "                         on orders_id_orders = id_orders) as lll\n" +
                "         left join\n" +
                "     (select orders_id_orders, sum(equipment_costs) as equipment_costs\n" +
                "      from (select *\n" +
                "            from orders_has_product\n" +
                "                     left join product p on p.id_product = orders_has_product.product_id_product) as l\n" +
                "               left join\n" +
                "           (select product_id_product, sum(price_eq * `operation_execution_time(hours)`) as equipment_costs\n" +
                "            from product_to_equpment\n" +
                "                     left join\n" +
                "                 (select id_equpment, equpment_name, (`equpment_price` / `work_resource(hours)`) as price_eq\n" +
                "                  from equpment) as eq\n" +
                "                 on id_equpment = product_to_equpment.equpment_id_equpment\n" +
                "            group by product_id_product) as r\n" +
                "           on\n" +
                "               l.product_id_product = r.product_id_product\n" +
                "      group by orders_id_orders) as rrr\n" +
                "     on lll.orders_id_orders = rrr.orders_id_orders\n" +
                "where id_orders = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, orderId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getDouble(2);
    }
}
