import constants.Language;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class HomePageTest extends BaseTest {

    @Test(description = "Verify user can change language")
    public void verifyUserAbleChangeLanguage() {
        new HomeBO()
                .proceedToHomePage()
                .chooseLanguageByName(Language.UKRAINIAN, Language.UKRAINIAN)
                .verifyLanguageBySignInButtonText(Language.UKRAINIAN);
    }
}
