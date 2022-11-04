import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Console  {

    public static void showMenuOrders() throws IOException, ReflectiveOperationException, SQLException {
        int action;
        Scanner in = new Scanner(System.in);
        System.out.println("Какую информацию о заказах вы хотите запросить:\n");
        System.out.print("1. Какие материлы(и их количество) надо закупить для выполнения n заказа\n" +
                "2. Прибыль от заказов (стоимость материалов - стоимость заказа - стоимость доставки)\n" +
                "3. Список оборудования каждого заказа\n" +
                "4. Информация о всех заказах\n\n\n" +
                "                              5. Вернуться в главное меню");
        action = 4;
        if (action == 5) {
            Console.showMenu();
        } else if (action == 1 || action == 2 || action == 3|| action == 4) {
            DispatcherAction.doSelectedRequestToOrders(action);
        } else {
            System.out.println("Не корректный ввод");
        }
        System.out.println(action);
    }
    public static void showMenuProducts() {
        System.out.println("Какую информацию о заказах вы хотите запросить:");
        System.out.print("1. Список производимых изделий" +
                "2. Какаие материалы нужны для производства этого изделияe");
    }
    public static int showMenu() throws IOException {
        int action;
        Scanner in = new Scanner(System.in);
        System.out.print("Выберите запрашиваемую информацию:\n" +
                "1. Заказы\n" +
                "2. Изделения\n" +
                "3. Оборудование\n" +
                "4. Материалы\n" +
                "5. Другое\n"
        );
        action = in.nextInt();
        in.close();
        System.out.println(action);
        return action;
    }
    public static void show(Entity entity) throws IOException, ReflectiveOperationException, SQLException{
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
