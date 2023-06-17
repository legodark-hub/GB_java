package GB_java.seminar4;

import java.util.ArrayList;
import java.util.Scanner;

// Организовать вводи и хранение данных пользователей. ФИО возраст и пол
// вывод в формате Фамилия И.О. возраст пол
// добавить возможность выхода или вывода списка отсортированного по возрасту!)
// *реализовать сортировку по возрасту с использованием индексов
// *реализовать сортировку по возрасту и полу с использованием индексов

public class task1 {
    static ArrayList<String> lastNames = new ArrayList<>();
    static ArrayList<String> firstNames = new ArrayList<>();
    static ArrayList<String> middleNames = new ArrayList<>();
    static ArrayList<Integer> ages = new ArrayList<>();
    static ArrayList<Character> sexes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. ввод данных. 2. вывод в порядке ввода. 3. вывод сортированный по возрасту. 4. выход");
            int command = scanner.nextInt();
            if (command == 1) addData();
            else if (command ==2) showData(normalOrder());
            else if (command == 3) showData(sortedOrder());
            else if (command == 4) return;
            else System.out.println("неправильная команда");
        }
    }

    public static void addData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите фамилию, имя, отчество, возраст, пол (м/ж)  через запятую");
        String input = scanner.nextLine();
        String[] data = input.replace(" ","").split(",");
        lastNames.add(data[0]);
        firstNames.add(data[1]);
        middleNames.add(data[2]);
        ages.add(Integer.parseInt(data[3]));
        sexes.add(data[4].charAt(0));
    }
    public static void showData(int[] order) {
        for (int j : order) {
            StringBuilder result = new StringBuilder();
            result.append(lastNames.get(j))
            .append(" ")
            .append(firstNames.get(j).charAt(0))
            .append(".")
            .append(middleNames.get(j).charAt(0))
            .append(". ")
            .append(ages.get(j))
            .append(" ")
            .append(sexes.get(j))
            .append("\n");
            System.out.println(result.toString());
        }
    }

    public static int[] normalOrder() {
        int[] order = new int[lastNames.size()];
        for (int i = 0; i<order.length; i++) {
            order[i]=i;
        }
        return order;
    }

    public static int[] sortedOrder() {
        int[] order = new int[lastNames.size()];
        for (int i = 0; i<order.length; i++) {
            order[i]=i;
        }
        for (int i = 0; i < ages.size() - 1; i++) {
            for (int j = 0; j < ages.size() - i - 1; j++) {
                if (ages.get(order[j]) > ages.get(order[j + 1])) {
                    int temp = order[j];
                    order[j]=order[j+1];
                    order[j+1]=temp;
                }
            }
        }
        return order;
    }
        
}

