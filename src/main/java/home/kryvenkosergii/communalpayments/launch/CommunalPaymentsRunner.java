package home.kryvenkosergii.communalpayments.launch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;

/**
 * CommunalPaymentsRunner abstract class. Contains launchers WebDriver for
 * Chrome and FireFox, tearDown methods, methods to open tab for sites (LOE,
 * 104UA, InfoLviv);
 * @author SergiiK 2020-08-24
 */
public abstract class CommunalPaymentsRunner {
    private final Long ONE_SECOND_DELAY = 1000L;
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebDriver driver;
    //
    protected final static String PATH_TO_WEBSITE_LOE = "https://info.loe.lviv.ua/";
    protected final static String PATH_TO_WEBSITE_104UA = "https://104.ua";
    protected final static String PATH_TO_WEBSITE_INFOLVIV = "https://infolviv.com.ua";

    /**
     * Launcher Chrome WebDriver.
     * @return WebDriver
     */
    @Step(value = "launch Chrome Web Driver")
    public WebDriver launchDriverManagerChrome() {
        logger.debug("start launchDriverManagerChrome()");
        logger.trace("launch Driver Manage Chrome");
        logger.info("launch chromedriver");
        WebDriverManager.chromedriver().setup();
        // Chrome with UI
//        driver = new ChromeDriver();
        // Chrome Without UI
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("chromedriver settings: " + driver.manage().toString());
        return driver;
    }

    /**
     * Launcher FireFox WebDriver.
     * @return WebDriver
     */
    @Step(value = "launch FireFox Web Driver")
    public WebDriver launchDriverManagerFireFox() {
        logger.debug("start launchDriverManagerFireFox()");
        logger.trace("launch Driver Manage FireFox");
        logger.info("launch firefoxdriver");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("firefoxdriver settings: " + driver.manage().toString());
        return driver;
    }

    /**
     * Close WebDriver.
     * @param driver WebDriver
     */
    @Step(value = "close WebDriver")
    public void tearDownAfterProcess(WebDriver driver) {
        logger.debug("start tearDownAfterProcess()");
        logger.trace("close WebDriver");
        logger.info("close WebDriver");
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Open tab LOE site (https://info.loe.lviv.ua/).
     * @param driver WebDriver
     * @return WebDriver
     */
    @Step(value = "open tab LOE site")
    public WebDriver getToLinkWebSiteLOE(WebDriver driver) {
        logger.debug("start getToLinkWebSiteLOE()");
        logger.trace("open tab: " + PATH_TO_WEBSITE_LOE);
        logger.info("open tab: " + PATH_TO_WEBSITE_LOE);
        driver.get(PATH_TO_WEBSITE_LOE);
        return driver;
    }

    /**
     * Open tab 104UA site (https://104.ua/).
     * @param driver WebDriver
     * @return WebDriver
     */
    @Step(value = "open tab 104UA site")
    public WebDriver getToLinkWebSite104UA(WebDriver driver) {
        logger.debug("start getToLinkWebSite104UA()");
        logger.trace("open tab: " + PATH_TO_WEBSITE_104UA);
        logger.info("open tab: " + PATH_TO_WEBSITE_104UA);
        driver.get(PATH_TO_WEBSITE_104UA);
        return driver;
    }

    /**
     * Open tab INFOLVIV site (https://infolviv.com.ua/).
     * @param driver WebDriver
     * @return WebDriver
     */
    @Step(value = "open tab INFOLVIV site")
    public WebDriver getToLinkWebSiteINFOLVIV(WebDriver driver) {
        logger.debug("start getToLinkWebSiteINFOLVIV()");
        logger.trace("open tab: " + PATH_TO_WEBSITE_INFOLVIV);
        logger.info("open tab: " + PATH_TO_WEBSITE_INFOLVIV);
        driver.get(PATH_TO_WEBSITE_INFOLVIV);
        return driver;
    }

    protected CommunalPaymentsRunner presentationSleep() {
        presentationSleep(1);
        return this;
    }

    protected CommunalPaymentsRunner presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;
    }
}
