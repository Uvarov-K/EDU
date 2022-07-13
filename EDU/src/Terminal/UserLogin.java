package Terminal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static Terminal.DBConnection.connectionToSQLite;

public class UserLogin {

    public void checkUserCredentials() throws SQLException {

        Scanner userInput = new Scanner(System.in);

        System.out.print("enter id: ");
        int userInputtedLogin = userInput.nextInt();

        System.out.print("enter pin: ");
        int userInputtedPassword = userInput.nextInt();

        final String getUserCredentialsSQL = "select customer_id, pin from account where customer_id = ? and pin = ?";
        PreparedStatement PrepSQLStatement = DBConnection.getConnection().prepareStatement(getUserCredentialsSQL);
        PrepSQLStatement.setInt(1, userInputtedLogin);
        PrepSQLStatement.setInt(2, userInputtedPassword);


        int loginAttempt = 0;

        while (loginAttempt < 3) {

            ResultSet queryResultSet = PrepSQLStatement.executeQuery();

            if (!queryResultSet.isBeforeFirst()) {
                System.out.println("Incorrect login or pin.");
                System.out.println("Attempts available: " + (3 - loginAttempt) + "/3");

                System.out.print("enter id: ");
                userInputtedLogin = userInput.nextInt();

                System.out.print("enter pin: ");
                userInputtedPassword = userInput.nextInt();

                queryResultSet = PrepSQLStatement.executeQuery();

            } else {
                int customer_id = queryResultSet.getInt("customer_id");
                int pin = queryResultSet.getInt("pin");

                if (pin == userInputtedPassword & customer_id == userInputtedLogin) {
                    System.out.println("correct. database is opened");
                    queryResultSet.close();
                    PrepSQLStatement.close();
                    DBConnection.connectionToSQLite.close();
                    break;

                } else {
                    System.out.println("exit");
                }
            }
            loginAttempt++;
        }
    }
}