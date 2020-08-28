package home.kryvenkosergii.communalpayments.pages.electricity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.ConsumersPage;

/**
 * ConsumersLOEPage describes page 'https://info.loe.lviv.ua/consumers'.
 * There is displayed our consumers with a short information.
 * @author SergiiK 2020-08-27
 */
public class ConsumersLOEPage extends ConsumersPage {
    //
    private WebElement infoConsumerLink;
    private WebElement emailUserData; // for testing
    //

    /**
     * Constructor.
     * @param driver WebDriver.
     * @param user User.
     */
    public ConsumersLOEPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        initElements();
    }

    private void initElements() {
        // init elements (page 'https://info.loe.lviv.ua/consumers')
        infoConsumerLink = driver.findElement(By.cssSelector(".panel-heading a[href*='" + user.getUserNumber() + "']"));
    }

    // infoConsumerLink
    private WebElement getInfoConsumerLink() {
        return infoConsumerLink;
    }

    private ConsumersLOEPage clickInfoConsumerLink(WebDriver driver) {
        logger.debug("start clickInfoConsumerLink()");
        logger.trace("click infoConsumer Link");
        logger.info(this.getClass().getSimpleName() + " click SignIn Button");
        if (isDisplayedInfoConsumerLink()) {
            this.getInfoConsumerLink().click();
        }
        return this;
    }

    private boolean isDisplayedInfoConsumerLink() {
        logger.debug("start isDisplayedInfoConsumerLink()");
        logger.trace("is Displayed infoConsumer Link");
        return getInfoConsumerLink().isDisplayed();
    }

    // functional (next page
    // 'https://info.loe.lviv.ua/consumers/getUserNumber()/info')
    /**
     * Clicking to the chosen user account (used private invoice for finding it). 
     * @return ConsumersInfoLOEPage class.
     */
    public ConsumersInfoLOEPage gotoConsumersInfoLOEPage() {
        clickInfoConsumerLink(driver);
        return new ConsumersInfoLOEPage(driver, user);
    }
}
