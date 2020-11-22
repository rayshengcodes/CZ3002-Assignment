package authentication.services;

import java.sql.PreparedStatement;
import java.sql.Connection;

/**
 * Handles Registration related services
 */
public class RegisterService {
    /**
     * @param conn     The connection with MySQL database
     * @param username The person's username
     * @param password The person's password
     * @return boolean variable registerSuccess indicating if the registration is
     *         successful
     */
    public static boolean userRegister(Connection conn, String username, String password) throws Exception {
        boolean registerSuccess = false;

        // SQL query to be executed
        String sql = "INSERT INTO login VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.executeUpdate();
        registerSuccess = true;
        return registerSuccess;
    }
}
