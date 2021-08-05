import constants.BlogNavElements;
import constants.Language;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;

public class BlogPageTest extends BaseTest{

    @Test
    public void ttt(){
        HomeBO homeBO = new HomeBO();
        homeBO
                .proceedToHomePage()
                .chooseLanguageByName(Language.ENGLISH.getLanguage(),Language.ENGLISH.getDomain())
                .proceedToBlogPage()
                .verifyAllBlogLinksIsDisplayed();
    }
}
