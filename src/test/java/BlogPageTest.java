import constants.Language;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class BlogPageTest extends BaseTest {

    @Test(description = "Verify Blog Titles is displayed by their names")
    public void verifyBlogTitleLinksDisplayByName() {
        new HomeBO()
                .proceedToHomePage()
                .chooseLanguageByName(Language.ENGLISH, Language.ENGLISH)
                .proceedToBlogPage()
                .verifyAllBlogLinksIsDisplayedByName();
    }

    @Test(description = "Verify Blog titles is displayed by their links")
    public void verifyBlogTitleLinksDisplayByLink() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToBlogPage()
                .verifyAllBlogLinksIsDisplayedByLink();
    }
}
