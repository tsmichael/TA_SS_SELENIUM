package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.SignInPage;
import tools.Regex;

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

    public void isEmailNotMatchCriteria(String email) {
        Assert.assertFalse(Regex.isEmailValid(email), "e-mail is VALID, check e-mail criteria options");
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }

    public void verifyContinueButtonIsDisabled() {
        Assert.assertFalse(isContinueButtonEnabled(), "'Continue Button' is enabled");
    }
}
