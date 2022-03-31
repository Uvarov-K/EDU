package SGU.q2003;

import java.util.Scanner;

/*
2003. Альтернированная сумма чисел

Альтернированной суммой заданной последовательности n чисел a1, a2,..., an
называется число s=a1-a2+a3-a4+....
В альтернированной сумме знаки слагаемых чередуются, альтернация начинается со знака "+".

По заданной последовательности целых чисел выведите ее альтернированную сумму.

Входные данные
В первой строке задано целое число n (1 ≤ n ≤ 10000).
Вторая строка содержит n целых чисел, каждое от 1 до 10000 включительно.

Выходные данные
Выведите искомую альтернированную сумму.

 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int altsum = 0;

        int count = scanner.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                altsum += arr[i];
            } else altsum += -arr[i];
        }
        System.out.println(altsum);
    }
}
