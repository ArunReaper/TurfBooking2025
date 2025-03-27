package utility;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationUtility {

    public static String getHashedPasswordFromDatabase(String username) throws SQLException, IOException {
        //Replace this with your actual database retrieval logic.
        //Example using your DatabaseUtility class.
        ResultSet rs = DatabaseUtility.executeSelectQuery("SELECT password FROM users WHERE username = ?", username);

        if (rs.next()) {
            String hashedPassword = rs.getString("password");
            DatabaseUtility.closeResources(rs, null, null);
            return hashedPassword;
        } else {
            DatabaseUtility.closeResources(rs, null, null);
            return null;
        }
    }

    public static String getSaltFromDatabase(String username) throws SQLException, IOException {
        //Replace this with your actual database retrieval logic.
        ResultSet rs = DatabaseUtility.executeSelectQuery("SELECT salt FROM users WHERE username = ?", username);

        if (rs.next()) {
            String salt = rs.getString("salt");
            DatabaseUtility.closeResources(rs, null, null);
            return salt;
        } else {
            DatabaseUtility.closeResources(rs, null, null);
            return null;
        }
    }

}
