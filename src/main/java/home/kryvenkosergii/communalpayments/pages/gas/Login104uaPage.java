package home.kryvenkosergii.communalpayments.pages.gas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.LoginPage;

/**
 * Login104uaPage describes page 'https://104.ua/ua/cabinet#type=individual'.
 * Here we can fill our credentials and Sign In.
 * @author SergiiK
 * 2020-08-28
 */
public class Login104uaPage extends LoginPage {
    //
    private WebDriver driver;
    private WebDriverWait wait;

    //
    /**
     * Constructor.
     * @param driver WebDriver.
     */
    public Login104uaPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
//        wait = new WebDriverWait(driver, 10);
        //
        emailField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        signInButton = driver.findElement(By.id("password")); // add .submit
    }
    
    // functional
    /**
     * Filling fields using credentials and after that clicking button 'login'.
     * @param user User.
     * @return CabinetInfo104uaPage class.
     */
    public CabinetInfo104uaPage signIn (User user) {
        clickEmailField(driver);
        clearEmailField();
        inputEmail(user.getEmail());
        //
        clickPasswordField(driver);
        clearPasswordField();
        inputPassword(user.getPassword());
        //
        getsignInButtonField().submit();
        //
        return new CabinetInfo104uaPage(driver, user);
    }
}
