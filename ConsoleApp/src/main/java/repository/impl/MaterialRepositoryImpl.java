package repository.impl;

import entity.Material;
import repository.MaterialRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialRepositoryImpl implements MaterialRepository {


    Connection connection;

    public MaterialRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Material getById(int materialId) throws SQLException {
        String request = "SELECT * FROM materials WHERE id_materials = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, materialId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Material material = new Material(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
        return material;
    }

    @Override
    public List<Material> getAll() throws SQLException {
        ArrayList<Material> materials = new ArrayList<Material>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM materials");
        while (resultSet.next()) {
            Material material = new Material(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            materials.add(material);
        }
        resultSet.close();
        return materials;
    }



    @Override
    public List<Material> getMaterialForProduct(int productId) throws SQLException {
        ArrayList<Material> materials = new ArrayList<Material>();
        String request = "select id_materials, material_name, unit_price from\n" +
                "(select materials_id_materials, quantity_entity from product_has_materials where product_id_product = ?) as r\n" +
                "left join materials on materials_id_materials= materials.id_materials";

        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Material material = new Material(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            materials.add(material);
        }
        return materials;

    }

    @Override
    public int getMaterialPriceForProduct(int productId) throws SQLException {
        int result;
        String request = "select id_product, product_name, materials_price from\n" +
                "(select product_id_product, sum(quantity_entity * unit_price) as materials_price\n" +
                " from product_has_materials\n" +
                "          left join\n" +
                "      materials m\n" +
                "      on\n" +
                "          m.id_materials = product_has_materials.materials_id_materials\n" +
                " group by product_id_product) as l left join product on product_id_product=product.id_product where id_product = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(3);

    }
}
