import dataBase.DataBase;
import repository.impl.OrderRepositoryImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DispatcherAction {
    public static void doSelectedRequestToOrders(int action) throws SQLException, ReflectiveOperationException, IOException{
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl(connection);

        switch (action) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println(orderRepository.getAll());
                break;
        }

        dataBase.closeConnection();
    }
    public static void doSelected(int select) throws IOException, ReflectiveOperationException, SQLException {
        switch (select) {
            case 1:
                System.out.println("Ваш выбор 1");
                Console.show(Entity.ORDER);
                break;
            case 2:
                System.out.println("Ваш выбор 2");
                Console.show(Entity.PRODUCT);
                break;
            case 3:
                System.out.println("Ваш выбор 3");
                Console.show(Entity.EQUIPMENT);
                break;
            case 4:
                System.out.println("Ваш выбор 4");
                Console.show(Entity.MATERIAL);
                break;
            case 5:
                System.out.println("Ваш выбор 5");
                System.out.println("Здесь будут специальные запросы, охватывающие несколько таблиц");
            default:
                System.out.println("Нет такого варианта запроса");
                doSelected(Console.showMenu());
        }

    }
}
