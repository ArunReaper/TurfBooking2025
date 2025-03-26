package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {

    public static ResultSet executeSelectQuery(String query) throws SQLException, IOException {
        System.out.println("::getDataFromDatabase");

        Connection conn = DatabaseConnection.getConnection();
        assert conn != null;
        Statement stmt = conn.createStatement();

        //rs.close();
        //stmt.close();
        //conn.close(); // Don't close the connection here when using a connection pool
        return stmt.executeQuery(query);
    }

}
