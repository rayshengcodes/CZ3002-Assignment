package login.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import login.model.Person;

public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String ROOT_PASSWORD = "";

    private Person personBean;

    public String execute() {
        String ret = ERROR;
        Connection conn = null;

        try {
            if (this.personBean.getUsername().length() == 0 || this.personBean.getPassword().length() == 0) {
                return "error2";
            }
            String URL = "jdbc:mysql://localhost:3306/ase-assignment";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", ROOT_PASSWORD);
            String sql = "SELECT * FROM login WHERE";
            sql += " username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, personBean.getUsername());
            ps.setString(2, personBean.getPassword());
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString(3);
                personBean.setName(name);
                ret = SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person person) {
        personBean = person;
    }
}
