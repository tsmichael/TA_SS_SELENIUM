package pageObjects;

import constants.BusinessConfig;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

    private By signInButton = By.className("header-auth__signin");

    public HomePage proceedToHomePage() {
        proceedToPage(BusinessConfig.HOME_PAGE_URL.getPath());
        return this;
    }

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        return new SignInPage();
    }
}
