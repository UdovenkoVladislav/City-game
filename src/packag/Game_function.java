package packag;

import javafx.print.Collation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

    class Game_function {

    String random_city(List<String> list, int b){
        int n = (int) (Math.random() * b);//Случайное число от "а" до "b"
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

    private List<Character> getFirstCharMin(List<List<String>> s) {
        List<Character> b = new ArrayList<Character>();
        List<Integer> a = new ArrayList<Integer>();
        for (List<String> d: s) {
            a.add(d.size());
        }
        Collections.sort(a);
        //System.out.println(a);
        for (Integer i: a) {
            for (List<String> d : s) {
                if (d.size() == i) {
                    b.add(d.get(0).charAt(0));
                }
            }
        }
        //System.out.println(b);
        return b;
    }

    String find_city(List<String> list, Character c, String level) {
        Game_function g_f = new Game_function();
        //System.out.println(level + "***");
        //System.out.println(c + "***");
        if (level.equals("smart")) {
            String al = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
            //System.out.println(al + "***");
            List<List<String>> ls = new ArrayList<List<String>>();
            for(Character b: al.toCharArray()) {
                //System.out.println(b + "***");
                List<String> array = new ArrayList<String>();
                for(String city: list) {
                    if (city.charAt(0) == b) {
                        //System.out.println(city + "***");
                        array.add(city);
                    }
                }
                if (array.size() != 0) {
                    //System.out.println(array.size() + "***");
                    ls.add(array);
                }
            }
            for (int i = 0; i < ls.size(); i++) {
                for (String city : list) {
                    if (city.charAt(0) == c) {
                        //System.out.println(city);
                        if (g_f.getLastChar(city).equals(g_f.getFirstCharMin(ls).get(i))) {
                            List<Integer> a = new ArrayList<Integer>();
                            for (List<String> d: ls) {
                                a.add(d.size());
                            }
                            Collections.sort(a);
                            //System.out.println(a);
                            //System.out.println(g_f.getFirstCharMin(ls));
                            return city;
                        }
                    }
                }
            }
            //System.out.println(3);
        } else {
            //System.out.println(33);
            for(String city: list){
                if (city.charAt(0) == c){
                    return city;
                }
            }
        }
        return "Не знаю";
    }
}
