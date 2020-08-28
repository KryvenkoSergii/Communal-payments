package home.kryvenkosergii.communalpayments.ui.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestRunner {
    private final Long ONE_SECOND_DELAY = 1000L;
    //
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;
    //
    protected final static String PATH_TO_WEBSITE_LOE = "https://info.loe.lviv.ua/";
    protected final static String PATH_TO_WEBSITE_104UA = "https://104.ua";
    protected final static String PATH_TO_WEBSITE_INFOLVIV = "https://infolviv.com.ua";

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
        logger.debug("start setUpBeforeClass()");
        logger.trace("lunch setUpBeforeClass()");
        logger.info("lunch setUpBeforeClass()");
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
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

//    @BeforeMethod
//    public void setUp() throws Exception {
//        driver.get("...");
////	    driver.get("http://localhost:4200/");
////		driver.manage().window().maximize();
//    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (!result.isSuccess()) {
            logger.warn("Test " + result.getName() + " ERROR");
            // System.out.println("Test " + result.getName() + " ERROR");
            // Take Screenshot, save sourceCode, save to log, prepare report, Return to
            // previous state, logout, etc.
            // TODO Logout
        }
        // logout, get(urlLogout), delete cookie, delete cache
    }

    protected void presentationSleep() {
        presentationSleep(1);
    }

    protected void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public WebDriver getToLinkWebSiteLOE(WebDriver driver) {
        logger.debug("start getToLinkWebSiteLOE()");
        logger.trace("open tab: " + PATH_TO_WEBSITE_LOE);
        logger.info("open tab: " + PATH_TO_WEBSITE_LOE);
        driver.get(PATH_TO_WEBSITE_LOE);
        return driver;
    }
    
    public WebDriver getToLinkWebSite104UA(WebDriver driver) {
        logger.debug("start getToLinkWebSite104UA()");
        logger.trace("open tab: " + PATH_TO_WEBSITE_104UA);
        logger.info("open tab: " + PATH_TO_WEBSITE_104UA);
        driver.get(PATH_TO_WEBSITE_104UA);
        return driver;
    }
    
    public WebDriver getToLinkWebSiteINFOLVIV(WebDriver driver) {
        logger.debug("start getToLinkWebSiteINFOLVIV()");
        logger.trace("open tab: " + PATH_TO_WEBSITE_INFOLVIV);
        logger.info("open tab: " + PATH_TO_WEBSITE_INFOLVIV);
        driver.get(PATH_TO_WEBSITE_INFOLVIV);
        return driver;
    }
}