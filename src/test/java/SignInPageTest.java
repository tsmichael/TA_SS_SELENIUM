import constants.BusinessConfig;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;
import tools.JSONDataConfig;

public class SignInPageTest extends BaseTest {

    JSONDataConfig jsonDataConfig = new JSONDataConfig(BusinessConfig.USER_CREDENTIALS.getPath());

    @Test(priority = 1, description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccessfullyLoggedIn() {
        HomeBO homeBO = new HomeBO();
        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        new SignInBO()
                .login(jsonDataConfig.getEmailFromJson(0), jsonDataConfig.getPasswordFromJson(0));
        homeBO
                .verifyTopRightUserNameIsDisplayed();
    }

    @Test(priority = 2, description = "Verify user receives an error message when trying to log in with incorrect credentials")
    public void verifyUserCanNotLoginWithWrongPassword() {
        HomeBO homeBO = new HomeBO();
        homeBO
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(jsonDataConfig.getEmailFromJson(1))
                .clickContinueButton()
                .enterPassword(jsonDataConfig.getPasswordFromJson(1))
                .clickSignInButton();
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayed();
    }
}