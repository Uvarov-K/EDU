package Terminal;

import java.sql.SQLException;

public class MainMenu {
    public static void showLoginScreen() throws SQLException {
        System.out.print(
                " ********************************************* \n" +
                " *      WELCOME TO OUR CASINO BANK 777       *\n" +
                " ********************************************* \n" +
                "     ____________________________________ \n" +
                "    | To get access to all world's money |\n" +
                "    | enter your CLIENT ID and your PIN  |\n" +
                "    ------------------------------------- \n"
        );

        UserLogin.checkUserCredentials();
    }

    public static void main(String[] args) throws SQLException {
        MainMenu.showLoginScreen();


    }


}
