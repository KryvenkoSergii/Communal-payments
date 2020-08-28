package home.kryvenkosergii.communalpayments.pages.gas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.ConsumersPage;

/**
 * CabinetInfo104uaPage class describes page 'https://104.ua/ua/cabinet/info/'.
 * There is displayed our consumers with short information.
 * @author SergiiK
 * 2020-08-24
 */
public class CabinetInfo104uaPage extends ConsumersPage {
    //
    private WebElement infoConsumerLink;
    private WebElement userData; // for testing
    //
    public CabinetInfo104uaPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        initElements();
    }

    private void initElements() {
        // init elements (page 'https://104.ua/ua/cabinet/info')
        enterValueLink = driver.findElement(By.cssSelector(".b-mini-widget-btns.clear a[href='/ua/cabinet/subscription_fee']"));
        userData = driver.findElement(By.cssSelector(".customer__info.blue span"));
    }
    
 // userData
    private WebElement getUserData() {
//        emailUserData = driver.findElement(By.xpath("//td[text()='Email:']/following-sibling::td"));
        return userData;
    }
    
    private String getUserDataText() {
        if (isDisplayedUserData()) {
            return getUserData().getText();
        } else {
        return "data not found";
        }
    }
    
    private boolean isDisplayedUserData() {
        logger.debug("start isDisplayedUserData()");
        logger.trace("is Displayed User Data");
        return getUserData().isDisplayed();
    }
    
    // functional
    /**
     * Getting user's info (name, invoice, etc.).
     * @return String.
     */
    public String getUserCredential() {
        logger.info(this.getClass().getSimpleName() + " get User Data: " + getUserDataText());
        return getUserDataText();
    }
    
    // business logic
    /**
     * Click on the link 'Enter value'.
     * @return EnterValue104uaPage class.
     */
    public EnterValue104uaPage clickInputValueLink() {
        clickEnterValueLink(driver);
        return new EnterValue104uaPage(driver, user);
    }
}
