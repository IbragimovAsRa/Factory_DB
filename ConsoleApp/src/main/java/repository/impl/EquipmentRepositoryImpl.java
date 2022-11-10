package repository.impl;

import entity.Equipment;
import repository.EquipmentRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipmentRepositoryImpl implements EquipmentRepository {
    Connection connection;

    public EquipmentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    public List<Equipment> getAll() throws SQLException {
        List<Equipment> equipments = new ArrayList<>();
        String request = "SELECT * FROM equpment";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);

        while (resultSet.next()) {
            Equipment equipment = new Equipment(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7));
            equipments.add(equipment);
        }
        return equipments;
    }

    @Override
    public List<Equipment> getEquipmentWithAnExpiredGuarrantePeriod() throws SQLException {
        List<Equipment> equipments = new ArrayList<>();
        String request = "select * \n" +
                "from equpment\n" +
                "where (`guaranty_period(months)` - `period_of_exploitation(months)`) < 0";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);

        while (resultSet.next()) {
            Equipment equipment = new Equipment(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(7));
            equipments.add(equipment);
        }
        return equipments;
    }
}
