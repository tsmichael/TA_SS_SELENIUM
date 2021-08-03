import constants.Language;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, description = "Verify user can change language")
    public void verifyUserAbleChangeLanguage() {
        HomeBO homeBO = new HomeBO();
        homeBO.proceedToHomePage()
                .chooseLanguageByName(Language.UKRAINIAN.getLanguage())
                .verifyLanguageBySignInButtonText(Language.UKRAINIAN.getSignInButtonText());
    }
}
