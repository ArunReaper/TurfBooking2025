package utility;

import utility.DatabaseUtility;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserUtility { //Changed class name to avoid confusion with the DatabaseUtility class.
    private static final String THIS_COMPONENT_NAME = UserUtility.class.getName();

    public static boolean isUserExist(String userId) throws SQLException, IOException {
        ResultSet rs = null;
        try {
            rs = DatabaseUtility.executeSelectQuery("SELECT count(1) FROM USERS WHERE username = ?", userId);

            if (rs.next()) {
                int count = rs.getInt(1); // Retrieve the count value
                System.out.println(THIS_COMPONENT_NAME + "::count::"+count);
                return count > 0;
            } else {
                return false; // No rows returned, user doesn't exist
            }
        } finally {
            DatabaseUtility.closeResources(rs, null, null); // Close ResultSet
        }
    }
}