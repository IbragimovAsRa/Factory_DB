import java.io.IOException;

public class DispatcherAction {
    public static void doSelected(int select) throws IOException {
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
