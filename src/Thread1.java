import java.util.List;
import java.util.concurrent.Exchanger;

public class Thread1 extends Thread{

        private List<String> list;
        private Exchanger<String> exchanger;
        private String city;
        private int o = 0;

        Thread1(String name, List<String> lines, Exchanger<String> ex, int or_1_or_2){
            super(name);
            this.list = lines;
            this.exchanger = ex;
            this.o = or_1_or_2;
        }
        public void run() {
            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try{
                int i = 0;
                while (i < list.size()){
                    if (o == 1) {
                        city = Game_function.random_city(list,0, list.size());
                        System.out.printf("%s: " + city + "\n", Thread.currentThread().getName());//Написать случайный город из списка
                        Character cc = Game_function.getLastChar(city);
                        System.out.printf("%s: Тебе на " + cc + "\n", Thread.currentThread().getName());
                        list.remove(city);
                        city = exchanger.exchange(city);
                        o = 0;
                    } else {
                            city = exchanger.exchange(city);
                            if (city.equals("Я победил!!!")) {
                                System.out.printf("%s: " + city + "\n", Thread.currentThread().getName());
                                System.out.printf("%s finished... \n", Thread.currentThread().getName());
                                city = exchanger.exchange("Я победил!!!");
                                break;
                            } else {
                                list.remove(city);
                                Character c = Game_function.getLastChar(city);
                                city = Game_function.find_city(list, c);
                                if (city.equals("Не знаю")) {
                                    System.out.printf("%s: " + city + "\n", Thread.currentThread().getName());
                                    System.out.printf("%s finished... \n", Thread.currentThread().getName());
                                    city = exchanger.exchange("Я победил!!!");
                                    break;
                                } else {
                                    System.out.printf("%s: " + city + "\n", Thread.currentThread().getName());
                                    Character c1 = Game_function.getLastChar(city);
                                    System.out.printf("%s: Тебе на " + c1 + "\n", Thread.currentThread().getName());
                                    city = exchanger.exchange(city);
                                }
                            }
                    }
                    Thread.sleep(100);
                    i++;
                }
                System.out.printf("%s finished... \n", Thread.currentThread().getName());
            } catch(Exception r){
                System.out.println(r.toString());
            }
        }
    }
