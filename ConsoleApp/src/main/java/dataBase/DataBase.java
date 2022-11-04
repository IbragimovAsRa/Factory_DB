package dataBase;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    static String url = "jdbc:mysql://localhost:3306/factory?serverTimezone=UTC";
    static String username = "aslan_user";
    static String password = "password";
    Connection connection;

    public DataBase() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
