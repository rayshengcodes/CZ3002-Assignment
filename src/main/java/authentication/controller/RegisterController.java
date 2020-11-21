package authentication.controller;

import java.sql.PreparedStatement;
import java.sql.Connection;

public class RegisterController {
    public static boolean userRegister(Connection conn, String username, String password) throws Exception {
        boolean registerSuccess = false;

        // SQL query to be executed
        String sql = "INSERT INTO Login VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.executeUpdate();
        registerSuccess = true;
        return registerSuccess;
    }
}
