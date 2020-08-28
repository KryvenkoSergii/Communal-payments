package home.kryvenkosergii.communalpayments.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import home.kryvenkosergii.communalpayments.data.PreviousMeterValue;

/**
 * EnterValuePage abstract class.
 * @author SergiiK 2020-08-24
 */
public abstract class EnterValuePage {
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriverWait wait;
    //
    protected WebElement meterDeviceNumber;
    protected WebElement value1Field;
    protected WebElement value2Field;
    protected WebElement submitButton;
    protected WebElement previousDayValue;
    protected WebElement previousMeterValue;
    protected WebElement currentDayValue;

    //
    // meterDeviceNumber
    /**
     * Returns a meterDeviceNumber WebElement.
     * @return WebElement
     */
    protected WebElement getMeterDeviceNumber() {
        return meterDeviceNumber;
    }

    /**
     * Is Meter Device Number displayed.
     * @return boolean
     */
    protected boolean isDisplayedMeterDeviceNumber() {
        logger.debug("start isDisplayedMeterDeviceNumber()");
        logger.trace("is Displayed Meter Device Number");
        return getMeterDeviceNumber().isDisplayed();
    }

    /**
     * Getting DeviceNumber
     * @return String
     */
    protected String getMeterDeviceNumberText() {
        if (isDisplayedMeterDeviceNumber()) {
            logger.info("get MeterDeviceNumber: " + getMeterDeviceNumber().getText());
            return getMeterDeviceNumber().getText();
        } else {
            return "data not found";
        }
    }

    // previousDayValue
    /**
     * Getting previousDayValue WebElement.
     * @return
     */
    protected WebElement getPreviousDayValue() {
        return previousDayValue;
    }

    /**
     * Is PreviousDayValue displayed.
     * @return
     */
    protected boolean isDisplayedPreviousDayValue() {
        logger.debug("start isDisplayedPreviousDayValue()");
        logger.trace("is Displayed Previous Day Value");
        return getPreviousDayValue().isDisplayed();
    }

    /**
     * Getting the value of the previous day, when we were entering the value.
     * @return String
     */
    protected String getPreviousDayValueText() {
        if (isDisplayedPreviousDayValue()) {
            logger.info("get Previous Day Value: " + getPreviousDayValue().getText());
            return getPreviousDayValue().getText();
        } else {
            return "data not found";
        }
    }

    // previousMeterValue
    /**
     * Getting getPreviousMeterValue WebElement.
     * @return WebElement
     */
    protected WebElement getPreviousMeterValue() {
        return previousMeterValue;
    }

    /**
     * Is Previous Meter Value Displayed.
     * @return boolean.
     */
    protected boolean isDisplayedPreviousMeterValue() {
        logger.debug("start isDisplayedPreviousMeterValue()");
        logger.trace("is Displayed Previous Meter Value");
        return getPreviousMeterValue().isDisplayed();
    }

    /**
     * Getting the previous meter value.
     * @return String
     */
    protected String getPreviousMeterValueText() {
        if (isDisplayedPreviousMeterValue()) {
            logger.info("get Previous Meter Value: " + getPreviousMeterValue().getText());
            return getPreviousMeterValue().getText();
        } else {
            return "data not found";
        }
    }

    // currentDayValue
    /**
     * Getting getCurrentDayValue WebElement.
     * @return WebElement.
     */
    protected WebElement getCurrentDayValue() {
        return currentDayValue;
    }

    /**
     * Is Current Day Value Displayed.
     * @return boolean.
     */
    protected boolean isDisplayedCurrentDayValue() {
        logger.debug("start isDisplayedCurrentDayValue()");
        logger.trace("is Displayed Current Day Value");
        return getCurrentDayValue().isDisplayed();
    }

    /**
     * Getting the value of the current day.
     * @return String
     */
    protected String getCurrentDayValueText() {
        if (isDisplayedCurrentDayValue()) {
            logger.info("get Current Day Value: " + getCurrentDayValue().getText());
            return getCurrentDayValue().getText();
        } else {
            return "data not found";
        }
    }

    // value1Field
    /**
     * Getting WebElement for the input field N1.
     * @return WebElement
     */
    protected WebElement getValue1Field() {
        return value1Field;
    }

    /**
     * Inputting the value into the field.
     * @param value1 int
     * @return EnterValuePage class.
     */
    protected EnterValuePage inputValue1(int value1) {
        logger.debug("start inputValue1()");
        logger.trace("input value1: " + value1);
        logger.info(this.getClass().getSimpleName() + " input value1: " + value1);
        this.getValue1Field().sendKeys(String.valueOf(value1));
        return this;
    }

    /**
     * Clear the input field.
     * @return EnterValuePage class.
     */
    protected EnterValuePage clearValue1Field() {
        logger.debug("start clearValue1Field()");
        logger.trace("clear value1 Field");
        logger.info(this.getClass().getSimpleName() + " clear value1 Field");
        this.getValue1Field().clear();
        return this;
    }

    /**
     * Click on the input field.
     * @param driver WebDriver
     * @return EnterValuePage class.
     */
    protected EnterValuePage clickValue1Field(WebDriver driver) {
        logger.debug("start clickValue1Field()");
        logger.trace("click value1 Field");
        logger.info(this.getClass().getSimpleName() + " click value1 Field");
        if (isDisplayedValue1Field()) {
            this.getValue1Field().click();
            Actions action = new Actions(driver);
            action.contextClick(getValue1Field()).sendKeys(Keys.LEFT).sendKeys(Keys.RIGHT);
        }
        return this;
    }

    /**
     * Is Displayed the input field N1.
     * @return boolean
     */
    protected boolean isDisplayedValue1Field() {
        logger.debug("start isDisplayedValue1Field()");
        logger.trace("is Displayed value1 Field");
        return getValue1Field().isDisplayed();
    }

    // submitButton
    /**
     * Getting WebElement for submit Button.
     * @return WebElement.
     */
    protected WebElement getSubmitButton() {
        return submitButton;
    }

    /**
     * Click on the submit Button.
     * @param driver WebDriver.
     * @return EnterValuePage class.
     */
    protected EnterValuePage clickSubmitButton(WebDriver driver) {
        logger.debug("start clickSubmitButton()");
        logger.trace("click SignIn Button");
        logger.info(this.getClass().getSimpleName() + " click Submit Button");
        if (isDisplayedSubmitButtonField()) {
            this.getSubmitButton().click();
        }
        return this;
    }

    /**
     * Is Displayed the submit Button.
     * @return boolean
     */
    protected boolean isDisplayedSubmitButtonField() {
        logger.debug("start isDisplayedSubmitButtonField()");
        logger.trace("is Displayed Submit Button");
        return getSubmitButton().isDisplayed();
    }
    
    /**
     * Returns data about previous values and a meter number.
     * @return PreviousMeterValue class.
     */
    public abstract PreviousMeterValue getPreviousMeterData();
}
