package Terminal;

import java.sql.*;

public class DBConnection {

    static Connection connectionToSQLite;

    public static Connection getConnection() {
        try {
/* connection to Oracle DB
            final String oracleJDBCDriver = "oracle.jdbc.driver.OracleDriver";
            final String url = "jdbc:oracle:thin:@hostname:1521:sid";
            final String username = "ku";
            final String password = "ku";
            Class.forName(oracleJDBCDriver);
            connectionToOracle = DriverManager.getConnection(url, username, password);


 */
            // connection to SQLite
            final String url = "jdbc:sqlite:D:\\Win\\Java/test.db";
            connectionToSQLite = DriverManager.getConnection(url);

        } catch (Exception e) {
            System.out.println("Connection Failed!");
        }

        return connectionToSQLite;
    }
}