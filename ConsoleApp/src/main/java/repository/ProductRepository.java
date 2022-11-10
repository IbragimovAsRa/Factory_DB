package repository;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    List<Product>  getAll() throws SQLException;
    Product getById(int productId) throws SQLException;



}
