package authentication.action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;

import authentication.model.Person;
import authentication.services.DatabaseService;
import authentication.services.RegisterService;

/**
 * Acts as a controller to handle actions related to registering a user.
 */
public class RegisterAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private Person personBean;

    // Input error validation
    public void validate() {
        if (personBean.getUsername().length() == 0) {
            addFieldError("personBean.username", "Username cannot be empty.");
        }
        if (personBean.getPassword().length() == 0) {
            addFieldError("personBean.password", "Password cannot be empty.");
        }
    }

    public String execute() throws Exception {
        boolean registerSuccess = false;
        Connection conn = null;
        conn = DatabaseService.getDatabaseConnection();
        if (conn == null) {
            addFieldError("error", "Unable to connect to the database.");
            return ERROR;
        }
        try {
            registerSuccess = RegisterService.userRegister(conn, personBean.getUsername(), personBean.getPassword());
        } catch (Exception e) {
            addFieldError("error", e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return registerSuccess ? SUCCESS : ERROR;
    }

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person person) {
        personBean = person;
    }

}