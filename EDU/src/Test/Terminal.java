package Test;

import java.util.*;

public class Terminal {
    double balance = 100;

    private void depositMoney() {
        Scanner depositMoney = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);
        boolean exitLoop = false;

        System.out.print("Insert your money: ");

        while (!exitLoop) {
            try {
                double amount = depositMoney.nextDouble();
                while (amount < 0) {
                    System.out.println("Don't try to fuck yourself!");
                    amount = depositMoney.nextDouble();
                }
                System.out.print("You inserted: " + amount + "\n" +
                                 "Do you want to deposit more money? [Y/y N/n]: ");

                double deposited = amount;
                while (!answer.next().equalsIgnoreCase("n")) {
                    System.out.print("Insert your money: ");

                    amount = depositMoney.nextDouble();
                    deposited = deposited + amount;
                    System.out.print("You inserted: " + deposited + "\n" +
                                     "Do you want to deposit more money? [Y/y N/n]: ");
                }

                balance = deposited + balance;
                System.out.println("*** sounds of cash insertion ***");
                System.out.print("Your balance is: " + balance + "\n");
                exitLoop = true;
                showMenu();
            } catch (InputMismatchException e) {
                depositMoney.next();
                System.out.println("Please enter a number! ");
            }

        }
    }


    private void withdrawMoney() {
        Scanner withdrawAmount = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);
        boolean exitLoop = false;

        System.out.print("Available: " + balance + "\n" + "Input amount: ");

        while (!exitLoop) {
            try {
                double amount = withdrawAmount.nextDouble();
                while (amount > balance || amount < 0) {
                    if (amount > balance) {
                        System.out.println("You can't withdraw more than " + balance);
                    } else if (amount < 0) {
                        System.out.println("Don't try to fuck me! ");
                    }
                    amount = withdrawAmount.nextDouble();
                }

                System.out.print("You entered: " + amount + "\n" + "Do you want to proceed? [Y/y N/n]: ");

                String s = answer.nextLine();
                while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
                    System.out.print("Incorrect symbol, type 'Y' or 'N'");
                    s = answer.nextLine();
                }
                if (s.equalsIgnoreCase("n")) {
                    System.out.println("Returning to main menu");
                    exitLoop = true;
                    showMenu();
                } else {
                    System.out.println("*** sounds of cash withdrawal *** ");
                    balance = balance - amount;
                    System.out.println("Your balance is: " + balance);
                    exitLoop = true;
                    showMenu();
                }

            } catch (InputMismatchException e) {
                withdrawAmount.next();
                System.out.println("Please enter a number! ");
            }
        }
    }


    private void showBalance() {
        System.out.println("Your balance is: " + balance);
        showMenu();
    }


    private void showMenu() {
        System.out.print(
                " ==================== \n" +
                " Available actions: \n" +
                " 1) deposit money \n" +
                " 2) withdraw money \n" +
                " 3) show balance \n" +
                " 4) exit\n" +
                " ==================== \n"
        );

        Scanner choice = new Scanner(System.in);

        try {
            int i = choice.nextInt();
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
                    System.out.println("No such menu, exit");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("No such menu, exit!");
        }
    }


    public static void main(String[] args) {

        Terminal t = new Terminal();
        t.showMenu();
    }
}
