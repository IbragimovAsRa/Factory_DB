import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Console {

    public static void showMenuOrders() throws IOException, ReflectiveOperationException, SQLException {
        int action;
        System.out.print("\033[H\033[J");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую информацию о заказах вы хотите запросить:\n");
        System.out.print("1. Какие материлы(и их количество) надо закупить для выполнения n заказа\n" +
                "2. Прибыль от заказов (стоимость материалов - стоимость заказа - стоимость доставки)\n" +
                "3. Какие изделия нужно изготовить для выполнения заказа n\n" +
                "4. Информация о всех заказах\n\n\n" +
                "                               Вернуться в главное меню (666)\n");
        action = scanner.nextInt();
        if (action == 666) {
            DispatcherAction.doSelected(Console.showMenu());
        } else if (action == 1 || action == 2 || action == 3 || action == 4) {
            DispatcherAction.doSelectedRequestToOrders(action);
        } else {
            System.out.println("Не корректный ввод");
        }
    }

    public static void showMenuProducts() {
        System.out.print("\033[H\033[J");
        System.out.println("Какую информацию о заказах вы хотите запросить:");
        System.out.print("1. Список производимых изделий" +
                "2. Какаие материалы нужны для производства этого изделияe");
    }

    public static int showMenu() throws IOException {
        System.out.print("\033[H\033[J");
        int action;
        Scanner scaner = new Scanner(System.in);
        System.out.print("Выберите запрашиваемую информацию:\n" +
                "1. Заказы\n" +
                "2. Изделения\n" +
                "3. Оборудование\n" +
                "4. Материалы\n" +
                "5. Другое\n"
        );
        action = scaner.nextInt();
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
                break;
            case MATERIAL:
                break;
        }
    }
}
