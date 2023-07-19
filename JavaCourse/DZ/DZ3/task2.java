/*Пусть дан произвольный список целых чисел.

2) Найти минимальное значение
3) Найти максимальное значение
4) Найти среднее значение
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class task2 {
    public static List<Integer> getRandomList(int size) {

        Random random = new Random();
        List<Integer> randomList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(100));
        }

        System.out.println(randomList.toString());
        return randomList;
    }

    public static void getRezult(List<Integer> list) {
        int min = Collections.min(list);
        int max = Collections.max(list);
        int count = list.size();
        int sum = 0;
        
        for (Integer i : list) {
            sum += i;
        }

        double aver = sum / count;

        System.out.printf("Минимальное: %d, максимальное: %d, среднее арифметичское: %f", min, max, aver);

    }

    public static void main(String[] args) {
        getRezult(getRandomList(20));
    }

}