package home.kryvenkosergii.communalpayments.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.data.UserRepository;
import home.kryvenkosergii.communalpayments.pages.gas.CabinetInfo104uaPage;
import home.kryvenkosergii.communalpayments.pages.gas.Title104uaPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * 104UA site testing (smoke test).
 * @author SergiiK 2020-08-24
 */
public class Gas104UASiteTest extends TestRunner {

    /**
     * Data provider (returns credentials for 104UA site).
     * @return User class.
     */
    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] { { UserRepository.get().user104UACredentials() }, };
    }

    /**
     * Checking if is presents user's private invoice on the consumer's info page.
     * @param user
     */
    @Epic("104UA site testing. Checking if is presents user private invoice on the consumer's info page.")
    @Feature(value = "checking user's private invoice")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In 'cabinet/info' page, we checking user's private invoice.")
    @Story(value = "Smoke test. Go to info page and check if is presents user's private invoice.")
    @Parameters("User's credentials")
    @Test(dataProvider = "validCredentialUser")
    public void smokeTest104UA(User user) {
        logger.info("start smokeTest104UA with user = " + user.toString());
        getToLinkWebSite104UA(driver);
        CabinetInfo104uaPage cabinetInfo104uaPage = new Title104uaPage(driver).clickLoginButton(driver).signIn(user);
        Assert.assertTrue(cabinetInfo104uaPage.getUserCredential().contains(user.getUserNumber()));
    }
}
