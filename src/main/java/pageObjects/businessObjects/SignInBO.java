package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.SignInPage;
import tools.Regex;

public class SignInBO {

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

    public SignInBO enterEmail(String email) {
        signInPage.enterEmail(email);
        return this;
    }

    public SignInBO clickContinueButton() {
        signInPage.clickContinueButton();
        return this;
    }

    public SignInBO enterPassword(String password) {
        signInPage.enterPassword(password);
        return this;
    }

    public HomeBO clickSignInButton() {
        signInPage.clickSignInButton();
        return new HomeBO();
    }

    public void isEmailNotMatchCriteria() {
        String email = signInPage.getEmailText();
        String errorMessage = "'" + email + "' match email-criteria";
        Assert.assertFalse(Regex.isEmailValid(email), String.format("%s", errorMessage));
    }

    public void isEmailMatchCriteria() {
        String email = signInPage.getEmailText();
        String errorMessage = "'" + email + "' DOES NOT match email-criteria";
        Assert.assertTrue(Regex.isEmailValid(email), String.format("%s", errorMessage));
    }

    public void verifyAtSymbolNotPresentInEmail() {
        Assert.assertFalse(signInPage.isAtSymbolPresentInEmailField(), "entered email is contains '@' symbol");
    }

    public void verifyAtSymbolAtStartInEmail() {
        Assert.assertFalse(signInPage.isAtSymbolAtStartInEmailField(), "'@' is not placed at beginning");
    }

    public void verifyDotSymbolNotPresentInEmail() {
        Assert.assertFalse(signInPage.isDotSymbolPresentInEmail(), "'.' is present in email");
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(signInPage.isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }

    public void verifyContinueButtonIsDisabled() {
        Assert.assertFalse(signInPage.isContinueButtonEnabled(), "'Continue Button' is ENABLED");
    }

    public void verifyContinueButtonIsEnabled() {
        Assert.assertTrue(signInPage.isContinueButtonEnabled(), "'Continue Button' is DISABLED");
    }
}
