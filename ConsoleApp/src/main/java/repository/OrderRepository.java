package repository;

import entity.Material;
import entity.Order;
import entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {
    // Получить заказ по его id
    Order getById(int id) throws SQLException;
    // Получить все заказы
    List<Order> getAll() throws SQLException;

    // Какие изделия нужно изготовить для выполнения заказа n
    List<Product>  getProductForOrder(int orderId) throws SQLException;

    String getAmountMaterialsForOrder(int orderId) throws SQLException;
    double getProfitForOrder(int orderId) throws SQLException;
}
