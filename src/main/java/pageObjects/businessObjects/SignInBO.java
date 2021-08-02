package pageObjects.businessObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
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
        String errorMessage = "'" + email + "' match email-criteria";
        Assert.assertFalse(Regex.isEmailValid(email), String.format("%s", errorMessage));
    }

    public void verifyAtSymbolNotPresentInEmail() {
        Assert.assertFalse(isAtSymbolPresentInEmailField(), "entered email is contains '@' symbol");
    }

    public void verifyAtSymbolAtStartInEmail() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertFalse(isAtSymbolAtStartInEmailField(), "'@' is not placed at beginning");
    }

    public void verifyDotSymbolNotPresentInEmail() {
        Assert.assertFalse(isDotSymbolPresentInEmail(), "'.' is present in email");
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }

    public void verifyContinueButtonIsDisabled() {
        Assert.assertFalse(isContinueButtonEnabled(), "'Continue Button' is enabled");
    }
}
