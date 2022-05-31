package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GetColumnNamesFromResultSet_Oracle {

    public static Connection getConnection() throws Exception {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@ed05dbadm01.distr.fors.ru:1521:ok";
        String username = "ku";
        String password = "ku";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void getColumnNames(ResultSet rs) throws SQLException {
        if (rs == null) {
            return;
        }
        // get result set meta data
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();

        // get the column names; column indexes start from 1
        for (int i = 1; i < numberOfColumns + 1; i++) {
            String columnName = rsMetaData.getColumnName(i);
            // Get the name of the column's table name
            String tableName = rsMetaData.getTableName(i);
            System.out.println("column name=" + columnName + " table=" + tableName + "");
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            // prepare query
          //  String query = "select id, name, age from employees";
            String query = "select * from test";
            // create a statement
            stmt = conn.createStatement();
            // execute query and return result as a ResultSet
            rs = stmt.executeQuery(query);
            // get the column names from the ResultSet
            getColumnNames(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // release database resources
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
