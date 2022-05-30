package Test;

import java.util.*;

public class Terminal {
    double balance = 100;

    private void depositMoney() {
        Scanner depositMoney = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);

        System.out.print("Insert your money: ");
        double d = depositMoney.nextDouble();
        System.out.print("You inserted: " + d + "\n" +
                         "Do you want to continue? [Y/y N/n]: ");

        double sum = d;
        while (!answer.next().equalsIgnoreCase("n")) {
            System.out.print("Insert your money: ");

            d = depositMoney.nextDouble();
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
        boolean isTrue = false;

        System.out.print("Available: " + balance + "\n" + "Input amount: ");

        while (!isTrue) {
            try {
                double d = withdrawAmount.nextDouble();
                while (d > balance || d < 0) {
                    if (d > balance) {
                        System.out.println("You can't withdraw more than " + balance);
                    } else if (d < 0) {
                        System.out.println("Don't try to fuck me! ");
                    }
                    d = withdrawAmount.nextDouble();
                }

                System.out.print("You entered: " + d + "\n" + "Do you want to proceed? [Y/y N/n]: ");

                String s = answer.nextLine();
                while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
                    System.out.print("Incorrect symbol, type 'Y' or 'N'");
                    s = answer.nextLine();
                }
                if (s.equalsIgnoreCase("n")) {
                    System.out.println("Returning to main menu");
                    isTrue = true;
                    menu();
                } else {
                    System.out.println("*** sounds of cash withdrawal *** ");
                    balance = balance - d;
                    System.out.println("Your balance is: " + balance);
                    isTrue = true;
                    menu();
                }

            } catch (InputMismatchException e) {
                withdrawAmount.next();
                System.out.println("Please enter a number! ");

            }

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
                " 1) deposit money \n" +
                " 2) withdraw money \n" +
                " 3) show balance \n" +
                " 4) exit\n" +
                " ==================== \n"
        );

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        switch (i) {
            case 1:
                depositMoney();
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
