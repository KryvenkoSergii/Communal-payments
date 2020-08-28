package home.kryvenkosergii.communalpayments.pages.water;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.LoginPage;

/**
 * LoginInfoLvivPage describes page 'https://infolviv.com.ua/login'.
 * Here we can fill our credentials and Sign In.
 * @author SergiiK
 * 2020-08-28
 */
public class LoginInfoLvivPage extends LoginPage {
    //
    private WebDriver driver;
    private WebDriverWait wait;

    //
    /**
     * Constructor.
     * @param driver WebDriver.
     */
    public LoginInfoLvivPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
//        wait = new WebDriverWait(driver, 10);
        //
        emailField = driver.findElement(By.id("user_email"));
        passwordField = driver.findElement(By.id("user_password"));
        signInButton = driver.findElement(By.id("user_password")); // add .submit
    }
    
    // functional
    /**
     * Filling fields using credentials and after that clicking button 'login'.
     * @param user User.
     * @return CabinetInfoLvivPage class.
     */
    public CabinetInfoLvivPage signIn (User user) {
        clickEmailField(driver);
        clearEmailField();
        inputEmail(user.getEmail());
        //
        clickPasswordField(driver);
        clearPasswordField();
        inputPassword(user.getPassword());
        //
//        getsignInButtonField().submit(); // automatically entering after input password !!!
//        clickSignInButton(driver);
        //
        return new CabinetInfoLvivPage(driver, user);
    }
}
