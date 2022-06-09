package QUIZ.SGU;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("one");
        arr.add("two");
        arr.add("three");

        System.out.println(arr);

        String s = "";

        Scanner input = new Scanner(System.in);

        while (!s.equalsIgnoreCase("q")) {
            System.out.println("Enter a number between 0 and " + (arr.size() - 1) + " or q to quit");


            try {
                s = input.next();
                if (s.equalsIgnoreCase("q")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("not q");
            }


            try {




                int number = Integer.parseInt(s);
                System.out.println("your word is: " + arr.get(number));
                if (number > arr.size()) {
                    System.out.println("no such number");

                } //else
                //System.out.println("your word is: " + arr.get(number));

            } catch (Exception e) {
                System.out.println("quit ");

            }


        }
    }
}

