package home.kryvenkosergii.communalpayments.pages.electricity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.data.PreviousMeterValue;
import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.EnterValuePage;

/**
 * EnterValueLOEPage describes page 'https://info.loe.lviv.ua/consumers/{user's
 * invoice}/indexes/add'. Here we can send our meter values.
 * @author SergiiK 2020-08-27
 */
public class EnterValueLOEPage extends EnterValuePage {
    //
    private WebDriver driver;
    private WebDriverWait wait;
    private User user;
    //
    private WebElement value2Field;
    private WebElement previousElectricityNightValue;
    //
    private final String numberPreviousDataColumn = "2"; // number position in 'tr/td' html table
    private final String numberPreviousElectricityDayColumn = "3"; // number position in 'tr/td' html table
    private final String numberPreviousElectricityNightColumn = "4"; // number position in 'tr/td' html table
    private final String numberCurrentDataColumn = "2"; // number position in 'tr/td' html table
    //

    /**
     * Constructor.
     * @param driver WebDriver.
     * @param user User.
     */
    public EnterValueLOEPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        initElements();
    }

    private void initElements() {
        value1Field = driver.findElement(By.id("CounterMeterages_0__CurrentValue")); // electricity Day Value
        submitButton = driver.findElement(By.cssSelector(".form-group button[type='submit']")); // button 'submit'
        //
        previousDayValue = driver.findElement(
                By.cssSelector(".table.table-bordered tbody tr:first-child td:nth-of-type(" + numberPreviousDataColumn + ")"));
        // previous ElectricityDay Value
        previousMeterValue = driver.findElement(By.cssSelector(
                ".table.table-bordered tbody tr:first-child td:nth-of-type(" + numberPreviousElectricityDayColumn + ")"));
        currentDayValue = driver.findElement(
                By.cssSelector(".table.table-bordered tbody tr:first-child+tr td:nth-of-type(" + numberCurrentDataColumn + ")"));
        meterDeviceNumber = driver.findElement(By.cssSelector("tr.info th")); // TODO
    }

    // value2Field
    /**
     * Getting WebElement for the input field N2.
     * @return WebElement
     */
    private WebElement getValue2Field() {
        value2Field = driver.findElement(By.id("CounterMeterages_1__CurrentValue")); // electricity Night Value
        return value2Field;
    }

    /**
     * Inputting value into the field.
     * @param value2 int
     * @return EnterValueLOEPage class.
     */
    private EnterValueLOEPage inputValue2(int value2) {
        logger.debug("start inputValue2()");
        logger.trace("input value2: " + value2);
        logger.info(this.getClass().getSimpleName() + " input value2: " + value2);
        this.getValue2Field().sendKeys(String.valueOf(value2));
        return this;
    }

    /**
     * Clear the input field.
     * @return EnterValueLOEPage class.
     */
    private EnterValueLOEPage clearValue2Field() {
        logger.debug("start clearValue2Field()");
        logger.trace("clear value2 Field");
        logger.info(this.getClass().getSimpleName() + " clear value2 Field");
        this.getValue2Field().clear();
        return this;
    }

    /**
     * Click on the input field.
     * @param driver WebDriver
     * @return EnterValueLOEPage class.
     */
    private EnterValueLOEPage clickValue2Field(WebDriver driver) {
        logger.debug("start clickValue2Field()");
        logger.trace("click value2 Field");
        logger.info(this.getClass().getSimpleName() + " click value2 Field");
        if (isDisplayedValue2Field()) {
            this.getValue2Field().click();
            Actions action = new Actions(driver);
            action.contextClick(getValue2Field()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * Is Displayed the input field N2.
     * @return boolean
     */
    private boolean isDisplayedValue2Field() {
        logger.debug("start isDisplayedValue2Field()");
        logger.trace("is Displayed value2 Field");
        return getValue2Field().isDisplayed();
    }

    // previousElectricityDayValue
    @Override
    protected boolean isDisplayedPreviousMeterValue() {
        logger.debug("start isDisplayedPreviousElectricityDayValue()");
        logger.trace("is Displayed Previous Electricity Day Value");
        return getPreviousMeterValue().isDisplayed();
    }

    @Override
    protected String getPreviousMeterValueText() {
        if (isDisplayedPreviousMeterValue()) {
            logger.info("get Previous Electricity Day Value: " + getPreviousMeterValue().getText());
            return getPreviousMeterValue().getText();
        } else {
            return "data not found";
        }
    }

    // previousElectricityNightValue
    private WebElement getPreviousElectricityNightValue() {
        previousElectricityNightValue = driver.findElement(By.cssSelector(
                ".table.table-bordered tbody tr:first-child td:nth-of-type(" + numberPreviousElectricityNightColumn + ")"));
        return previousElectricityNightValue;
    }

    private boolean isDisplayedPreviousElectricityNightValue() {
        logger.debug("start isDisplayedPreviousElectricityNightValue()");
        logger.trace("is Displayed Previous Electricity Night Value");
        return getPreviousElectricityNightValue().isDisplayed();
    }

    /**
     * Getting the previous 'electricity night' value.
     * @return String
     */
    public String getPreviousElectricityNightValueText() {
        if (isDisplayedPreviousElectricityNightValue()) {
            logger.info("get Previous Electricity Night Value: " + getPreviousElectricityNightValue().getText());
            return getPreviousElectricityNightValue().getText();
        } else {
            return "data not found";
        }
    }

    // functional
    @Override
    public PreviousMeterValue getPreviousMeterData() {
        String previousTime = getPreviousDayValueText();
        String numberMeter = getMeterDeviceNumberText();
        int previousElectricityDayValue = Integer.parseInt(getPreviousMeterValueText());
        int previousElectricityNightValue = Integer.parseInt(getPreviousElectricityNightValueText());
        return new PreviousMeterValue(previousTime, previousElectricityDayValue, previousElectricityNightValue, numberMeter);
    }

    // business logic
    /**
     * Inputting our values of electricity and click 'submit'.
     */
    public void inputValues() {
        logger.info(this.getClass().getSimpleName() + " " + this.getPreviousMeterData());
        logger.info("input electricity Day Value: " + user.getUserValue1() + "kVt");
        clickValue1Field(driver);
        clearValue1Field();
        inputValue1(user.getUserValue1());
        //
        /*
         * If we need to enter a night value of electricity.
         */
        if (user.getUserValue2() >= 0) {
            logger.info("input electricity Night Value: " + user.getUserValue2() + "kVt");
            clickValue2Field(driver);
            clearValue2Field();
            inputValue2(user.getUserValue2());
        }
        //
//        logger.info("click Submit button");
//        clickSubmitButton(driver);
    }
}
