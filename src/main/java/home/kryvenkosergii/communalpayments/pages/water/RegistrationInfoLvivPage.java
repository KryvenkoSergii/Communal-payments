package home.kryvenkosergii.communalpayments.pages.water;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import home.kryvenkosergii.communalpayments.pages.RegistrationPage;

/**
 * RegistrationInfoLvivPage describes page 'https://infolviv.com.ua/users/sign_up'.
 * Here we can register. This class didn't complete yet.
 * @author SergiiK
 * 2020-08-28
 */
public class RegistrationInfoLvivPage extends RegistrationPage {
    //
    private WebDriver driver;
    private WebDriverWait wait;
    //
    public RegistrationInfoLvivPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    private void initElements() {
        System.out.println("this class has undefined yet");        
    }
    
}
