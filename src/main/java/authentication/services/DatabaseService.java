package authentication.services;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Handles database services
 */
public class DatabaseService {
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String SCHEMA = "ase-assignment";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * Establishes a connection with local MySQL database
     * 
     * @return connection with database
     */
    public static Connection getDatabaseConnection() {
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + SCHEMA
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
