package SBER.SGU.q2056;

import java.io.*;
import java.util.*;

public class Solution_v2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String line = null;
        StringBuilder tmp = new StringBuilder(" ");

        while (!(line = keyboard.nextLine()).isEmpty()) {
            tmp.append(line.toLowerCase()).append(" ");
        }

        String[] words = tmp.toString().split("\\s+");

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