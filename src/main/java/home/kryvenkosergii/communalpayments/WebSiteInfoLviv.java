package home.kryvenkosergii.communalpayments;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The WebSiteInfoLviv class for access to website https://infolviv.com.ua and
 * setting the values of gas meter and water meter
 * 
 * @author Serg
 *
 */
public class WebSiteInfoLviv extends WebSiteUtil {
	private int gasMeterValue;
	private int waterMeterValue;
	private String waterSelector;
	private String gasSelector;
	private String login;
	private String password;
	private static final String PATH_TO_WEBSITE_INFOLVIV;
	private static final String PATH_TO_LOGFILE_INFOLVIV;

	/*
	 * static initialization block
	 */
	static {
		PATH_TO_WEBSITE_INFOLVIV = "https://infolviv.com.ua";
		PATH_TO_LOGFILE_INFOLVIV = "LogFileInfolviv.txt";
	}

	/**
	 * The method 'getGasMeterValue' for getting gas meter value
	 * 
	 * @return gasMeterValue
	 */
	public int getGasMeterValue() {
		return gasMeterValue;
	}

	/**
	 * The method 'getWaterMeterValue' for getting water meter value
	 * 
	 * @return waterMeterValue
	 */
	public int getWaterMeterValue() {
		return waterMeterValue;
	}

	/**
	 * constructor, which receive integer values of gas meter and water meter
	 * 
	 * @param gasMeterValue
	 * @param waterMeterValue
	 */
	public WebSiteInfoLviv(int gasMeterValue, int waterMeterValue) {
		this.gasMeterValue = gasMeterValue;
		this.waterMeterValue = waterMeterValue;
	}

	/**
	 * The method 'setLoginPasswordSelector' for getting values of login and
	 * password and selector for entering values to special windows
	 */
	private void setLoginPasswordSelector() {
		Properties props = new Properties();
		try {
			props.load(CommunalPayments.class.getResourceAsStream("credentials.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.waterSelector = "//div[@id='counters']//table[contains(@class, 'data-table')]//tr[td[position()=2 and contains(text(), '"
				+ props.getProperty("infolviv.waterCounter") + "')]]//td[position()=7]/input";
		this.gasSelector = "//div[@id='counters']//table[contains(@class, 'data-table')]//tr[td[position()=2 and contains(text(), '"
				+ props.getProperty("infolviv.gasCounter") + "')]]//td[position()=7]/input";
		this.login = props.getProperty("infolviv.login");
		this.password = props.getProperty("infolviv.password");
	}

	/**
	 * The method 'enterValue' for entering to web site https://infolviv.com.ua and
	 * sending values of gas meter and water meter
	 */
	public void enterValue() {
		FileUtil log = new FileUtil(PATH_TO_LOGFILE_INFOLVIV);
		log.save(PATH_TO_LOGFILE_INFOLVIV, "");
		log.save(PATH_TO_LOGFILE_INFOLVIV, "The setting the value of gas and water to site infolviv.com.ua ");

		System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
		ChromeDriver ch = new ChromeDriver(new ChromeOptions().setBinary(PATH_TO_CHROME));
		setLoginPasswordSelector();

		log.save(PATH_TO_LOGFILE_INFOLVIV, "Entering to site INFOLVIV");
		ch.get(PATH_TO_WEBSITE_INFOLVIV);
		ch.findElementByXPath("//a[text()='Мій кабінет']").click();
		log.save(PATH_TO_LOGFILE_INFOLVIV, "Entering login and password");
		ch.findElementById("user_email").sendKeys(login);
		ch.findElementById("user_password").sendKeys(password);
		ch.findElementByXPath("//input[@value='Увійти' and @name='commit']").click();
		log.save(PATH_TO_LOGFILE_INFOLVIV, "Entering to consumer private page");
		ch.findElementByXPath("//nav[contains(@class, 'navbar')]//li/a[text()='Лічильники']").click();

		// water counter
		WebElement valueInputWater = ch.findElementByXPath(waterSelector);
		System.out.println(valueInputWater.getAttribute("value"));
		valueInputWater.sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
		log.save(PATH_TO_LOGFILE_INFOLVIV, "The setting the value of water " + waterMeterValue + " cubic meters");
		valueInputWater.sendKeys(String.valueOf(waterMeterValue));

		// gas counter
		WebElement valueInputGas = ch.findElementByXPath(gasSelector);
		System.out.println(valueInputGas.getAttribute("value"));
		valueInputGas.sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
		log.save(PATH_TO_LOGFILE_INFOLVIV, "The setting the value of gas " + gasMeterValue + " cubic meters");
		valueInputGas.sendKeys(String.valueOf(gasMeterValue));

		log.save(PATH_TO_LOGFILE_INFOLVIV, "Saving values");
		ch.findElementById("submit_counters").click();

		for (int i = 0; i < 2; i++) {

			try {
				WebDriverWait wait = new WebDriverWait(ch, 2);
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = ch.switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				// exception handling
			}
		}
		log.save(PATH_TO_LOGFILE_INFOLVIV, "Closing web browser");
		ch.close();
	}

}
