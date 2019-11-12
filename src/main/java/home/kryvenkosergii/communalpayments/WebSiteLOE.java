package home.kryvenkosergii.communalpayments;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * The WebSiteLOE class for access to website info.loe.lviv.ua and setting the values of day and night electricity
 * @author Serg
 *
 */
public class WebSiteLOE extends WebSiteUtil {
	private int electricityNightValue;
	private int electricityDayValue;
	private String electricityDaySelector;
	private String electricityNightSelector;
	private String login;
	private String password;
	private static final String PATH_TO_WEBSITE_LOE;
	private static final String PATH_TO_LOGFILE_LOE;

	/*
	 * static initialization block
	 */
	static {
		PATH_TO_WEBSITE_LOE = "https://info.loe.lviv.ua/";
		PATH_TO_LOGFILE_LOE = "LogFileLOE.txt";
	}

	/**
	 * The method 'getElectricityNightValue' for getting electricity night value
	 * @return electricityNightValue
	 */
	public int getElectricityNightValue() {
		return electricityNightValue;
	}

	/**
	 * The method 'getElectricityDayValue' for getting electricity day value
	 * @return electricityDayValue
	 */
	public int getElectricityDayValue() {
		return electricityDayValue;
	}

	/**
	 * constructor, which receive integer values of electricity day and electricity night
	 * @param electricityNightValue
	 * @param electricityDayValue
	 */
	public WebSiteLOE(int electricityNightValue, int electricityDayValue) {
		this.electricityNightValue = electricityNightValue;
		this.electricityDayValue = electricityDayValue;
	}

	/**
	 * The method 'setLoginPasswordSelector' for getting values of login and password and selector for entering values to special windows
	 */
	private void setLoginPasswordSelector() {
		Properties props = new Properties();
		try {
			props.load(CommunalPayments.class.getResourceAsStream("credentials.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.electricityDaySelector = "CounterMeterages_0__CurrentValue";
		this.electricityNightSelector = "CounterMeterages_1__CurrentValue";
		this.login = props.getProperty("info.loe.lviv.ua.login");
		this.password = props.getProperty("info.loe.lviv.ua.password");
	}

	/**
	 * The method 'enterValue' for entering to web site https://info.loe.lviv.ua/ and sending electricity values
	 */
	public void enterValue() {
		FileUtil log = new FileUtil(PATH_TO_LOGFILE_LOE);
		log.save(PATH_TO_LOGFILE_LOE, "");
		log.save(PATH_TO_LOGFILE_LOE, "The setting the value of electricity to site info.loe.lviv.ua ");

		System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
		ChromeDriver ch = new ChromeDriver(new ChromeOptions().setBinary(PATH_TO_CHROME));
		setLoginPasswordSelector();

		log.save(PATH_TO_LOGFILE_LOE, "Entering to site LOE");
		ch.get(PATH_TO_WEBSITE_LOE);
		log.save(PATH_TO_LOGFILE_LOE, "Entering login and password");
		ch.findElementById("Email").sendKeys(login);
		ch.findElementById("Password").sendKeys(password);
		ch.findElementByXPath("//input[@value='Óâ³éòè']").click();
		log.save(PATH_TO_LOGFILE_LOE, "Entering to consumer private page");
		ch.findElementByXPath(
				"//*[@id='resultContainer']/div[2]/div[1]/a[1]/strong[text()='1831/336, ÊÐÈÂÅÍÊÎ ÑÅÐÃ²É ÞÐ²ÉÎÂÈ×']")
				.click();
		log.save(PATH_TO_LOGFILE_LOE, "Entering to page indicators");
		ch.findElementByXPath("//*[@id='user_menu']/ul/li[1]/a[text()='Âíåñòè ïîêàçè']").click();

		// enter electricity Day Value
		WebElement valueInputelectricityDay = ch.findElementById(electricityDaySelector);
		System.out.println(valueInputelectricityDay.getAttribute("value"));
		valueInputelectricityDay.sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
		log.save(PATH_TO_LOGFILE_LOE, "The setting the value of day electricity " + electricityDayValue + " kVt");
		valueInputelectricityDay.sendKeys(String.valueOf(electricityDayValue));

		// enter electricity Day Value
		WebElement valueInputelectricityNight = ch.findElementById(electricityNightSelector);
		System.out.println(valueInputelectricityNight.getAttribute("value"));
		valueInputelectricityNight.sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
		log.save(PATH_TO_LOGFILE_LOE, "The setting the value of night electricity " + electricityNightValue + " kVt");
		valueInputelectricityNight.sendKeys(String.valueOf(electricityNightValue));

		log.save(PATH_TO_LOGFILE_LOE, "Saving values");
		ch.findElementByXPath("//*[@id=\"reportForm\"]/div[2]/button").click();

		log.save(PATH_TO_LOGFILE_LOE, "Closing web browser");
		ch.close();
	}

}
