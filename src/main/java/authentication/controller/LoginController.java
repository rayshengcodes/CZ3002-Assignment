package authentication.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class LoginController {
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
