package authentication.action;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;

import authentication.controller.DatabaseController;
import authentication.controller.LoginController;
import authentication.model.Person;

public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private Person personBean;

    public String execute() {
        boolean loginSuccess = false;
        Connection conn = null;

        if (personBean == null) {
            addFieldError("error", "Personbean does not exist");
            return ERROR;
        }
        if (personBean.getUsername() == null || personBean.getPassword() == null) {
            addFieldError("error", "Invalid input: Username or password field is null");
            return ERROR;
        }
        if (personBean.getUsername().length() == 0 || personBean.getPassword().length() == 0) {
            addFieldError("error", "Invalid input: Username or password field is empty");
            return ERROR;
        }
        conn = DatabaseController.getDatabaseConnection();
        if (conn == null) {
            addFieldError("error", "Unable to connect to the database.");
            return ERROR;
        }
        try {
            loginSuccess = LoginController.validateLogin(conn, personBean.getUsername(), personBean.getPassword());
        } catch (Exception e) {
            addFieldError("error", e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return loginSuccess ? SUCCESS : ERROR;
    }

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person person) {
        personBean = person;
    }
}
