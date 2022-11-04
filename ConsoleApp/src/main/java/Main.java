


import dataBase.DataBase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

// вначале написать на простой джаве, потом внедрить бины, контекст, и в целом Spring подключитьAction

// JDBC -> Spring JDBC-> Spring Data JDBC -> Spring Data JPA (Hibernate)

public class Main {
    public static void main(String[] args) throws SQLException, ReflectiveOperationException {
        //DispatcherAction.doSelected(Console.showMenu());
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");
//
//        while (resultSet.next()) {
//            int id = resultSet.getInt(1);
//            System.out.println(id);
//        }



        dataBase.closeConnection();
    }
}
