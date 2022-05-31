package Test;

import java.sql.*;

public class ShowBalanceT {
    static int cust_id = 1;

    public static void main(String args[]) {
        try {
            final String driver = "oracle.jdbc.driver.OracleDriver";
            final String url = "jdbc:oracle:thin:@ed05dbadm01.distr.fors.ru:1521:ukv19c1";
            final String username = "ku";
            final String password = "ku";

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement prepareStatement = connection.prepareStatement("select amount from balance where cust_id=" + cust_id);
            ResultSet queryResultSet = prepareStatement.executeQuery();

            while (queryResultSet.next()) {
                System.out.println("Your balance is: " + queryResultSet.getInt(1));
            }

            PreparedStatement prepareUpdStatement = connection.prepareStatement("update balance set amount=300 where cust_id=" + cust_id);
           // connection.commit();
            prepareStatement.executeUpdate();
           // connection.commit();


            while (queryResultSet.next()) {
                System.out.println("Your balance is: " + queryResultSet.getInt(1));
            }

            queryResultSet.close();
            prepareStatement.close();
            connection.close();
            prepareUpdStatement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}