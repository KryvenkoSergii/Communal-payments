package home.kryvenkosergii.communalpayments.pages.water;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.pages.TitlePage;

/**
 * TitleInfoLvivPage describes page 'https://infolviv.com.ua/'.
 * Here we can sign in and register.
 * @author SergiiK
 * 2020-08-28
 */
public class TitleInfoLvivPage extends TitlePage {
    //
    private WebDriver driver;
    private WebDriverWait wait;
    //
    /**
     * Constructor.
     * @param driver WebDriver.
     */
    public TitleInfoLvivPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    
    private void initElements() {
     // init elements
//      wait = new WebDriverWait(driver, 10);
      //
        title = driver.getTitle().toString();
        registrationButton = driver.findElement(By.cssSelector(".navbar.navbar-default.navbar-static-top .blue_btn"));
        loginButton = driver.findElement(By.cssSelector(".navbar.navbar-default.navbar-static-top .transp_white_btn"));
    }

    // registrationButton
    @Override
    public RegistrationInfoLvivPage clickregistrationButton(WebDriver driver) {
        logger.debug("start registrationButton()");
        logger.trace("click registrationButton");
        logger.info(this.getClass().getSimpleName() + " click registrationButton");
        if (isDisplayedRegistrationButton()) {
            this.getRegistrationButton().click();
        }
        return new RegistrationInfoLvivPage(driver);
    }

    // loginButton
    @Override
    public LoginInfoLvivPage clickLoginButton(WebDriver driver) {
        logger.debug("start clickLoginButton()");
        logger.trace("click LoginButton");
        logger.info(this.getClass().getSimpleName() + " click LoginButton");
        if (isDisplayedLoginButton()) {
            this.getLoginButton().click();
        }
        return new LoginInfoLvivPage(driver);
    }

}