package packag;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        try{
            char[] z = {1059,1076,1086,1074,1077,1085,1082,1086,32,1055,1069,45,49,55,49};
            for(char c: z){
                System.out.print(c);
            } System.out.print("\n");
            Path path = Paths.get("cities.txt");//Путь к списку городов
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);//List, созданный из списка городов

            Exchanger<String> ex = new Exchanger<String>();//Переменная между потоками(город)
            Thread gamer1 = new Thread1("Игрок №1", lines, ex, 1, 100, "smart");
            Thread gamer2 = new Thread1("Игрок №2", lines, ex, 2, 100, "gfg");
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
