package Terminal;

import java.sql.*;
import java.util.*;

import static Terminal.DBConnection.connectionToOracle;

public class BalanceOperation {

    public static int getBalance(int customer_id) throws SQLException {

        final String showBalanceSQL = "select amount from balance where customer_id = ?";
        PreparedStatement PrepSQLStatement = DBConnection.getConnection().prepareStatement(showBalanceSQL);
        PrepSQLStatement.setInt(1, customer_id);
        ResultSet queryResultSet = PrepSQLStatement.executeQuery();

        queryResultSet.next();
        int userBalance = queryResultSet.getInt(1);

        queryResultSet.close();
        PrepSQLStatement.close();
        connectionToOracle.close();
        return userBalance;

    }


    public static void setBalance(int amount, int customer_id) throws SQLException {

        final String updateBalanceSQL = "update balance set amount = ? where customer_id = ?";
        PreparedStatement PrepSQLStatement = DBConnection.getConnection().prepareStatement(updateBalanceSQL);
        PrepSQLStatement.setInt(1, amount);
        PrepSQLStatement.setInt(2, customer_id);
        PrepSQLStatement.executeUpdate();

        PrepSQLStatement.close();
        connectionToOracle.close();
    }
}
