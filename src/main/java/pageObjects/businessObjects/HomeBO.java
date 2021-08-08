package pageObjects.businessObjects;

import constants.Language;
import io.qameta.allure.Step;
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

    @Step("Checking 'TOP RIGHT USER NAME' is displayed, running method: {method}")
    public void verifyTopRightUserNameIsDisplayed() {
        Assert.assertTrue(homePage.isUserNameIsDisplayed(), "user name is NOT displayed");
    }

    @Step("Choose language, running method: {method}")
    public HomeBO chooseLanguageByName(Language language, Language domain) {
        homePage.clickGlobeIcon()
                .clickLanguageItem(language)
                .waitForPageTranslateItself(domain);
        return this;
    }

    @Step("Checking language by 'Sign In' button text, running method: {method}")
    public void verifyLanguageBySignInButtonText(Language buttonText) {
        String signInButtonText = homePage.getSignInButtonText();
        Assert.assertEquals(signInButtonText, buttonText.getSignInButtonText(), String.format("'%s' button incorrect translated", signInButtonText));
    }
}
