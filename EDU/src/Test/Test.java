package Test;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Test  {
    public static void main(String[] args) {

        double balance = 100;
        Scanner withdrawAmount = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);


        while (true) {
            try {
                System.out.print("Available: " + balance + "\n" + "Input amount: ");
                double d = withdrawAmount.nextDouble();
                while (d > balance || d < 0) {
                    System.out.println("You can't withdraw more than " + balance);
                    d = withdrawAmount.nextDouble();
                }
                System.out.print("You entered: " + d + "\n" + "Do you want to proceed? [Y/y N/n]: ");

            } catch (InputMismatchException e) {
                withdrawAmount.next();
                System.out.print("That’s not an integer. Try again: ");

            }
        }



    }

}

