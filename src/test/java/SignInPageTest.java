import constants.BusinessConfig;
import data.CustomUser;
import data.EmailsDataProvider;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;
import tools.JsonReader;

public class SignInPageTest extends BaseTest {

    JsonReader jsonReader = new JsonReader(BusinessConfig.USER_CREDENTIALS);
    CustomUser validUser = jsonReader.getValidUser();
    CustomUser invalidUser = jsonReader.getInvalidUser();

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccessfullyLoggedIn() {
        HomeBO homeBO = new HomeBO();
        homeBO
                .proceedToHomePage()
                .clickSignInButton();
        new SignInBO()
                .login(validUser.email, validUser.password);
        homeBO
                .verifyTopRightUserNameIsDisplayed();
    }

    @Test(description = "Verify user receives an error message when trying to log in with incorrect credentials")
    public void verifyUserCanNotLoginWithWrongPassword() {
        HomeBO homeBO = new HomeBO();
        homeBO
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(invalidUser.email)
                .clickContinueButton()
                .enterPassword(invalidUser.email)
                .clickSignInButton();
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(
            description = "verify that button is disabled when user enter invalid email address",
            dataProvider = "incorrectEmailsProvider", dataProviderClass = EmailsDataProvider.class)
    public void verifyContinueButtonIsDisabledWithInvalidEmail(String description, String email) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email);
        new SignInBO()
                .isEmailNotMatchCriteria();
        new SignInBO()
                .verifyContinueButtonIsDisabled();
    }

    @Test(
            description = "Verify Continue button is enabled when user enters an appropriate email address",
            dataProvider = "validByBVAEmailsProvider", dataProviderClass = EmailsDataProvider.class)
    public void verifyContinueButtonIsEnabledWithValidEmail(String description, String email) {
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
