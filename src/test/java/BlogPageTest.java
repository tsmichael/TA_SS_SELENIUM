import constants.Language;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class BlogPageTest extends BaseTest {

    @Test
    public void verifyBlogTitleLinksDisplay() {
        new HomeBO()
                .proceedToHomePage()
                .chooseLanguageByName(Language.ENGLISH, Language.ENGLISH)
                .proceedToBlogPage()
                .verifyAllBlogLinksIsDisplayed();
    }
}
