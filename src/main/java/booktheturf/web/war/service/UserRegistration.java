package booktheturf.web.war.service;


import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserRegistration {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    //Example of how to insert user into the database.
    public void insertUser(String username, String password) throws SQLException {
        String hashedPassword = hashPassword(password);
        //Your database logic goes here.
        //use prepared statements to prevent sql injection.
        String insertSQL = "INSERT INTO users (username, hashed_password) VALUES (?, ?)";
        //execute insertSQL...
    }

}