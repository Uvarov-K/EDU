package Terminal;

import java.sql.*;
import java.util.*;

public class MainMenu {

    public static void showMenu() {
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


    public static void main(String[] args) {
        MainMenu.showMenu();
    }
}
