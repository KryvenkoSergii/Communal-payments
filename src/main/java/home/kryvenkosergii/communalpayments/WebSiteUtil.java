package home.kryvenkosergii.communalpayments;

/**
 * The WebSiteUtil abstract class it's a pattern for other classes access in websites
 * @author Serg
 *
 */
public abstract class WebSiteUtil {
	/*
	 * field 'login' it's a user name to access in websites
	 */
	private String login;
	/*
	 * field 'password' it's a private password to access in websites
	 */
	private String password;
	
	/*
	 * static fields path to ChromeWebDriver and executing file Chrome
	 */
	protected static final String PATH_TO_CHROME_DRIVER;
	protected static final String PATH_TO_CHROME;
	
	static {
		PATH_TO_CHROME_DRIVER = "E:\\Project_Ser\\Java\\Selenium\\chromedriver.exe";
		PATH_TO_CHROME = "C:\\Users\\Serg\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
	}
	
	/*
	 *method for entering to web sites and setting values
	 */
	public abstract void enterValue();
}

