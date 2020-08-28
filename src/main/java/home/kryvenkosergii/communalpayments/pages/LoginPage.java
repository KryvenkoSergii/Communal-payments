package home.kryvenkosergii.communalpayments.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoginPage abstract class.
 * @author SergiiK 2020-08-24
 */
public abstract class LoginPage {
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected WebElement emailField;
    protected WebElement passwordField;
    protected WebElement signInButton;

    // emailField
    /**
     * Getting WebElement for the input email.
     * @return WebElement.
     */
    protected WebElement getEmailField() {
        return emailField;
    }

    /**
     * Inputting an email into the field.
     * @param email String.
     * @return LoginPage class.
     */
    protected LoginPage inputEmail(String email) {
        logger.debug("start inputEmail()");
        logger.trace("input Email: " + email);
        logger.info(this.getClass().getSimpleName() + " input Email: " + email);
        this.getEmailField().sendKeys(email);
        return this;
    }

    /**
     * Clear the email field.
     * @return LoginPage class.
     */
    protected LoginPage clearEmailField() {
        logger.debug("start clearEmailField()");
        logger.trace("clear Email Field");
        logger.info(this.getClass().getSimpleName() + " clear Email Field");
        this.getEmailField().clear();
        return this;
    }

    /**
     * Click on the email field.
     * @param driver WebDriver.
     * @return LoginPage class.
     */
    protected LoginPage clickEmailField(WebDriver driver) {
        logger.debug("start clickEmailField()");
        logger.trace("click Email Field");
        logger.info(this.getClass().getSimpleName() + " click Email Field");
        if (isDisplayedEmailField()) {
            this.getEmailField().click();
            Actions action = new Actions(driver);
            action.contextClick(getEmailField()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * Is Displayed the EmailField.
     * @return boolean
     */
    protected boolean isDisplayedEmailField() {
        logger.debug("start isDisplayedEmailField()");
        logger.trace("is Displayed Email Field");
        return getEmailField().isDisplayed();
    }

    // passwordField
    /**
     * Getting WebElement for the input password.
     * @return WebElement.
     */
    protected WebElement getPasswordField() {
        return passwordField;
    }

    /**
     * Inputting a password into the field.
     * @param password String.
     * @return LoginPage class.
     */
    protected LoginPage inputPassword(String password) {
        logger.debug("start inputPassword()");
        logger.trace("input Password: " + password);
        logger.info(this.getClass().getSimpleName() + " input Password: " + password);
        this.getPasswordField().sendKeys(password);
        return this;
    }

    /**
     * Clear the password field.
     * @return LoginPage class.
     */
    protected LoginPage clearPasswordField() {
        logger.debug("start clearPassword()");
        logger.trace("clear Password Field");
        logger.info(this.getClass().getSimpleName() + " clear Password Field");
        this.getPasswordField().clear();
        return this;
    }

    /**
     * Click on the password field.
     * @param driver WebDriver.
     * @return LoginPage class.
     */
    protected LoginPage clickPasswordField(WebDriver driver) {
        logger.debug("start clickPasswordField()");
        logger.trace("click Password Field");
        logger.info(this.getClass().getSimpleName() + " click Password Field");
        if (isDisplayedPasswordField()) {
            this.getPasswordField().click();
            Actions action = new Actions(driver);
            action.contextClick(getPasswordField()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * Is Displayed the PasswordField.
     * @return boolean
     */
    protected boolean isDisplayedPasswordField() {
        logger.debug("start isDisplayedPasswordField()");
        logger.trace("is Displayed Password Field");
        return getPasswordField().isDisplayed();
    }

    // signInButton
    /**
     * Getting WebElement for SignIn Button.
     * @return WebElement
     */
    protected WebElement getsignInButtonField() {
        return signInButton;
    }

    /**
     * Click on the SignIn Button.
     * @param driver WebDriver.
     * @return LoginPage class.
     */
    protected LoginPage clickSignInButton(WebDriver driver) {
        logger.debug("start clickSignInButton()");
        logger.trace("click SignIn Button");
        logger.info(this.getClass().getSimpleName() + " click SignIn Button");
        if (isDisplayedSignInButtonField()) {
            this.getsignInButtonField().click();
        }
        return this;
    }

    /**
     * Is Displayed the SignIn Button.
     * @return boolean
     */
    protected boolean isDisplayedSignInButtonField() {
        logger.debug("start isDisplayedSignInButtonField()");
        logger.trace("is Displayed SignIn Button");
        return getsignInButtonField().isDisplayed();
    }

}
