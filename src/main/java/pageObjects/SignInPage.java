package pageObjects;

import org.openqa.selenium.By;

public class SignInPage extends AbstractPage {

    private By emailInput = By.id("username");

    private By passwordInput = By.id("password");

    private By continueButton = By.id("kc-login-next");

    private By signInButton = By.id("kc-login");

    private By loginFailedErrorMessage = By.className("error-text");

    public SignInPage enterEmail(String email) {
        getElement(emailInput).sendKeys(email);
        return this;
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        return this;
    }

    public boolean isContinueButtonEnabled() {
        boolean isEnabled = isEnabled(continueButton);
        return isEnabled;
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        return this;
    }

    public HomePage clickSignInButton() {
        getElement(signInButton).click();
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        return isDisplayed;
    }

    public String getEmailText() {
        return getElement(emailInput).getText();
    }

    public boolean isAtSymbolPresentInEmailField() {
        String email = getEmailText();
        boolean present = email.contains("@");
        return present;
    }

    public boolean isAtSymbolAtStartInEmailField() {
        String email = getEmailText();
        char firstSign = email.charAt(0);
        if (firstSign == '@') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDotSymbolPresent() {
        String email = getEmailText();
        return email.contains("@");
    }
}
