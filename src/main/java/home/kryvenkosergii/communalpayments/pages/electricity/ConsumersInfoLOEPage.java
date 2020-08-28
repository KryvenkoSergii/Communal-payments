package home.kryvenkosergii.communalpayments.pages.electricity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.ConsumersPage;

/**
 * ConsumersInfoLOEPage describes page
 * 'https://info.loe.lviv.ua/consumers/{user's invoice}/info'.
 * General information about a consumer.
 * @author SergiiK 2020-08-27
 */
public class ConsumersInfoLOEPage extends ConsumersPage {
    //
    private WebElement emailUserData; // for testing
    //

    /**
     * Constructor.
     * @param driver WebDriver.
     * @param user User.
     */
    public ConsumersInfoLOEPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        initElements();
    }

    private void initElements() {
        // init elements (page
        // 'https://info.loe.lviv.ua/consumers/getUserNumber()/info')
        enterValueLink = driver
                .findElement(By.cssSelector(".breadcrumb  a[href*='/consumers/" + user.getUserNumber() + "/indexes/new']"));
        emailUserData = driver.findElement(By.xpath("//td[text()='Email:']/following-sibling::td"));
    }

    // emailUserData
    private WebElement getEmailUserData() {
//        emailUserData = driver.findElement(By.xpath("//td[text()='Email:']/following-sibling::td"));
        return emailUserData;
    }

    private String getEmailUserDataText() {
        if (isDisplayedEmailUserData()) {
            return getEmailUserData().getText();
        } else {
            return "data not found";
        }
    }

    private boolean isDisplayedEmailUserData() {
        logger.debug("start isDisplayedEmailUserData()");
        logger.trace("is Displayed emailUser Data");
        return getEmailUserData().isDisplayed();
    }

    // functional
    /**
     * Getting a user email from this page for checking (testing).
     * @return String user email.
     */
    public String getUserEmail() {
        logger.info(this.getClass().getSimpleName() + " get User Email: " + getEmailUserDataText());
        return getEmailUserDataText();
    }

    // business logic
    /**
     * Click on the top menu link (button) 'enter values'.
     * @return EnterValueLOEPage class.
     */
    public EnterValueLOEPage clickInputValueLink() {
        clickEnterValueLink(driver);
        return new EnterValueLOEPage(driver, user);
    }
}
