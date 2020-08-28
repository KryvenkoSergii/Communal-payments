package home.kryvenkosergii.communalpayments.data;
/**
 * User class.
 * @author SergiiK
 * 2020-08-24
 */
public class User {
    //
    private String email;
    private String password;
    private String userNumber;
    //
    private int userValue1;
    private int userValue2;

    //
    /**
     * Constructor with 5 parameters.
     * @param email String;
     * @param password String;
     * @param userNumber String - user's private invoice or another necessary number;
     * @param userValue1 int - resource N1: the current value on the meter;
     * @param userValue2 int - resource N2: the current value on the meter.
     */
    public User(String email, String password, String userNumber, int userValue1, int userValue2) {
        this.email = email;
        this.password = password;
        this.userNumber = userNumber;
        this.userValue1 = userValue1;
        this.userValue2 = userValue2;
    }
    
    /**
     * Constructor with 4 parameters. Parameter 'userValue2' set as int '-1'.
     * @param email String;
     * @param password String;
     * @param userNumber int - user's private invoice or another necessary number;
     * @param userValue1 int - resource N1: the current value on the meter.
     */
    public User(String email, String password, String userNumber, int userValue1) {
        this.email = email;
        this.password = password;
        this.userNumber = userNumber;
        this.userValue1 = userValue1;
        this.userValue2 = -1;
    }

    /**
     * Constructor with 4 parameters. Parameter 'userNumber' set as String '-1'.
     * @param email String;
     * @param password String;
     * @param userValue1 int - resource N1: the current value on the meter;
     * @param userValue2 int - resource N2: the current value on the meter.
     */
    public User(String email, String password, int userValue1, int userValue2) {
        this.email = email;
        this.password = password;
        this.userNumber = "-1";
        this.userValue1 = userValue1;
        this.userValue2 = userValue2;
    }

    /**
     * Default constructor.
     */
    public User() {
        this.email = "no email";
        this.password = "no password";
        this.userNumber = "-1";
        this.userValue1 = -1;
        this.userValue2 = -1;
    }

    /**
     * Getting an email.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getting a password.
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getting a userNumber
     * @return String
     */
    public String getUserNumber() {
        return userNumber;
    }

    /**
     * Getting the current value on the meter (resource N1).
     * @return int
     */
    public int getUserValue1() {
        return userValue1;
    }

    /**
     * Getting the current value on the meter (resource N2).
     * @return int
     */
    public int getUserValue2() {
        return userValue2;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + ", userNumber=" + userNumber + ", userValue1=" + userValue1
                + ", userValue2=" + userValue2 + "]";
    }

}
