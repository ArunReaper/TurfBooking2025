package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {

    public final String THIS_COMPONENT_NAME = this.getClass().getName();

    public static ResultSet executeSelectQuery(String query) throws SQLException, IOException {
        System.out.println("getDataFromDatabase");

        Connection conn = DatabaseConnection.getConnection();
        assert conn != null;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM LANDINGPAGE");

        rs.close();
        stmt.close();
        //conn.close(); // Don't close the connection here when using a connection pool
        return rs;
    }

}
