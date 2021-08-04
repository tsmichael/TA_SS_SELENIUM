package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO extends HomePage {

    private HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage() {
        homePage.proceedToHomePage();
        return this;
    }

    public HomeBO clickGlobeIcon() {
        homePage.clickGlobeIcon();
        return this;
    }

    public SignInBO clickSignInButton() {
        homePage.clickSignInButton();
        return new SignInBO();
    }

    public void verifyTopRightUserNameIsDisplayed() {
        Assert.assertTrue(isUserNameIsDisplayed(), "user name is NOT displayed");
    }

    public HomeBO chooseLanguageByName(String language, String domain) {
        homePage.clickGlobeIcon()
                .clickLanguageItem(language)
                .waitForPageTranslateItself(domain);
        return this;
    }

    public void verifyLanguageBySignInButtonText(String buttonText) {
        String signInButtonText = homePage.getSignInButtonText();
        Assert.assertEquals(signInButtonText, buttonText, String.format("'%s' button incorrect translated", signInButtonText));
    }
}
