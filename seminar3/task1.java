package GB_java.seminar3;

import java.util.ArrayList;
import java.util.Random;

public class task1 {
    public static void main(String[] args) {

        // Пусть дан произвольный список целых чисел.
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        int size = 100; 
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(100); 
            numbers.add(randomNumber); 
        }
        
        // 1) Нужно удалить из него чётные числа
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }

        // 2) Найти минимальное значение
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber < min) {
                min = currentNumber;
            }
        }

        // 3) Найти максимальное значение
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > max) {
                max = currentNumber;
            }
        }

        // 4) Найти среднее значение
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double average = (double)sum / numbers.size();

    }
}
