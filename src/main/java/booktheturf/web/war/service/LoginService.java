package booktheturf.web.war.service;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import booktheturf.web.war.dto.LoginRequestDTO;
import org.mindrot.jbcrypt.BCrypt;
import utility.AuthenticationUtility;
import utility.UserUtility;

public class LoginService {

    private static final String THIS_COMPONENT_NAME = LoginService.class.getName();

    public Response login(LoginRequestDTO loginRequestDTO) throws SQLException, IOException {

        String username = loginRequestDTO.getUsername();
        String password = AuthenticationUtility.hashPassword(loginRequestDTO.getPassword());

        String storedHashedPassword = AuthenticationUtility.getHashedPasswordFromDatabase(username); //Retrieve from database.
        String storedSalt = AuthenticationUtility.getSaltFromDatabase(username); //Retrieve from Database.

        if (storedHashedPassword == null || storedSalt == null || !UserUtility.isUserExist(username)) {
            // User not found or password not set
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }

        boolean passwordMatch = BCrypt.checkpw(password, storedHashedPassword);

        if (passwordMatch) {
            // Login successful
            return Response.ok(Map.of("message", "Login successful")).build();
        } else {
            // Login failed
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid username or password").build();
        }
    }
}