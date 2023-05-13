
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;


public class LoginTests extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(LoginTests.class);

    @Test
    public void LoginValidEmailPasswordTest () {

        LOG.debug("LoginValidEmailPasswordTest is running on Jenkins");

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());

    }

    @Test
    public void LoginEmptyPasswordTest () {

        LOG.debug("LoginEmptyPasswordTest is running on Jenkins");

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }


}