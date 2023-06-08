package GB_java;

import java.util.Random;

public class task1 {
    public static void main(String[] args) {
        // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        int i = new Random().nextInt(2000);

        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int c = i;
        int n = 0;
        while (c != 1) {
            c >>= 1;
            n++;
        }

        // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в
        // массив m1
        int arraysize1 = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0)
                arraysize1++;
        }
        int[] m1 = new int[arraysize1];
        for (int j = i; j < Short.MAX_VALUE; j++) {
            int k = 0;
            if (j % n == 0) {
                m1[k] = j;
                k++;
            }
        }

        // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и
        // сохранить в массив m2
        int arraysize2 = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0)
                arraysize2++;
        }
        int[] m2 = new int[arraysize2];
        for (int j = Short.MIN_VALUE; j < i; j++) {
            int k = 0;
            if (j % n != 0) {
                m2[k] = j;
                k++;
            }
        }
    }
}
