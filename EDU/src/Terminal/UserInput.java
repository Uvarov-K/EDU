package Terminal;

import java.sql.*;
import java.util.*;

public class UserInput {

    public static void chooseMenu() {
        Scanner choice = new Scanner(System.in);

        try {
            int i = choice.nextInt();
            switch (i) {
                case 1:
                    TerminalOperations.depositMoney();
                    break;
                case 2:
                    TerminalOperations.withdrawMoney();
                    break;
                case 3:
                    TerminalOperations.showBalance();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("No such menu, exit");
                    break;
            }

        } catch (InputMismatchException | SQLException e) {
            System.out.println("No such menu, exit!");
        }
    }
}



