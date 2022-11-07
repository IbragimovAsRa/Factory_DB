import dataBase.DataBase;
import entity.Product;
import repository.impl.OrderRepositoryImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;


public class DispatcherAction {
    public static void doSelectedRequestToOrders(int action) throws SQLException, ReflectiveOperationException, IOException{
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl(connection);
        Scanner scanner = new Scanner(System.in);
        int orderId;

        switch (action) {
            case 1:
                System.out.print("\033[H\033[J");
                orderRepository.getAmountMaterialsForOrder(1);
                out.println("                              Вернуться в меню заказов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(1);
                }
                break;
            case 2:
                out.print("\033[H\033[J");
                out.print("Введите id запрашиваемого заказа: \n");
                orderId = scanner.nextInt();
                System.out.println(orderRepository.getProfitForOrder(orderId));
                System.out.println("                              Вернуться в меню заказов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(1);
                }
                break;
            case 3:
                System.out.print("\033[H\033[J");
                int scan;
                System.out.println("Введите id заказа, для получения информации:\n");
                orderId = scanner.nextInt();
                System.out.print("\033[H\033[J");
                ArrayList<Product> products = (ArrayList<Product>) orderRepository.getProductForOrder(orderId);
                for (int i = 0; i < products.size(); i ++) {
                    System.out.println(" " + (i + 1) + ".  " + products.get(i).getProduct_name());
                }
                System.out.println("                              Вернуться в меню заказов (6) \n");
                scan = scanner.nextInt();
                if (scan == 6) {
                    doSelected(1);
                }
                break;
            case 4:
                System.out.println(orderRepository.getAll());
                System.out.println("\n\n\n                              Вернуться в меню заказов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(1);
                }
                break;
        }

        dataBase.closeConnection();
    }

public static void doSelectedRequestToMaterial(int action) {

}

    public static void doSelected(int select) throws IOException, ReflectiveOperationException, SQLException {
        switch (select) {
            case 1:
                Console.show(Entity.ORDER);
                break;
            case 2:
                Console.show(Entity.PRODUCT);
                break;
            case 3:
                Console.show(Entity.EQUIPMENT);
                break;
            case 4:
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
