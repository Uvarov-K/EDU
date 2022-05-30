package Test;

import java.util.Scanner;

public class Terminal {
    double balance = 100;

    private void insertMoney() {
        Scanner insertMoney = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);

        System.out.print("Insert your money: ");
        double d = insertMoney.nextDouble();
        System.out.print("You inserted: " + d + "\n" +
                         "Do you want to continue? [Y/y N/n]: ");

        double sum = d;
        while (!answer.next().equals("n")) {
            System.out.print("Insert your money: ");

            d = insertMoney.nextDouble();
            sum = sum + d;
            System.out.print("You inserted: " + sum + "\n" +
                             "Do you want to continue? [Y/y N/n]: ");
        }
        balance = sum + balance;
        System.out.println("*** sounds of cash insertion ***");
        System.out.print("Your balance is: " + balance + "\n");
        menu();
    }


    private void withdrawMoney() {
        Scanner withdrawAmount = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);

        System.out.print("Available: " + balance + "\n" + "Input amount: ");
        double d = withdrawAmount.nextDouble();

        while (d > balance || d < 0) {
            System.out.println("You can't withdraw more than " + balance);
            d = withdrawAmount.nextDouble();
        }


        System.out.print("You entered: " + d + "\n" + "Do you want to proceed? [Y/y N/n]: ");

        String s = answer.nextLine();
        while (!s.equals("y") && !s.equals("n")) {
            System.out.print("Incorrect symbol, type 'Y' or 'N'");
            s = answer.nextLine();
        }
        if (s.equals("n")) {
            System.out.println("Returning to main menu");
            menu();
        } else {
            System.out.println("*** sounds of cash withdrawal *** ");
            balance = balance - d;
            System.out.println("Your balance is: " + balance);
            menu();
        }
    }


    private void showBalance() {
        System.out.println("Your balance is: " + balance);
        menu();
    }


    private void menu() {
        System.out.print(
                " ==================== \n" +
                " Available actions: \n" +
                " 1) insert money \n" +
                " 2) withdraw money \n" +
                " 3) show balance \n" +
                " 4) exit\n" +
                " ==================== \n"
        );

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        switch (i) {
            case 1:
                insertMoney();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                showBalance();
                break;
            case 4:
                break;
            default:
                break;
        }
    }


    public static void main(String[] args) {

        Terminal t = new Terminal();
        t.menu();
    }
}
