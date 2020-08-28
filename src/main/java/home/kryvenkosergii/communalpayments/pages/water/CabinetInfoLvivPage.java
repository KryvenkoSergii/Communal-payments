package home.kryvenkosergii.communalpayments.pages.water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.ConsumersPage;

/**
 * CabinetInfoLvivPage class describes page 'https://infolviv.com.ua/dashboard'.
 * There is displayed a consumer with short information.
 * @author SergiiK 2020-08-28
 */
public class CabinetInfoLvivPage extends ConsumersPage {
    //
    private WebElement emailUserData;
    private WebElement userDataDropDown; // for testing
    private List<WebElement> userPrivateInvoices; // for testing

    //
    /**
     * Constructor.
     * @param driver WebDriver.
     * @param user User.
     */
    public CabinetInfoLvivPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        initElements();
    }

    private void initElements() {
        // init elements (page 'https://infolviv.com.ua/dashboard')
        enterValueLink = driver.findElement(By.cssSelector(".nav.navbar-nav a[href='/dashboard/counters']"));
        userDataDropDown = driver.findElement(By.id("identifier"));
        userPrivateInvoices = driver.findElements(By.cssSelector("#identifier option"));
        emailUserData = driver.findElement(By.cssSelector("div[class*='personal-info'] div.body p:last-child"));
    }

    // emailUserData
    private WebElement getEmailUserData() {
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

    // userDataDropDown
    private WebElement getUserDataDropDown() {
        return userDataDropDown;
    }

    private String getUserDataDropDownText() {
        if (isDisplayedUserDataDropDown()) {
            return getUserDataDropDown().getText();
        } else {
            return "data not found";
        }
    }

    private boolean isDisplayedUserDataDropDown() {
        logger.debug("start isDisplayedUserDataDropDown()");
        logger.trace("is Displayed User Data DropDown");
        return getUserDataDropDown().isDisplayed();
    }

    private void clickuserDataDropDown() {
        if (isDisplayedUserDataDropDown()) {
            getUserDataDropDown().click();
        }
    }

    // userPrivateInvoices
    private List<WebElement> getUserPrivateInvoices() {
        return userPrivateInvoices;
    }

    private List<String> getUserPrivateInvoicesText() {
        if (isDisplayedUserPrivateInvoices()) {
            List<String> privateInvoiceList = new ArrayList<String>();
            for (WebElement invoice : getUserPrivateInvoices()) {
                privateInvoiceList.add(invoice.getText().trim());
            }
            return privateInvoiceList;
        } else {
            return Arrays.asList("data not found");
        }
    }

    private boolean isDisplayedUserPrivateInvoices() {
        logger.debug("start isDisplayedUserPrivateInvoices()");
        logger.trace("is Displayed User Data DropDown");
        return 0 != getUserPrivateInvoices().size();
    }

    // functional
    /**
     * Getting user's email (for testing).
     * @return
     */
    public String getUserEmail() {
        logger.info(this.getClass().getSimpleName() + " get User Email: " + getEmailUserDataText());
        return getEmailUserDataText();
    }

    /**
     * Checking if a user's private invoice is present on the drop-box (for testing).
     * If a user's private invoice isn't present we can't send our meter's volume!
     * @param invoice String.
     * @return boolean.
     */
    public boolean isUserInvoicePresents(String invoice) {
        boolean isInvoicePresent = false;
        for (String element : getUserPrivateInvoicesText()) {
            if (invoice.equals(element)) {
                isInvoicePresent = true;
                break;
            }
        }
        return isInvoicePresent;
    }

    // business logic
    /**
     * Click on the link 'Enter value'.
     * @return EnterValueInfoLvivPage class.
     */
    public EnterValueInfoLvivPage clickInputValueLink() {
        clickEnterValueLink(driver);
        return new EnterValueInfoLvivPage(driver, user);
    }
}
