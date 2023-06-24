package GB_java.seminar5;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре 
// будут повторяющиеся имена с разными телефонами, их необходимо 
// считать, как одного человека с разными телефонами. Вывод должен 
// быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class task1 {
    static Map<String, ArrayList<String>> db = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. ввод . 2. вывод 3. выход");
            int command = scanner.nextInt();
            if (command == 1) addData();
            else if (command ==2) showData();
            else if (command == 3) return;
            else System.out.println("неправильная команда");
        }
    }

        public static void addData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите ФИО");
        String name = scanner.nextLine();
        System.out.println("введите номер");
        String number = scanner.nextLine();
        if (db.containsKey(name)){
            ArrayList<String> numbers = db.get(name);
            numbers.add(number);
        }
        else {
            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(number);
            db.put(name, numbers);
        }
    }

    public static void showData() {
        String[] order = db.keySet().toArray(new String[0]);
        for (int i = 0; i < order.length - 1; i++) {
            for (int j = 0; j < order.length - i - 1; j++) {
                if (db.get(order[j]).size() < db.get(order[j + 1]).size()) {
                    String temp = order[j];
                    order[j]=order[j+1];
                    order[j+1]=temp;
                }
            }
        }
        for (String name : order) {
            System.out.println(name+": "+String.join(", ", db.get(name)));
        }
    }
}
