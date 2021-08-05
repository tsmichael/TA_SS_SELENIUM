package pageObjects.businessObjects;

import constants.Language;
import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO {

    private HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage() {
        homePage.proceedToHomePage();
        return this;
    }

    public TrainingListBO proceedToTrainingListPage() {
        homePage.proceedToTrainingListPage();
        return new TrainingListBO();
    }

    public BlogBO proceedToBlogPage() {
        homePage.proceedToBlogPage();
        return new BlogBO();
    }

    public HomeBO clickGlobeIcon() {
        homePage.clickGlobeIcon();
        return this;
    }

    public SignInBO clickSignInButton() {
        homePage.clickSignInButton();
        return new SignInBO();
    }

    public HomeBO clickAcceptCookiesButton() {
        homePage.clickAcceptCookiesButton();
        return this;
    }

    public void verifyTopRightUserNameIsDisplayed() {
        Assert.assertTrue(homePage.isUserNameIsDisplayed(), "user name is NOT displayed");
    }

    public HomeBO chooseLanguageByName(Language language, Language domain) {
        homePage.clickGlobeIcon()
                .clickLanguageItem(language)
                .waitForPageTranslateItself(domain);
        return this;
    }

    public void verifyLanguageBySignInButtonText(Language buttonText) {
        String signInButtonText = homePage.getSignInButtonText();
        Assert.assertEquals(signInButtonText, buttonText.getSignInButtonText(), String.format("'%s' button incorrect translated", signInButtonText));
    }
}
