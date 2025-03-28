package booktheturf.web.war.service;

import utility.UserUtility;

import java.io.IOException;
import java.sql.SQLException;

public class UserService {
    private static final String THIS_COMPONENT_NAME = UserRegistration.class.getName();

    public boolean checkIfUserExists(String username) throws SQLException, IOException {
        boolean isUserExist = UserUtility.isUserExist(username);
        System.out.println(THIS_COMPONENT_NAME+ "::isUserExist::" + isUserExist);
        return isUserExist;
    }
}