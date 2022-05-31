package Test;

import java.sql.*;
import java.util.*;

class TestOracleClient {
    public static void main(String args[]) {
        try {
            final String driver = "oracle.jdbc.driver.OracleDriver";
            final String url = "jdbc:oracle:thin:@ed05dbadm01.distr.fors.ru:1521:ukv19c1";
            final String username = "ku";
            final String password = "ku";

            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

           // Statement sqlStatement = connection.createStatement();
            Statement sqlStatement = connection.prepareStatement("select * from TEST");
//             PreparedStatement prepareStatement = connection.prepareStatement("select * from TEST");

            ResultSet queryResultSet = sqlStatement.executeQuery("select * from TEST");

            while (queryResultSet.next()) {
                System.out.println(queryResultSet.getString(1) + queryResultSet.getString(2));
            }
            queryResultSet.close();
            sqlStatement.close();
            connection.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}