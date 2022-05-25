package Test;

import java.util.Scanner;

public class Terminal {
    double balance = 100;

    private void insertMoney() {
        Scanner insertMoney = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);

        System.out.println("Insert your money ");
        double d = insertMoney.nextDouble();
        System.out.println("You inserted: " + d + "\n" +
                "Do you want to continue? [Y/y N/n]");

        double sum = d;
        while (!answer.next().equals("n")) {
            System.out.println("Insert your money");

            d = insertMoney.nextDouble();
            sum = sum + d;
            System.out.println("You inserted: " + sum + "\n" +
                    "Do you want to continue? [Y/y N/n]");
        }
        balance = sum + balance;
        System.out.println("Your balance is: " + balance + "\n");
        menu();
    }


    private void withdrawMoney() {
        Scanner withdrawMoney = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);

        System.out.println("Input amount ");
        double d = withdrawMoney.nextDouble();
        System.out.println("You inputted: " + d + "\n" +
                "Do you want to continue? [Y/y N/n]");

        double sum = d;
        while (!answer.next().equals("n")) {
            System.out.println("Input amount");

            d = withdrawMoney.nextDouble();
            sum = sum + d;
            System.out.println("You inputted: " + sum + "\n" +
                    "Do you want to continue? [Y/y N/n]");
        }
        balance = balance - sum;
        System.out.println("Your balance is: " + balance + "\n");
        menu();
    }


    private void showBalance() {
        System.out.println("Your balance is: " + balance);
        menu();
    }


    private void menu() {
        System.out.println(
                """
                         ====================\s
                         Available actions:\s
                         1) insert money\s
                         2) withdraw money\s
                         3) show balance\s
                         4) exit
                         ====================\s
                        """
        );

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        switch (i) {
            case 1: insertMoney(); break;
            case 2: withdrawMoney(); break;
            case 3: showBalance(); break;
            case 4: break;
            default: break;
        }
    }


    public static void main(String[] args) {

        Terminal t = new Terminal();
        t.menu();
    }
}
