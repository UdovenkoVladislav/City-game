import java.util.List;

public class Game_function {

    String random_city(List<String> list, int a, int b){
        int n = a + (int) (Math.random() * b);//Случайное число от "а" до "b"
        return list.get(n);
    }

    Character getFirstChar(String city) {
        return city.charAt(0);
    }

    Character getLastChar(String city) {
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

    String find_city(List<String> list, Character c){
        for(String city: list){
            if (city.charAt(0) == c){
                return city;
            }
        }
        return "Не знаю";
    }
}
