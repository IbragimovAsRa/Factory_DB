package repository;

import entity.Equipment;

import java.sql.SQLException;
import java.util.List;

public interface EquipmentRepository {

    List<Equipment> getAll() throws SQLException;
    List<Equipment> getEquipmentWithAnExpiredGuarrantePeriod() throws SQLException;

}
