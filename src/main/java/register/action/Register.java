package register.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;
import login.model.Person;

/**
 * Acts as a controller to handle actions related to registering a user.
 *
 */
public class Register extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String ROOT_PASSWORD = "";

    private Person personBean;

    public String execute() throws Exception {
        String ret = ERROR;
        Connection conn = null;

        try {
            if (this.personBean.getUsername().length() == 0 || this.personBean.getPassword().length() == 0
                    || this.personBean.getName().length() == 0) {
                return "error2";
            }
            String URL = "jdbc:mysql://localhost:3306/ase-assignment";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", ROOT_PASSWORD);
            String sql = "INSERT INTO Login VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, personBean.getUsername());
            ps.setString(2, personBean.getPassword());
            ps.setString(3, personBean.getName());
            System.out.println(ps);
            ps.executeUpdate();
            ret = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            ret = ERROR;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
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