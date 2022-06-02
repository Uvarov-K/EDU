package Terminal;

import java.sql.*;

public class ShowBalanceT {
    static int cust_id = 2;

    public static void main(String args[]) {
        try {
            final String driver = "oracle.jdbc.driver.OracleDriver";
            final String url = "jdbc:oracle:thin:@ed05dbadm01.distr.fors.ru:1521:ukv19c1";
            final String username = "ku";
            final String password = "ku";
            final String showBalanceSQL = "select amount from balance where cust_id = ?";

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement PrepSqlStatement = connection.prepareStatement(showBalanceSQL);
            PrepSqlStatement.setInt(1, cust_id);
            ResultSet queryResultSet = PrepSqlStatement.executeQuery();

            while (queryResultSet.next()) {
                System.out.println("Your balance is: " + queryResultSet.getInt(1));
            }

            queryResultSet.close();
            PrepSqlStatement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}