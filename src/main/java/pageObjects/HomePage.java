package pageObjects;

import constants.NavElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import java.util.List;

import static constants.BusinessConfig.HOME_PAGE_URL;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private By signInButton = By.className("header-auth__signin");

    private By globeIcon = By.className("location-selector__globe");

    private By languageList = By.cssSelector(".location-selector__item a");

    private By trainingSection = By.cssSelector("#training-list h1");

    private By topRightCornerUserName = By.className("user-info__name");

    private String trainingListLocatorUnLogin = (String.format("//a[contains(@class,'main-nav__item') and contains(@href,'%s')]", NavElements.TRAINING_LIST.getLink()));
    private String trainingListLocator = (String.format("//ul[@class='main-nav__list']//a[contains(@href,'%s')]", NavElements.TRAINING_LIST.getLink()));

    private By trainingList = By.xpath(trainingListLocator);

    private By acceptCookiesButton = By.className("footer-modal__button");

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL.getPath());
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL.getPath()));
        return this;
    }

    public TrainingListPage proceedToTrainingListPage() {
        getElement(trainingList).click();
        LOG.info(String.format("Proceeded to '%s' URL.", NavElements.TRAINING_LIST.getLink()));
        return new TrainingListPage();
    }

    public HomePage clickGlobeIcon() {
        getElement(globeIcon).click();
        LOG.info("'Language choice' is opened");
        return this;
    }

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign IN' button clicked");
        return new SignInPage();
    }

    public String getSignInButtonText() {
        return getElement(signInButton).getText();
    }

    public boolean isUserNameIsDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserName);
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
        return isDisplayed;
    }

    public WebElement getLanguageElementByName(String language) {
        List<WebElement> languageItems = getElements(languageList);
        WebElement item = null;
        for (WebElement current : languageItems) {
            if (current.getText().toLowerCase().contains(language.toLowerCase())) {
                item = current;
                break;
            }
        }
        return item;
    }

    public HomePage clickLanguageItem(String language) {
        getLanguageElementByName(language).click();
        return this;
    }

    public HomePage clickAcceptCookiesButton() {

        getElement(acceptCookiesButton).click();
        return this;
    }
}
