


import dataBase.DataBase;
import entity.Order;
import repository.OrderRepository;
import repository.impl.OrderRepositoryImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

// вначале написать на простой джаве, потом внедрить бины, контекст, и в целом Spring подключитьAction

/*
        --> Hibernate
       /
JDBC -> Spring JDBC-> Spring Data JDBC -> Spring Data JPA (Hibernate)
       \
        --> Spring JDBC(Boot) -> Spring Data JDBC(Boot) -> Spring Data JPA (Hibernate,Boot)
 */
public class Main {
    public static void main(String[] args) throws SQLException, ReflectiveOperationException, IOException {
        // -----------------------------------------------------------------------------
        //DispatcherAction.doSelected(Console.showMenu());
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl(connection);
     //   dataBase.closeConnection();
        // -----------------------------------------------------------------------------
        DispatcherAction.doSelected(Console.showMenu());


        // -----------------------------------------------------------------------------


    }
}
