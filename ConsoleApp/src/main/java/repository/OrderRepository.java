package repository;

import entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {

    Order getById(int id) throws SQLException;
    List<Order> getAll() throws SQLException;

}
