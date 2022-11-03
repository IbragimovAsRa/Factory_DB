import java.io.IOException;
// вначале написать на простой джаве, потом внедрить бины, контекст, и в целом Spring подключитьAction
public class Main {
    public static void main(String[] args) throws IOException {
        DispatcherAction.doSelected(Console.showMenu());
    }
}
