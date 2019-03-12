import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try{
            Path path = Paths.get("E:\\Политех\\ООП\\ksrka\\src\\cities.txt");//Путь к списку городов
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);//List, созданный из списка городов
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
