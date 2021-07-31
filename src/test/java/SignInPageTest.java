import constants.BusinessConfig;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;
import tools.JSONDataConfig;

public class SignInPageTest extends BaseTest{

    JSONDataConfig jsonDataConfig = new JSONDataConfig(BusinessConfig.USER_CREDENTIALS.getPath());

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccessfullyLoggedIn(){
        HomeBO homeBO = new HomeBO();
        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        new SignInBO()
                .login(jsonDataConfig.getEmailFromJson(0),jsonDataConfig.getPasswordFromJson(0));
        homeBO
                .verifyTopRightUserNameIsDisplayed();
    }
}
