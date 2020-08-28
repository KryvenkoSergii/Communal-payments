package home.kryvenkosergii.communalpayments.launch;

import org.openqa.selenium.WebDriver;

import home.kryvenkosergii.communalpayments.data.UserRepository;
import home.kryvenkosergii.communalpayments.pages.electricity.ConsumersLOEPage;
import home.kryvenkosergii.communalpayments.pages.electricity.LoginLOEPage;
import home.kryvenkosergii.communalpayments.pages.gas.Title104uaPage;
import home.kryvenkosergii.communalpayments.pages.water.TitleInfoLvivPage;

/**
 * InputCommunalPayments class for input necessary data to provider's communal resources sites.
 * @author SergiiK
 * 2020-08-24
 */
public class InputCommunalPayments extends CommunalPaymentsRunner {

    /**
     * Main method.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // input value in infolviv.com.ua site
        new Thread(new Runnable() {
            public void run() {
                WebDriver driver = new InputCommunalPayments().launchDriverManagerChrome();
                new InputCommunalPayments().getToLinkWebSiteINFOLVIV(driver);
                new TitleInfoLvivPage(driver).clickLoginButton(driver).signIn(UserRepository.get().userInfoLvivCredentials())
                        .clickInputValueLink().inputValues();
//                new InputCommunalPayments().presentationSleep(5);
                new InputCommunalPayments().tearDownAfterProcess(driver);
            }
        }).start();

        // input value in 104UA site
        new Thread(new Runnable() {
            public void run() {
                WebDriver driver = new InputCommunalPayments().launchDriverManagerChrome();
                new InputCommunalPayments().getToLinkWebSite104UA(driver);
                new Title104uaPage(driver).clickLoginButton(driver).signIn(UserRepository.get().user104UACredentials())
                        .clickInputValueLink().inputValues();
//                new InputCommunalPayments().presentationSleep(3);
                new InputCommunalPayments().tearDownAfterProcess(driver);
            }
        }).start();

        // input value in LOE site
        new Thread(new Runnable() {
            public void run() {
                WebDriver driver = new InputCommunalPayments().launchDriverManagerChrome();
                new InputCommunalPayments().getToLinkWebSiteLOE(driver);
                ConsumersLOEPage consumersLOEPage = new LoginLOEPage(driver).signIn(UserRepository.get().userLOECredentials());
//                ConsumersLOEPage consumersLOEPage = new LoginLOEPage(driver).signIn(UserRepository.get().userLOECredentialsOnlyDayValue());
                consumersLOEPage.gotoConsumersInfoLOEPage().clickInputValueLink().inputValues();
//                new InputCommunalPayments().presentationSleep(3);
                new InputCommunalPayments().tearDownAfterProcess(driver);
            }
        }).start();

    }

}