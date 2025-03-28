package booktheturf.web.war.service;


import booktheturf.web.war.dto.UserRegistrationRequestDTO;
import org.mindrot.jbcrypt.BCrypt;
import utility.DatabaseUtility;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class UserRegistration {

    private static final String THIS_COMPONENT_NAME = UserRegistration.class.getName();

    private static final String INSERT_USER = "INSERT INTO users (username, hashed_password, salt, creation_date, last_login_date) VALUES (?, ?, ?, ?, ?)";

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Response registerUser(UserRegistrationRequestDTO requestDTO) throws SQLException, IOException {
        UserService userService = new UserService();
        if(userService.checkIfUserExists(requestDTO.getUsername())){
            return Response.status(Response.Status.BAD_REQUEST).entity("User Already Exists").build();
        }else {
            String hashedPassword = hashPassword(requestDTO.getPassword());
            int count = DatabaseUtility.executeUpdateQuery(INSERT_USER, requestDTO.getUsername(), hashedPassword, hashedPassword, System.currentTimeMillis(), System.currentTimeMillis());
            System.out.println(THIS_COMPONENT_NAME + "::inserted records::" + count);
            if (count > 0) {
                // User Creation successful
                return Response.ok(Map.of("message", "User successfully Registered")).build();
            } else {
                // User Creation failed
                return Response.status(Response.Status.BAD_REQUEST).entity("Unable to create a User").build();
            }
        }
    }
}