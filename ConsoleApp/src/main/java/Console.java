import java.io.IOException;
import java.util.Scanner;

public class Console {


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
    public static void show(Entity entity) {
        switch (entity) {
            case ORDER:
                System.out.println("Какую информацию о заказах вы хотите запросить:");
                System.out.print("1. Какие материлы(и их количество) надо закупить для выполнения n заказа" +
                        "2. Прибыль от заказов (стоимость материалов - стоимость заказа - стоимость доставки)" +
                        "3. Список оборудования каждого заказа" +
                        "4. Информация о всех заказах");
                break;
            case PRODUCT:
                System.out.println("Какую информацию о заказах вы хотите запросить:");
                System.out.print("1. Список производимых изделий" +
                        "2. Какаие материалы нужны для производства этого изделияe");
                break;
            case EQUPMENT:
                break;
            case MATERIAL:
                break;
        }
    }
}
