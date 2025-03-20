package booktheturf.web.war;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

public class DatabaseConnection {

    private static HikariDataSource dataSource;

    public static Connection getConnection() throws SQLException, IOException {
        if (dataSource == null) {
            Properties props = new Properties();
            try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
                if(input == null){
                    System.out.println("Sorry, unable to find database.properties");
                    return null;
                }
                props.load(input);
            }

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(props.getProperty("db.url"));
            config.setUsername(props.getProperty("db.username"));
            config.setPassword(props.getProperty("db.password"));
            config.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Or com.mysql.jdbc.Driver for older versions
            config.setMaximumPoolSize(10); // Adjust as needed
            dataSource = new HikariDataSource(config);
        }
        return dataSource.getConnection();
    }
}