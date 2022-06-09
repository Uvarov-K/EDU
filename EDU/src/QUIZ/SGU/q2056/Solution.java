package QUIZ.SGU.q2056;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        String[] words = inputLine.toLowerCase().split(" ");


        TreeMap<String, Integer> wordToCount = new TreeMap<>();

        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }

        wordToCount.forEach((key, value) -> {
            if (value > 1) {
                System.out.println(key);
            }
        });

    }
}