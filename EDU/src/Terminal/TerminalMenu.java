package Terminal;

import java.sql.*;

public class TerminalMenu {

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

        UserInput.chooseMenu();

    }


}
