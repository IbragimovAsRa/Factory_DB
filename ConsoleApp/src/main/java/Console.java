import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import static java.lang.System.*;
public class Console {
    static Scanner scanner = new Scanner(System.in);


    public static void showMenuOrders() throws IOException, ReflectiveOperationException, SQLException {
        int action;
        System.out.print("\033[H\033[J");
        System.out.println("Какую информацию о заказах вы хотите запросить:\n");
        System.out.print("1. Какие материлы(и их количество) надо закупить для выполнения n заказа\n" +
                "2. Прибыль от заказа (стоимость материалов - стоимость заказа - стоимость доставки)\n" +
                "3. Какие изделия нужно изготовить для выполнения заказа n\n" +
                "4. Информация о всех заказах\n\n\n" +
                "                               Вернуться в главное меню (6)\n");
        action = scanner.nextInt();
        if (action == 6) {
            DispatcherAction.doSelected(Console.showMenu());
        } else if (action == 1 || action == 2 || action == 3 || action == 4) {
            DispatcherAction.doSelectedRequestToOrders(action);
        } else {
            showMenuOrders();
        }
    }

    public static void showMenuProducts() throws IOException, ReflectiveOperationException, SQLException {
        int action;
        System.out.print("\033[H\033[J");
        System.out.println("Какую информацию о изделиях вы хотите запросить:\n");
        System.out.print("1. Список производимых изделий \n" +
                 "2. Получить изделие по id" + "\n\n" +
                "                               Вернуться в главное меню (6)\n");
        action = scanner.nextInt();
        if (action == 6) {
            DispatcherAction.doSelected(Console.showMenu());
        } else if (action == 1 || action == 2 || action == 3 ) {
            DispatcherAction.doSelectedRequestToProduct(action);
        } else {
            showMenuProducts();
        }


    }
    public static void showMenuEquipment() throws ReflectiveOperationException, SQLException, IOException {
        int action;
        System.out.print("\033[H\033[J");
        System.out.println("Какую информацию о оборудовании вы хотите запросить:\n");
        System.out.print("1. Список имеющегося оборудования\n" +
                "2. Список оборудования с истекшим сроком гарантии\n" + "\n\n" +
                "                               Вернуться в главное меню (6)\n");
        action = scanner.nextInt();
        if (action == 6) {
            DispatcherAction.doSelected(Console.showMenu());
        } else if (action == 1 || action == 2 || action == 3 ) {
            DispatcherAction.doSelectedRequestToEquipment(action);
        } else {
            showMenuEquipment();
        }

    }
    public static void showMenuMaterials() throws IOException, ReflectiveOperationException, SQLException {
        System.out.print("\033[H\033[J");
        System.out.println("Какую информацию о материалах вы хотите запросить:");
        System.out.print("1. Список используемых материалов\n" +
                "2. Какаие материалы нужны для производства изделия\n" +
                "3. Стоимость материалов каждого изделия\n\n\n" +
                "                                 Вернуться в главное меню (6)\n");
        int action;
        action = scanner.nextInt();
        if (action == 6) {
            DispatcherAction.doSelected(Console.showMenu());
        } else if(action == 1 || action == 2 || action == 3) {
            DispatcherAction.doSelectedRequestToMaterial(action);
        } else {
            System.out.println("Не корректный ввод");
            showMenuMaterials();
        }
    }
    public static int showMenu() throws IOException {
        System.out.print("\033[H\033[J");
        int action;
        System.out.print("Выберите запрашиваемую информацию:\n" +
                "1. Заказы\n" +
                "2. Изделения\n" +
                "3. Оборудование\n" +
                "4. Материалы\n" );
        action = scanner.nextInt();
        System.out.println(action);
        return action;
    }

    public static void show(Entity entity) throws IOException, ReflectiveOperationException, SQLException {
        switch (entity) {
            case ORDER:
                showMenuOrders();
                break;
            case PRODUCT:
                showMenuProducts();
                break;
            case EQUIPMENT:
                showMenuEquipment();
                break;
            case MATERIAL:
                showMenuMaterials();
                break;
        }
    }
}
