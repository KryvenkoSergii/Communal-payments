package home.kryvenkosergii.communalpayments.pages.gas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.data.PreviousMeterValue;
import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.EnterValuePage;

/**
 * EnterValue104uaPage class describes page
 * 'https://104.ua/ua/cabinet/subscription_fee/'. Here we can send our meter
 * values.
 * @author SergiiK 2020-08-24
 */
public class EnterValue104uaPage extends EnterValuePage {
    //
    private WebDriver driver;
    private WebDriverWait wait;
    private User user;
    //
    private WebElement previousSourceValue;
    //

    /**
     * Constructor.
     * @param driver WebDriver.
     * @param user User.
     */
    public EnterValue104uaPage(WebDriver driver, User user) {
        wait = new WebDriverWait(driver, 10);
        this.driver = driver;
        this.user = user;
        initElements();
    }

    private void initElements() {
        value1Field = driver.findElement(By.cssSelector("#currentlyTestimony .frmMeter input[type='text']:last-child"));
        submitButton = driver.findElement(By.cssSelector("div.b-send input[id]"));
//        submitButton = driver.findElement(By.id("4678865"));
//        meterDeviceNumber = driver.findElement(By.cssSelector("form.frmMeter p:first-child"));
        meterDeviceNumber = driver.findElement(By.cssSelector("form.frmMeter")); // get attribute 'data-meter'
//        previousDayValue = driver.findElement(By.cssSelector("span.lastMeterDate"));
        previousDayValue = driver.findElement(By.cssSelector("table[class*='b-table-list'] tbody tr:first-child .second"));
//        previousMeterValue = driver.findElement(By.cssSelector("span.lastMeterValue"));
        previousMeterValue = driver.findElement(By.cssSelector("table[class*='b-table-list'] tbody tr:first-child .third"));
//        previousSourceValue = driver.findElement(By.cssSelector("span.lastMeterSource"));
        previousSourceValue = driver.findElement(By.cssSelector("table[class*='b-table-list'] tbody tr:first-child .four"));
    }

    // currentDayValue
    @Override
    protected WebElement getCurrentDayValue() {
//        currentDayValue = driver.findElement(By.cssSelector("#currentlyTestimony .frmMeter .b-left>span:first-child + input[type]"));
        currentDayValue = driver
                .findElement(By.xpath("//div[@class='frmMeter-fields clear']/div[@class='b-left']/input[@value!='0']"));
        return currentDayValue;
    }

    // previousGasValue
    @Override
    protected boolean isDisplayedPreviousMeterValue() {
        logger.debug("start isDisplayedPreviousMeterValue()");
        logger.trace("is Displayed PreviousGasValue");
        return getPreviousMeterValue().isDisplayed();
    }

    @Override
    protected String getPreviousMeterValueText() {
        if (isDisplayedPreviousMeterValue()) {
            logger.info("get PreviousGasValue: " + getPreviousMeterValue().getText());
            return getPreviousMeterValue().getText();
        } else {
            return "data not found";
        }
    }

    // previousSourceValue
    private WebElement getPreviousSourceValue() {
        return previousSourceValue;
    }

    private boolean isDisplayedPreviousSourceValue() {
        logger.debug("start isDisplayedPreviousSourceValue()");
        logger.trace("is Displayed PreviousSourceValue");
        return getPreviousSourceValue().isDisplayed();
    }

    /**
     * Getting the previous source value.
     * @return String
     */
    public String getPreviousSourceValueText() {
        if (isDisplayedPreviousSourceValue()) {
            logger.info("get PreviousSourceValue: " + getPreviousSourceValue().getText());
            return getPreviousSourceValue().getText();
        } else {
            return "data not found";
        }
    }

    //
    @Override
    protected EnterValuePage clickValue1Field(WebDriver driver) {
        logger.debug("start clickValue1Field()");
        logger.trace("click value1 Field");
        logger.info(this.getClass().getSimpleName() + " click value1 Field");
        if (isDisplayedValue1Field()) {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            try {
                // for 104UA site, where we must wait for refresh page and when the clickable
                // element will appear
                wait.until(ExpectedConditions.elementToBeClickable(getValue1Field()));
            } catch (Exception e) {
                // exception handling
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.getValue1Field().click();
            Actions action = new Actions(driver);
            action.contextClick(getValue1Field()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    @Override
    protected EnterValuePage clickSubmitButton(WebDriver driver) {
        logger.debug("start clickSubmitButton()");
        logger.trace("click SignIn Button");
        logger.info(this.getClass().getSimpleName() + " click Submit Button");
        this.getValue1Field().submit();
        return this;
    }

    // functional
    @Override
    public PreviousMeterValue getPreviousMeterData() {
        String previousTime = getPreviousDayValueText();
        String numberMeter = getMeterDeviceNumberText();
        int n = getPreviousMeterValueText().indexOf('.');
        int previousGasValue = Integer.parseInt(getPreviousMeterValueText().substring(0, n));
        String previousSource = getPreviousSourceValueText();
        return new PreviousMeterValue(previousTime, previousGasValue, previousSource, numberMeter);
    }

    // business logic
    /**
     * Inputting the value of gas and click 'submit'.
     */
    public void inputValues() {
        logger.info(this.getClass().getSimpleName() + " " + this.getPreviousMeterData());
        logger.info("input gas Value: " + user.getUserValue1() + "m^3");
        //
        clickValue1Field(driver);
        clearValue1Field();
        inputValue1(user.getUserValue1());
        //
//        logger.info("click Submit button");
//        clickSubmitButton(driver);
    }

}
