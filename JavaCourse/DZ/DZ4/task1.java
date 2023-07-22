/*
 *Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из
  их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть
отрицательными.

Tryapitsyn V L - GeekBrains

 */

 
import java.util.ArrayDeque;

import java.util.Deque;




/**
 * Класс, реализующий операции умножения и сложения двух чисел в виде связанных списков.
 */
public class task1 {

    /**
     * Метод для умножения двух чисел, представленных в виде связанных списков.
     *
    
     */
    public static Deque<Integer> multiply(Deque<Integer> d1, Deque<Integer> d2) {
        // Создаем новый связанный список для хранения результата умножения
        Deque<Integer> result = new ArrayDeque<>();
        Deque<Integer> num1 = new ArrayDeque<>();
        Deque<Integer> num2 = new ArrayDeque<>();

        num1.addAll(d1);
        num2.addAll(d2);

        boolean isNegative1 = (num1.getLast() < 0);
        boolean isNegative2 = (num2.getLast() < 0);
        boolean isNegative = isNegative1 ^ isNegative2;

        // Убираем знаки минус из чисел
        if(isNegative1)
           num1.removeLast();
        if(isNegative2)
           num2.removeLast();

        // Инициализируем массив для хранения промежуточных результатов умножения
        int[] intermediateResults = new int[num1.size() + num2.size()];

        // Выполняем умножение цифр
        for (int i = 0; i < num1.size(); i++) {
            int digit1 = num1.removeFirst();
            int carry = 0;

            for (int j = 0; j < num2.size(); j++) {
                int digit2 = num2.removeFirst();
                int product = digit1 * digit2 + intermediateResults[i + j] + carry;

                intermediateResults[i + j] = product % 10;
                carry = product / 10;
                num2.addLast(digit2);
            }

            if (carry > 0) {
                intermediateResults[i + num2.size()] += carry;
            }

            num1.addLast(digit1);
        }

        // Удаляем ведущие нули из промежуточных результатов
        int i = intermediateResults.length - 1;
        while (i >= 0 && intermediateResults[i] == 0) {
            i--;
        }

        // Формируем итоговый связанный список       

        while (i >= 0) {
            result.addLast(intermediateResults[i]);
            i--;
        }

        if (isNegative) {
            result.addLast(-1);
        }

        return result;
    }

    /**
     * Метод для сложения двух чисел, представленных в виде связанных списков.
     *
     *
     */
    public static Deque<Integer> add(Deque<Integer> d1, Deque<Integer> d2) {
        // Создаем новый связанный список для хранения результата сложения
        Deque<Integer> result = new ArrayDeque<>();

        Deque<Integer> num1 = new ArrayDeque<>();
        Deque<Integer> num2 = new ArrayDeque<>();

        num1.addAll(d1);
        num2.addAll(d2);

        // Проверяем, является ли одно из чисел отрицательным
        boolean isNegative1 = (num1.getLast() < 0);
        boolean isNegative2 = (num2.getLast() < 0);
        
        int sign1 = isNegative1 ? -1 : 1;
        int sign2 = isNegative2 ? -1 : 1;
    
        // Убираем знаки минус из чисел
        if(isNegative1)
           num1.removeLast();
        if(isNegative2)
           num2.removeLast();

        int carry = 0;

        // Выполняем сложение цифр
        int sum = 0;
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int digit1 = num1.isEmpty() ? 0 : num1.removeFirst();
            int digit2 = num2.isEmpty() ? 0 : num2.removeFirst();
            sum = digit1*sign1 + digit2*sign2 + carry;

            result.addFirst(Math.abs(sum % 10));
            carry = sum / 10;
        }

        if (Math.abs(carry) > 0) {
            result.addFirst(Math.abs(carry));
        }
        
        // Добавляем знак минус, если необходимо
        if(sum < 0){
            result.addLast(-1);
        }

        return result;
    }

    
    public static void main(String[] args) {
       
         // Создаем первое число
         Deque<Integer> d1 = new ArrayDeque<>();
         d1.addLast(7);
         d1.addLast(2);
         d1.addLast(7);
         d1.addLast(-1); // Минус перед числом
 
         // Создаем второе число
         Deque<Integer> d2 = new ArrayDeque<>();
         d2.addLast(5);
         d2.addLast(4);
         d2.addLast(3);
         d2.addLast(-1); // Минус перед числом

        // Умножение чисел
        Deque<Integer> product = multiply(d1, d2);
        System.out.println("Умножение: " + product);

        // Сложение чисел
        Deque<Integer> sum = add(d1, d2);
        System.out.println("Сложение: " + sum);
    }
}
