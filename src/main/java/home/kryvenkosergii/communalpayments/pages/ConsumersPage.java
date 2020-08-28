package home.kryvenkosergii.communalpayments.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import home.kryvenkosergii.communalpayments.data.User;

/**
 * ConsumersPage abstract class.
 * @author SergiiK
 * 2020-08-24
 */
public abstract class ConsumersPage {
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected User user;
    protected WebElement enterValueLink;

    // enterValueLink
    /**
     * Getting WebElement to moving on page for input value.
     * @return WebElement
     */
    protected WebElement getEnterValueLink() {
        return enterValueLink;
    }

    /**
     * Click on the WebElement.
     * @param driver
     * @return ConsumersPage class.
     */
    protected ConsumersPage clickEnterValueLink(WebDriver driver) {
        logger.debug("start clickEnterValueLink()");
        logger.trace("click enterValue Link");
        logger.info(this.getClass().getSimpleName() + " click enterValue Link");
        if (isDisplayedEnterValueLink()) {
            this.getEnterValueLink().click();
        }
        return this;
    }

    /**
     * Is Displayed WebElement 'enterValueLink'.
     * @return boolean
     */
    protected boolean isDisplayedEnterValueLink() {
        logger.debug("start isDisplayedEnterValueLink()");
        logger.trace("is Displayed enterValue Link");
        return getEnterValueLink().isDisplayed();
    }
}
