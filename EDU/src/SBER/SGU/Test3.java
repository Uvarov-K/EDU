package SBER.SGU;

import java.util.ArrayList;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("one");
        arr.add("two");
        arr.add("three");

        System.out.println(arr);

        String s = "";

        Scanner input = new Scanner(System.in);

       // s = input.next();

        while (!s.equals("q")) {

            try {
                s = input.next();
                int number = Integer.parseInt(s);

            } catch (Exception e) {
                System.out.println("not number");
            }


            System.out.println("s " + s);
            // System.out.println("number " +  number);
        }

        }
    }

