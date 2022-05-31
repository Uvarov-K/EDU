package Test;

import java.sql.*;
public class TestPostgresClient {
    public static void main(String[] args)
            throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://132.226.131.93:5432/appdb",
                "app", "welcome1");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT * FROM greeting");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        rs.close();
        st.close();
        conn.close();
    }
}





