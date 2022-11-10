package repository;

import entity.Material;

import java.sql.SQLException;
import java.util.List;

public interface MaterialRepository {
    Material getById(int materialId) throws SQLException;
    List<Material> getAll() throws SQLException;
    List<Material> getMaterialForProduct(int productId) throws SQLException;

    int getMaterialPriceForProduct(int productId) throws SQLException;

}
