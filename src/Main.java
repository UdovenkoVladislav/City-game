
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try{
            System.out.println("Программа, которая реализует игру Города между двумя потоками.");
            System.out.println("Эту программу разработал студент:");
            char[] z = {1059,1076,1086,1074,1077,1085,1082,1086,32,1055,1069,45,49,55,49};
            for(char c: z){
                System.out.print(c);
            } System.out.print("\n");

            Path path = Paths.get("cities.txt");//Путь к списку городов
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);//List, созданный из списка городов

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя первого потока (например, Вася):\n");
            String name_first_thread = reader1.readLine();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Первый поток будет умным или честным? (Введите smart или honest)\n");
            String status_first_thread = reader2.readLine();
            BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите для первого потока забывание (в процентах) городов из списка (например, 20):\n");
            String pr_first_thread = reader3.readLine();
            BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Первый поток будет ходить 1-м или 2-м? (Введите 1 или 2):\n");
            String xod_first_thread = reader4.readLine();

            BufferedReader reader5 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя второго потока (например, Петя):\n");
            String name_second_thread = reader5.readLine();
            BufferedReader reader6 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Второй поток будет умным или честным? (Введите smart или honest)\n");
            String status_second_thread = reader6.readLine();
            BufferedReader reader7 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите для второго потока забывание (в процентах) городов из списка (например, 20):\n");
            String pr_second_thread = reader7.readLine();

            Exchanger<String> ex = new Exchanger<String>();//Переменная между потоками(город)

            int i1 = Integer.parseInt(xod_first_thread);
            int i2;
            if (i1 == 1) {
                i2 = 2;
            } else {
                i2 = 1;
            }

            Thread gamer1 = new Thread1(name_first_thread, lines, ex, i1,
                    100 - Integer.parseInt(pr_first_thread), status_first_thread);
            Thread gamer2 = new Thread1(name_second_thread, lines, ex, i2,
                    100 - Integer.parseInt(pr_second_thread), status_second_thread);
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
