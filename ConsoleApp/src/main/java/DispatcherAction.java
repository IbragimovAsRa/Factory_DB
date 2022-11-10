import dataBase.DataBase;
import entity.Product;
import repository.impl.EquipmentRepositoryImpl;
import repository.impl.MaterialRepositoryImpl;
import repository.impl.OrderRepositoryImpl;
import repository.impl.ProductRepositoryImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;


public class DispatcherAction {
    static Scanner scanner = new Scanner(System.in);
    public static void doSelectedRequestToProduct(int action) throws SQLException, ReflectiveOperationException, IOException {
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl(connection);
        int productId;
        switch (action) {
            case 1:
                System.out.print("\033[H\033[J");
                out.print("Список производимых изделий на фабрике: \n");
                out.print(productRepository.getAll());
                out.println("\n\n\n                                    Вернуться в меню изделий (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(2);
                }
                break;
            case 2:
                out.print("\033[H\033[J");
                out.print("Введите id запрашиваемого изделия: ");
                productId = scanner.nextInt();
                out.print("\033[H\033[J");
                out.print("информация о запрашиваемом изделии: \n");
                out.print(productRepository.getById(productId));
                out.println("\n\n\n                              Вернуться в меню изделий (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(2);
                }
                break;
        }
    }
    public static void doSelectedRequestToOrders(int action) throws SQLException, ReflectiveOperationException, IOException {
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl(connection);
        int orderId;

        switch (action) {
            case 1:
                out.print("\033[H\033[J");
                out.print("Введите id запрашиваемого заказа: \n");
                orderId = scanner.nextInt();
                out.print("\033[H\033[J");
                out.print("Чистая прибыль от данного заказа составила: \n");

                orderRepository.getAmountMaterialsForOrder(orderId);
                out.println("                              Вернуться в меню заказов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(1);
                }
                break;
            case 2:
                out.print("\033[H\033[J");
                out.print("Введите id запрашиваемого заказа: \n");
                orderId = scanner.nextInt();
                out.print("\033[H\033[J");
                out.print("Чистая прибыль от данного заказа составила: ");
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
                for (int i = 0; i < products.size(); i++) {
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

    public static void doSelectedRequestToMaterial(int action) throws SQLException, ReflectiveOperationException, IOException {
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        int productId;
        MaterialRepositoryImpl materialRepository = new MaterialRepositoryImpl(connection);
        switch (action) {
            case 1:
                System.out.print("\033[H\033[J");
                out.print(materialRepository.getAll());
                System.out.println("\n\n\n                              Вернуться в меню материалов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(4);
                } else {
                    out.println("Некоректный ввод, завершение программы");
                }
                break;
            case 2:
                System.out.print("\033[H\033[J");
                out.print("Введите id изделия: ");
                productId = scanner.nextInt();
                out.print(materialRepository.getMaterialForProduct(productId));
                System.out.println("\n\n\n                              Вернуться в меню материалов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(4);
                } else {
                    out.println("Некоректный ввод, завершение программы");
                }
                break;
            case 3:
                System.out.print("\033[H\033[J");
                out.print("Введите id изделия: ");
                productId = scanner.nextInt();
                out.print("Затраты на материалы для производства данного изделия составляют : " + materialRepository.getMaterialPriceForProduct(productId));
                System.out.println("\n\n\n                              Вернуться в меню материалов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(4);
                } else {
                    out.println("Некоректный ввод, завершение программы");
                }
                break;
        }

    }
    public static void doSelectedRequestToEquipment(int action) throws SQLException, ReflectiveOperationException, IOException {
        DataBase dataBase = new DataBase();
        Connection connection = dataBase.getConnection();
        EquipmentRepositoryImpl equipmentRepository = new EquipmentRepositoryImpl(connection);
        switch (action) {
            case 1:
                System.out.print("\033[H\033[J");
                out.print("Список оборудования на фабрике:\n\n");
                out.print(equipmentRepository.getAll());
                System.out.println("\n\n\n                              Вернуться в меню материалов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(3);
                } else {
                    out.println("Некоректный ввод, завершение программы");
                }
                break;
            case 2:
                System.out.print("\033[H\033[J");
                out.print("Оборудование с истекшим сроком гарантии:\n");
                out.print(equipmentRepository.getEquipmentWithAnExpiredGuarrantePeriod());
                System.out.println("\n\n\n                              Вернуться в меню материалов (6) \n");
                if (scanner.nextInt() == 6) {
                    doSelected(3);
                } else {
                    out.println("Некоректный ввод, завершение программы");
                }

                break;
        }
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
