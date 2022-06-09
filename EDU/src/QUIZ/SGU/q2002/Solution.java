package QUIZ.SGU.q2002;

import java.util.Scanner;

/*
Задано n целых чисел. Выведите их сумму.

Входные данные
В первой строке задано целое число n (1 ≤ n ≤ 10000).
Вторая строка содержит n целых чисел, каждое от 1 до 10000, включительно.

Выходные данные
Выведите искомую сумму.

 */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            sum += scanner.nextInt();
        }
        scanner.close();
        System.out.println(sum);
    }
}
