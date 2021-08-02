package pageObjects;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class SignInPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private By emailInput = By.id("username");

    private By passwordInput = By.id("password");

    private By continueButton = By.id("kc-login-next");

    private By signInButton = By.id("kc-login");

    private By loginFailedErrorMessage = By.className("error-text");

    public SignInPage enterEmail(String email) {
        getElement(emailInput).sendKeys(email);
        LOG.info("Entered email");
        return this;
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        LOG.info("'Continue' button clicked");
        return this;
    }

    public boolean isContinueButtonEnabled() {
        boolean isEnabled = isEnabled(continueButton);
        LOG.info(String.format("'Continue' button ENABLED - [%s]",isEnabled));
        return isEnabled;
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        LOG.info("Entered password");
        return this;
    }

    public HomePage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign IN' button clicked");
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Error message is displayed - [%s]",isDisplayed));
        return isDisplayed;
    }

    public String getEmailText() {
        return getElement(emailInput).getAttribute("value");
    }

    public boolean isAtSymbolPresentInEmailField() {
        String email = getEmailText();
        boolean present = email.contains("@");
        return present;
    }

    public boolean isAtSymbolAtStartInEmailField() {
        String email = getEmailText();
        Character firstSign = email.charAt(0);
        if (firstSign.equals("@")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDotSymbolPresentInEmail() {
        String email = getEmailText();
        return email.contains(".");
    }
}
