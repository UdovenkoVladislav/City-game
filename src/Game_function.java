import java.util.List;

public class Game_function {

    public static String random_city(List<String> list, int a, int b){
        int n = a + (int) (Math.random() * b);//Случайное число от "а" до "b"
        return list.get(n);
    }

    public static Character getFirstChar(String city) {
        return city.charAt(0);
    }

    public static Character getLastChar(String city) {
        int pos = city.length() - 1;
        char lastChar = city.toUpperCase().charAt(pos);
        if (city.toUpperCase().charAt(pos) == 'Й') {
            return 'И';
        }
        else if (lastChar == 'Ь' || lastChar == 'Ы' || lastChar == 'Ъ') {
            pos--;
        }
        return city.toUpperCase().charAt(pos);
    }

    public static String find_city(List<String> list, Character c){
        for(String city: list){
            if (city.charAt(0) == c){
                return city;
            }
        }
        return "Не знаю";
    }
}
