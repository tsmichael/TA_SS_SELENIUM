import constants.BusinessConfig;
import data.EmailsDataProvider;
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

    @Test(priority = 3,
            description = "verify that button is disabled when user enter invalid email address",
            dataProvider = "incorrectEmailsProvider", dataProviderClass = EmailsDataProvider.class)
    public void verifyContinueButtonIsDisabledWithInvalidEmail(String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email);
        new SignInBO()
                .isEmailNotMatchCriteria();
        new SignInBO()
                .verifyContinueButtonIsDisabled();
    }

    @Test(priority = 4,
            description = "Verify Continue button is enabled when user enters an appropriate email address",
            dataProvider = "validByBVAEmailsProvider", dataProviderClass = EmailsDataProvider.class)
    public void verifyContinueButtonIsEnabledWithValidEmail(String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email);
        new SignInBO()
                .isEmailMatchCriteria();
        new SignInBO()
                .verifyContinueButtonIsEnabled();
    }
}
