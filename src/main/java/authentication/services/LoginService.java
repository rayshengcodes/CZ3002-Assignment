package authentication.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 * Handles Login related services
 */
public class LoginService {
    /**
     * Validates the login by executing SQL Query
     * 
     * @param conn     The connection with MySQL database
     * @param username The person's username
     * @param password The person's password
     * @return boolean variable loginSuccess indicating if the login is successful
     */
    public static boolean validateLogin(Connection conn, String username, String password) throws Exception {
        boolean loginSuccess = false;

        // SQL query to be executed
        String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        loginSuccess = rs.next();

        return loginSuccess;
    }
}
