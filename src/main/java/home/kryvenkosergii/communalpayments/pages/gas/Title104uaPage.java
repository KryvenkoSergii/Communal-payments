package home.kryvenkosergii.communalpayments.pages.gas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.pages.TitlePage;

/**
 * Title104uaPage describes page 'https://104.ua'.
 * Here we can sign in and register.
 * @author SergiiK
 * 2020-08-28
 */
public class Title104uaPage extends TitlePage {
    //
    private WebDriver driver;
    private WebDriverWait wait;
    //
    /**
     * Constructor.
     * @param driver WebDriver.
     */
    public Title104uaPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    
    private void initElements() {
     // init elements
//      wait = new WebDriverWait(driver, 10);
      //
        title = driver.getTitle().toString();
        registrationButton = driver.findElement(By.cssSelector(".b-wrapper .b-reg-info a[href='/ua/registration']"));
        loginButton = driver.findElement(By.cssSelector(".b-wrapper .b-reg-info a[href='/ua/cabinet']"));
    }

    // registrationButton
    @Override
    public Registration104uaPage clickregistrationButton(WebDriver driver) {
        logger.debug("start registrationButton()");
        logger.trace("click registrationButton");
        logger.info(this.getClass().getSimpleName() + " click registrationButton");
        if (isDisplayedRegistrationButton()) {
            this.getRegistrationButton().click();
        }
        return new Registration104uaPage(driver);
    }

    // loginButton
    @Override
    public Login104uaPage clickLoginButton(WebDriver driver) {
        logger.debug("start clickLoginButton()");
        logger.trace("click LoginButton");
        logger.info(this.getClass().getSimpleName() + " click LoginButton");
        if (isDisplayedLoginButton()) {
            this.getLoginButton().click();
        }
        return new Login104uaPage(driver);
    }

}
