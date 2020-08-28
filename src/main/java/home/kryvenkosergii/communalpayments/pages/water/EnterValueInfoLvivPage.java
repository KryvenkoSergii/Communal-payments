package home.kryvenkosergii.communalpayments.pages.water;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.data.PreviousMeterValue;
import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.pages.EnterValuePage;

/**
 * EnterValueInfoLvivPage class describes page
 * 'https://infolviv.com.ua/dashboard/counters'. Here we can send our meter
 * values.
 * @author SergiiK 2020-08-28
 */
public class EnterValueInfoLvivPage extends EnterValuePage {
    //
    private WebDriver driver;
    private WebDriverWait wait;
    private User user;
    //
    private final String meterDeviceColumnNumber = "1"; // number 'td' element in table before 'previousWaterValue' element
    private final String secondFromTheEndElement = "last()-1"; // number 'td' element in table where we take 'previousDayValue'

    /**
     * Constructor.
     * @param driver WebDriver.
     * @param user User.
     */
    public EnterValueInfoLvivPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        initElements();
    }

    private void initElements() {
        //
//        wait = new WebDriverWait(driver, 10);
        //
        value1Field = driver.findElement(By.xpath("//div[@id='counters']//tbody//td[text()='" + user.getUserNumber()
                + "']/../td//input[contains(@class,'input_end_state')]"));
        submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        meterDeviceNumber = driver.findElement(By.xpath("//div[@id='counters']//tbody//td[text()='" + user.getUserNumber()
                + "']/../td[contains(@class,'input_begin_state')]/preceding::td[" + meterDeviceColumnNumber + "]"));
        previousMeterValue = driver.findElement(By.xpath("//div[@id='counters']//tbody//td[text()='" + user.getUserNumber()
                + "']/../td[contains(@class,'input_begin_state')]"));
        previousDayValue = driver.findElement(By.xpath("//div[@id='counters']//tbody//td[text()='" + user.getUserNumber()
        + "']/../td[" + secondFromTheEndElement + "]"));
    }

    // previousWaterValue
    @Override
    protected boolean isDisplayedPreviousMeterValue() {
        logger.debug("start isDisplayedPreviousMeterValue()");
        logger.trace("is Displayed Previous Electricity Day Value");
        return getPreviousMeterValue().isDisplayed();
    }

    @Override
    protected String getPreviousMeterValueText() {
        if (isDisplayedPreviousMeterValue()) {
            logger.info("get PreviousWaterValue: " + getPreviousMeterValue().getText());
            return getPreviousMeterValue().getText();
        } else {
            return "data not found";
        }
    }
    
 // functional
    @Override
    public PreviousMeterValue getPreviousMeterData() {
        String previousTime = getPreviousDayValueText();
        String numberMeter = getMeterDeviceNumberText();
        int previousWaterValue = Integer.parseInt(getPreviousMeterValueText().substring(0, 4));
        return new PreviousMeterValue(previousTime, previousWaterValue, numberMeter);
    }

    // business logic
    /**
     * Inputting the value of water and click 'submit'.
     */
    public void inputValues() {
        logger.info(this.getClass().getSimpleName() + " " + this.getPreviousMeterData());
        logger.info("input water Value: " + user.getUserValue1() + "m^3");
        clickValue1Field(driver);
        clearValue1Field();
        inputValue1(user.getUserValue1());
        //
//        logger.info("click Submit button");
//        clickSubmitButton(driver);
//        //
//        try {
//            Alert alert = driver.switchTo().alert();
//            alert.accept();
//        } catch (Exception e) {
//            // exception handling
//        }
    }

}
