package Terminal;

import java.sql.*;

public class DBConnection {

    static Connection connectionToOracle;

    public static Connection getConnection() {
        try {

            final String oracleJDBCDriver = "oracle.jdbc.driver.OracleDriver";
            final String url = "jdbc:oracle:thin:@ed05dbadm01.distr.fors.ru:1521:ukv19c1";
            final String username = "ku";
            final String password = "ku";
            Class.forName(oracleJDBCDriver);
            connectionToOracle = DriverManager.getConnection(url, username, password);
            System.out.println("connected");

        } catch (Exception e) {
            System.out.println("Connection Failed!");
        }

        return connectionToOracle;
    }
}