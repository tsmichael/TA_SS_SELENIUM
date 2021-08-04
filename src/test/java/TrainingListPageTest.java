import constants.BusinessConfig;
import constants.SkillsConfig;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import tools.JSONDataConfig;

public class TrainingListPageTest extends BaseTest {

    JSONDataConfig jsonDataConfig = new JSONDataConfig(BusinessConfig.USER_CREDENTIALS.getPath());

    @Test
    public void verifyTrainingListSearchResultBySkill() {
        HomeBO homeBo = new HomeBO();
        homeBo
                .proceedToHomePage()
                .clickAcceptCookiesButton()
                .clickSignInButton()
                .login(jsonDataConfig.getEmailFromJson(0), jsonDataConfig.getPasswordFromJson(0))
                .proceedToTrainingListPage()
                .closeAllFilters()
                .addSkillToSearchByName(SkillsConfig.JAVA.getSkillName())
                .verifyAllElementsContainsAppropriateText(SkillsConfig.JAVA.getSkillName());
    }

    @Test
    public void verifyErrorMessageOfEmptyTrainingListDisplayed() {
        HomeBO homeBo = new HomeBO();
        homeBo
                .proceedToHomePage()
                .clickAcceptCookiesButton()
                .clickSignInButton()
                .login(jsonDataConfig.getEmailFromJson(0), jsonDataConfig.getPasswordFromJson(0))
                .proceedToTrainingListPage()
                .closeAllFilters()
                .addSkillToSearchByName(SkillsConfig.RUBY.getSkillName())
                .verifyEmptyTrainingListMessageIsDisplayed();
    }
}
