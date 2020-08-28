package home.kryvenkosergii.communalpayments.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.data.UserRepository;
import home.kryvenkosergii.communalpayments.pages.water.CabinetInfoLvivPage;
import home.kryvenkosergii.communalpayments.pages.water.TitleInfoLvivPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * InfoLviv site testing (smoke test).
 * @author SergiiK
 * 2020-08-25
 */
public class InfoLvivSiteTest extends TestRunner {

    /**
     * Data provider (returns credentials for InfoLviv site).
     * @return User class.
     */
    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] { { UserRepository.get().userInfoLvivCredentials() }, };
    }

    /**
     * Checking if is presents user's private invoice and an email on the consumer's cabinet page.
     * @param user
     */
    @Epic("InfoLviv site testing. Checking if is presents user's private invoice and an email on the consumer's cabinet page.")
    @Feature(value = "checking user's private invoice and an email")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("In '...' page, we checking user's private invoice and an email.")
    @Story(value = "Smoke test. Go to cabinet page and check if is presents user's private invoice and an email.")
    @Parameters("User's credentials")
    @Test(dataProvider = "validCredentialUser")
    public void smokeTestInfoLviv(User user) {
        logger.info("start smokeTestInfoLviv with user = " + user.toString());
        getToLinkWebSiteINFOLVIV(driver);
        CabinetInfoLvivPage cabinetInfoLvivPage = new TitleInfoLvivPage(driver).clickLoginButton(driver).signIn(user);
        Assert.assertTrue(cabinetInfoLvivPage.getUserEmail().contains(user.getEmail()));
        Assert.assertTrue(cabinetInfoLvivPage.isUserInvoicePresents(user.getUserNumber()));
    }
}
