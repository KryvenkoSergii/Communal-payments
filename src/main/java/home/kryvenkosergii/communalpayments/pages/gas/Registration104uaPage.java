package home.kryvenkosergii.communalpayments.pages.gas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.pages.RegistrationPage;

/**
 * Registration104uaPage describes page 'https://104.ua/ua/registration'.
 * Here we can register. This class didn't complete yet.
 * @author SergiiK
 * 2020-08-28
 */
public class Registration104uaPage extends RegistrationPage {
    //
    private WebDriver driver;
    private WebDriverWait wait;
    //
    public Registration104uaPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    private void initElements() {
        System.out.println("this class has undefined yet");        
    }
    
}
