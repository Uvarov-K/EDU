package Terminal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserLogin {

    public static void checkUserCredentials() throws SQLException {

        Scanner userInput = new Scanner(System.in);

        System.out.print("enter id: ");
        int userInputtedLogin = User.userID;

        System.out.print("enter pin: ");
        int userInputtedPassword = userInput.nextInt();

        final String getUserCredentialsSQL = "select customer_id, pin from account where customer_id = ? and pin = ?";
        PreparedStatement PrepSQLStatement = DBConnection.getConnection().prepareStatement(getUserCredentialsSQL);
        PrepSQLStatement.setInt(1, userInputtedLogin);
        PrepSQLStatement.setInt(2, userInputtedPassword);


        ResultSet queryResultSet = PrepSQLStatement.executeQuery();

        if (!queryResultSet.isBeforeFirst()) {
            System.out.println("Incorrect login or pin. Exit.");


        } else {
            int customer_id = queryResultSet.getInt("customer_id");
            int pin = queryResultSet.getInt("pin");

            if (pin == userInputtedPassword & customer_id == userInputtedLogin) {
                queryResultSet.close();
                PrepSQLStatement.close();
                TerminalMenu.showMenu();

            } else {
                System.out.println("exit");

            }
        }
    }
}

