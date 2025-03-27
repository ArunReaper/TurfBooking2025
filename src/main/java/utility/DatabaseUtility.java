package utility;

import java.io.IOException;
import java.sql.*;

public class DatabaseUtility {

    public static ResultSet executeSelectQuery(String query, Object... params) throws SQLException, IOException {
        System.out.println("::getDataFromDatabase");

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DatabaseConnection.getConnection();
            if (conn == null) {
                throw new SQLException("Failed to get database connection.");
            }

            preparedStatement = conn.prepareStatement(query);

            // Set parameters if any
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }

            resultSet = preparedStatement.executeQuery();
            return resultSet; // The calling function is now responsible for closing the ResultSet.

        } catch (SQLException e) {
            // Log the error or handle it as needed
            System.err.println("Database error: " + e.getMessage());
            throw e; // Re-throw the exception to the caller
        }
    }

    public static void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            //connection.close(); // Only close if not using a connection pool.
        }
    }
}