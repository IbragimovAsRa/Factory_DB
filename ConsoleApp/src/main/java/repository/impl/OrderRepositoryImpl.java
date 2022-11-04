package repository.impl;

import entity.Order;
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
}
