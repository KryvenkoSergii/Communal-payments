package home.kryvenkosergii.communalpayments;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * The WebSite104UA class for access to website https://104.ua and setting the value of gas meter
 * @author Serg
 *
 */
public class WebSite104UA extends WebSiteUtil {
	private int gasMeterValue;
	private String gasSelector;
	private String login;
	private String password;
	private static final String PATH_TO_WEBSITE_104UA;
	private static final String PATH_TO_LOGFILE_104UA;

	/*
	 * static initialization block
	 */
	static {
		PATH_TO_WEBSITE_104UA = "https://104.ua";
		PATH_TO_LOGFILE_104UA = "LogFile104UA.txt";
	}

	/**
	 * The method 'getGasMeterValue' for getting gas meter value
	 * @return getGasMeterValue
	 */
	public int getGasMeterValue() {
		return gasMeterValue;
	}

	/**
	 * constructor, which receive integer value of gas meter
	 * @param gasMeterValue
	 */
	public WebSite104UA(int gasMeterValue) {
		this.gasMeterValue = gasMeterValue;
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
		this.gasSelector = "//form[@id='frmMeter4678865']/div/div/input[2]";
		this.login = props.getProperty("104ua.login");
		this.password = props.getProperty("104ua.password");
	}

	/**
	 * The method 'enterValue' for entering to web site https://104.ua and sending value of gas meter
	 */
	public void enterValue() {
		FileUtil log = new FileUtil(PATH_TO_LOGFILE_104UA);
		log.save(PATH_TO_LOGFILE_104UA, "");
		log.save(PATH_TO_LOGFILE_104UA, "The setting the value of gas to site 104.ua ");

		System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
		ChromeDriver ch = new ChromeDriver(new ChromeOptions().setBinary(PATH_TO_CHROME));
		setLoginPasswordSelector();

		log.save(PATH_TO_LOGFILE_104UA, "Entering to site 104UA");
		ch.get(PATH_TO_WEBSITE_104UA);
//		ch.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		ch.findElementByXPath("//a[text()='АВТОРИЗАЦІЯ (ВХІД)']").click();
		log.save(PATH_TO_LOGFILE_104UA, "Entering login and password");
		ch.findElementById("username").sendKeys(login);
		ch.findElementById("password").sendKeys(password);
		ch.findElementByXPath("//input[@value='Увійти']").click();
		log.save(PATH_TO_LOGFILE_104UA, "Entering to consumer private page");
		ch.findElementByXPath("//a[text()='Переглянути історію споживання']").click();

		ch.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement valueInputGas = ch.findElementByXPath(gasSelector);
		System.out.println(valueInputGas.getAttribute("value"));
		valueInputGas.sendKeys(Keys.chord(Keys.CONTROL, "a"), "");
		log.save(PATH_TO_LOGFILE_104UA, "The setting the value of gas " + gasMeterValue + " cubic meters");
		valueInputGas.sendKeys(String.valueOf(gasMeterValue));
		ch.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		log.save(PATH_TO_LOGFILE_104UA, "Saving values");
		ch.findElementById("4678865").click();
		log.save(PATH_TO_LOGFILE_104UA, "Closing web browser");
		ch.close();

	}
}
