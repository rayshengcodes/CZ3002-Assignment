package authentication.model;

/**
 * Represents a person class
 */
public class Person {
    /**
     * Username and password of person
     */
    private String username;
    private String password;

    /**
     * Get method for username
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set method for username
     * 
     * @param username The person's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get method for password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set method for password
     * 
     * @param password The person's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the Person.
     * 
     * @return string representing Person (username)
     */
    public String toString() {
        return getUsername();
    }
}
