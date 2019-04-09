import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        try{
            Path path = Paths.get("E:\\Политех\\ООП\\ksrka\\src\\cities.txt");//Путь к списку городов
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);//List, созданный из списка городов

            Exchanger<String> ex = new Exchanger<String>();//Переменная между потоками(город)
            Thread gamer1 = new Thread1("Игрок №1", lines, ex, 1, 70);
            Thread gamer2 = new Thread1("Игрок №2", lines, ex, 2, 100);
            gamer1.start();
            gamer2.start();
            gamer1.join();
            gamer2.join();
            System.out.println("Игра окончена!");
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
