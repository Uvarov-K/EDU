package QUIZ;

import java.io.*;
import java.util.*;

/*
 Исходные данные: текстовый файл со средней длиной строки равной 10 символам (файл или прошить текст в коде).

 Задание 1: Подсчитайте количество различных слов в файле.
 Задание 2: Выведите на экран список различных слов файла,
            отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
 Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 Задание 4: Выведите на экран все строки файла в обратном порядке.
 Задание 5: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.

 */

public class SB31 {

    public static void main(String[] args) throws FileNotFoundException {

        String fileName = "D:\\Win\\Java\\input.txt";
        StringBuilder tmpString = new StringBuilder();
        Scanner file = new Scanner(new File(fileName));


        while (file.hasNext()) {
            String word = file.next().toLowerCase();
            tmpString.append(word).append(" ");
        }
        file.close();

        System.out.println("Words from file as string: " + tmpString);

        String[] words = tmpString.toString().split(" ");

             // Задание 1: Подсчитайте количество различных слов в файле.

        System.out.println("Number of words in file: " + words.length);

        Map<String, Integer> treeMap = new TreeMap<>(new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length()) {
                    return -1;
                } else if (s1.length() > s2.length()) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        for (String word : words) {
            if (treeMap.containsKey(word)) {
                treeMap.put(word, treeMap.get(word) + 1);
            } else
                treeMap.put(word, 1);
        }
/*
        Задание 2:  Выведите на экран список различных слов файла,
                    отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
*/

        System.out.print("Words sorted by lengths: ");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() >= 1)
                System.out.print(entry.getKey() + " ");
        }

        //  Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.

        System.out.println();
        System.out.print("Words occurrences: ");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() >= 1)
                System.out.print(" | " + entry.getKey() + ": " + entry.getValue());
        }


        //  Задание 4: Выведите на экран все строки файла в обратном порядке.

        ArrayList<String> arr = new ArrayList<>(Arrays.asList(words));

        System.out.println();
        System.out.print("Words in reverse order: ");
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.print(arr.get(i) + " ");
        }

       // Задание 5: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.

        System.out.println();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number between 0 and " + (arr.size() - 1) + " or >" + arr.size() + " to quit");
        while (true) {
            String s = input.next();
            try {
                int number = Integer.parseInt(s);
                System.out.print("your word is: " + arr.get(number) + "\n");

                if (number > arr.size()) {
                    System.out.println("no such word");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Word with such number doesn't exist ");
                return;
            }
        }
        input.close();
    }
}


