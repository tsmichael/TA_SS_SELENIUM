package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.SignInPage;

public class SignInBO extends SignInPage {

    private SignInPage signInPage;

    public SignInBO() {
        signInPage = new SignInPage();
    }

    public HomeBO login(String email, String password) {
        signInPage.enterEmail(email)
                .clickContinueButton()
                .enterPassword(password)
                .clickSignInButton();
        return new HomeBO();
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }
}
