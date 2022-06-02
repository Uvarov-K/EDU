package Terminal;

import java.sql.*;
import java.util.*;

import static Terminal.DBConnection.connectionToOracle;

public class TerminalOperations {
    static int customer_id = 2;
    static double balance = 500;


    public static void getBalance() throws SQLException {

        final String showBalanceSQL = "select amount from balance where customer_id = ?";
        PreparedStatement PrepSQLStatement = DBConnection.getConnection().prepareStatement(showBalanceSQL);
        PrepSQLStatement.setInt(1, customer_id);
        ResultSet queryResultSet = PrepSQLStatement.executeQuery();

        while (queryResultSet.next()) {
            System.out.println("Your balance is: " + queryResultSet.getInt(1));
        }

        queryResultSet.close();
        PrepSQLStatement.close();
        connectionToOracle.close();

    }




    public static void depositMoney() {
        Scanner depositMoney = new Scanner(System.in);
        Scanner answer = new Scanner(System.in);
        boolean exitFromLoop = false;

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
                while (!answer.next().equalsIgnoreCase("n")) {
                    System.out.print("Insert your money: ");

                    deposited = depositMoney.nextInt();
                    totalDeposited = totalDeposited + deposited;
                    System.out.print("You inserted: " + deposited + "\n" +
                                     "Do you want to deposit more money? [Y/y N/n]: ");
                }

                final String updateBalanceSQL = "update balance set amount = ? where customer_id = ?";
                PreparedStatement PrepSQLStatement = DBConnection.getConnection().prepareStatement(updateBalanceSQL);
                PrepSQLStatement.setInt(1, totalDeposited);
                PrepSQLStatement.setInt(2, customer_id);
                PrepSQLStatement.executeUpdate();


                PrepSQLStatement.close();
                DBConnection.connectionToOracle.close();

                System.out.println("*** sounds of cash insertion ***");
                getBalance();

                exitFromLoop = true;
                //  showMenu();
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
                    //showMenu();
                } else {
                    System.out.println("*** sounds of cash withdrawal *** ");
                    balance = balance - amount;
                    System.out.println("Your balance is: " + balance);
                    exitFromLoop = true;
                   // showMenu();
                }

            } catch (InputMismatchException e) {
                withdrawAmount.next();
                System.out.println("Please enter a number! ");
            }
        }
    }








}
