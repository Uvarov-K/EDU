package Terminal;

import java.sql.*;
import java.util.*;


public class TerminalOperations {
    static int customer_id = 2;


    public static void showBalance() throws SQLException {
        System.out.println("Your balance is: " + BalanceOperation.getBalance(customer_id));
        MainMenu.showMenu();
    }



    public static void depositMoney() throws SQLException {
        Scanner depositMoney = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);
        boolean exitFromLoop = false;
        int balance = BalanceOperation.getBalance(customer_id);

        System.out.print("Insert your money: ");

        while (!exitFromLoop) {
            try {
                int deposited = depositMoney.nextInt();
                while (deposited < 0) {
                    System.out.println("Don't try to fuck yourself!");
                    deposited = depositMoney.nextInt();
                }
                System.out.print("You inserted: " + deposited + "\n" +
                                 "Do you want to deposit more money? [Y/y N/n]: ");

                int totalDeposited = deposited;
                // BUG with answer like 1111111
                while (!answer.next().equalsIgnoreCase("n")) {
                    System.out.print("Insert your money: ");

                    deposited = depositMoney.nextInt();
                    totalDeposited = totalDeposited + deposited;
                    System.out.print("You inserted: " + totalDeposited + "\n" +
                                     "Do you want to deposit more money? [Y/y N/n]: ");
                }


                BalanceOperation.setBalance(totalDeposited + balance, customer_id);

                System.out.println("*** sounds of cash insertion ***");
                showBalance();

                exitFromLoop = true;
            } catch (InputMismatchException | SQLException e) {
                depositMoney.next();
                System.out.println("Please enter a number! ");
            }
        }
    }



    public static void withdrawMoney() throws SQLException {
        Scanner withdrawAmount = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);
        boolean exitFromLoop = false;
        int balance = BalanceOperation.getBalance(customer_id);

        System.out.print("Available: " + balance + "\n" + "Input amount: ");
        while (!exitFromLoop) {
            try {
                int amount = withdrawAmount.nextInt();
                while (amount > balance || amount < 0) {
                    if (amount > balance) {
                        System.out.println("You can't withdraw more than " + balance);
                    } else if (amount < 0) {
                        System.out.println("Don't try to fuck me! ");
                    }
                    amount = withdrawAmount.nextInt();
                }

                System.out.print("You entered: " + amount + "\n" + "Do you want to proceed? [Y/y N/n]: ");

                String s = answer.nextLine();
                while (!s.equalsIgnoreCase("y") && !s.equalsIgnoreCase("n")) {
                    System.out.print("Incorrect symbol, type 'Y' or 'N'");
                    s = answer.nextLine();
                }
                if (s.equalsIgnoreCase("n")) {
                    System.out.println("Returning to main menu");
                    exitFromLoop = true;

                } else {
                    System.out.println("*** sounds of cash withdrawal *** ");
                    balance = balance - amount;
                    BalanceOperation.setBalance(balance, customer_id);
                    showBalance();
                    exitFromLoop = true;
                }

            } catch (InputMismatchException e) {
                withdrawAmount.next();
                System.out.println("Please enter a number! ");
            }
        }
    }
}
