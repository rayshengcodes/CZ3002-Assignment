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

    /**
     * Handles validation of user input
     */
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
        // Establish connection with MySQL database
        conn = DatabaseService.getDatabaseConnection();
        if (conn == null) { // Handles event of failing to connect to database
            addFieldError("error", "Unable to connect to the database.");
            return ERROR;
        }
        try {
            // Registers user via SQL query
            registerSuccess = RegisterService.userRegister(conn, personBean.getUsername(), personBean.getPassword());
        } catch (Exception e) { // Handles exception thrown by userRegister
            addFieldError("error", e.getMessage());
        } finally { // Closes connection with the database
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // returns SUCCESS or ERROR event depending on whether registration is
        // successful
        return registerSuccess ? SUCCESS : ERROR;
    }

    /**
     * Gets personBean variable
     * 
     * @return Person object
     */
    public Person getPersonBean() {
        return personBean;
    }

    /**
     * Sets personBean variable
     * 
     * @param person Person object
     */
    public void setPersonBean(Person person) {
        personBean = person;
    }

}