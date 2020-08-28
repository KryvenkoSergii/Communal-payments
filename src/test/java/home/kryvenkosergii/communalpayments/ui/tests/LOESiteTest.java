package home.kryvenkosergii.communalpayments.ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import home.kryvenkosergii.communalpayments.data.User;
import home.kryvenkosergii.communalpayments.data.UserRepository;
import home.kryvenkosergii.communalpayments.pages.electricity.ConsumersInfoLOEPage;
import home.kryvenkosergii.communalpayments.pages.electricity.LoginLOEPage;

public class LOESiteTest extends TestRunner {

    @DataProvider
    public Object[][] validCredentialUser() {
        return new Object[][] { { UserRepository.get().userLOECredentials() }, };
//        return new Object[][] { { UserRepository.get().userLOECredentialsOnlyDayValue() }, };
    }

    @Test(dataProvider = "validCredentialUser")
    public void smokeTestLOE(User user) {
        logger.info("start smokeTestLOE with user = "
                + user.toString());
        getToLinkWebSiteLOE(driver);
        ConsumersInfoLOEPage consumersInfoLOEPage = new LoginLOEPage(driver).signIn(user).gotoConsumersInfoLOEPage();
        String actual = consumersInfoLOEPage.getUserEmail();
        String expected = user.getEmail();
        Assert.assertEquals(actual, expected, "user email didn't match with the email displayed on the site");
    }
}
