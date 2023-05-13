
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;


public class LoginTests extends BaseTest {


    @Test
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();

        Assert.assertTrue(homePage.isAvatarDisplayed());

    }

    @Test
    public void LoginEmptyPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("demo@class.com")
                 .providePassword("te$t$tudent")
                 .clickSubmit();


        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
}