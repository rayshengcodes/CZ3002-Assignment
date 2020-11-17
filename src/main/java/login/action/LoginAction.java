package login.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String user;
    private String password;
    private String name;

    private String ROOT_PASSWORD = "password";

    public String execute() {
        String ret = ERROR;
        Connection conn = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/ase-assignment";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", ROOT_PASSWORD);
            String sql = "SELECT name FROM login WHERE";
            sql += " user = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                name = rs.getString(1);
                ret = SUCCESS;
            }
        } catch (Exception e) {
            ret = ERROR;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
        return ret;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
