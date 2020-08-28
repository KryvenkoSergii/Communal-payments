package home.kryvenkosergii.communalpayments.pages.electricity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.LoginPage;

/**
 * LoginLOEPage describes page 'https://info.loe.lviv.ua'.
 * Here we can fill our credentials and Sign In.
 * @author SergiiK
 * 2020-08-27
 */
public class LoginLOEPage extends LoginPage {
    //
    private WebDriver driver;
    private WebDriverWait wait;

    //
    /**
     * Constructor.
     * @param driver WebDriver
     */
    public LoginLOEPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
//        wait = new WebDriverWait(driver, 10);
        //
        emailField = driver.findElement(By.id("Email"));
        passwordField = driver.findElement(By.id("Password"));
        signInButton = driver.findElement(By.id("Password")); // add .submit
    }
    
    // functional
    /**
     * Filling fields using credentials and after that clicking button 'login'.
     * @param user User.
     * @return ConsumersLOEPage class.
     */
    public ConsumersLOEPage signIn (User user) {
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
        return new ConsumersLOEPage(driver, user);
    }
}
