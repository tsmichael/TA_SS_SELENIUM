package pageObjects;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import static constants.BusinessConfig.HOME_PAGE_URL;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private By signInButton = By.className("header-auth__signin");

    private By topRightCornerUserName = By.className("user-info__name");

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL.getPath());
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL.getPath()));
        return this;
    }

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign IN' button clicked");
        return new SignInPage();
    }

    public boolean isUserNameIsDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserName);
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
        return isDisplayed;
    }
}
