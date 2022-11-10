package repository.impl;

import entity.Material;
import entity.Order;
import entity.Product;
import repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    Connection connection;

    public ProductRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> getAll() throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
        while (resultSet.next()) {
            Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            products.add(product);
        }
        resultSet.close();
        return products;
    }

    @Override
    public Product getById(int productId) throws SQLException {

        Product product = new Product();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE id_product = ?");
        preparedStatement.setInt(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        product.setId_product(resultSet.getInt("id_product"));
        product.setProduct_name(resultSet.getString("product_name"));
        product.setProduction_time(resultSet.getInt("production_time"));
        resultSet.close();
        return product;
    }
}
