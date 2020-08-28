package home.kryvenkosergii.communalpayments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TitlePage abstract class.
 * @author SergiiK
 * 2020-08-24
 */
public abstract class TitlePage {
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    protected String title;
    protected WebElement registrationButton;
    protected WebElement loginButton;
    
    // title
    /**
     * Getting page title.
     * @return String
     */
    public String getTitlePage() {
        return title;
    }

    // registrationButton
    /**
     * Getting WebElement for Registration Button.
     * @return WebElement.
     */
    protected WebElement getRegistrationButton() {
        return registrationButton;
    }

    /**
     * Click on the Registration Button.
     * @param driver
     * @return RegistrationPage class.
     */
    public abstract RegistrationPage clickregistrationButton(WebDriver driver);

    /**
     * Is Displayed the Registration Button.
     * @return boolean.
     */
    protected boolean isDisplayedRegistrationButton() {
        logger.debug("start isDisplayedRegistrationButton()");
        logger.trace("is Displayed registrationButton");
        return getRegistrationButton().isDisplayed();
    }

    // loginButton
    /**
     * Getting WebElement for Login Button.
     * @return WebElement.
     */
    protected WebElement getLoginButton() {
        return loginButton;
    }

    /**
     * Click on the Login Button.
     * @param driver WebDriver.
     * @return LoginPage class.
     */
    public abstract LoginPage clickLoginButton(WebDriver driver);

    /**
     * Is Displayed the Login Button.
     * @return boolean.
     */
    protected boolean isDisplayedLoginButton() {
        logger.debug("start isDisplayedLoginButton()");
        logger.trace("is Displayed LoginButton");
        return getLoginButton().isDisplayed();
    }
}
