import constants.BusinessConfig;
import constants.LocationConfig;
import constants.SkillsConfig;
import data.CustomUser;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import tools.JsonReader;

public class TrainingListPageTest extends BaseTest {

    JsonReader jsonReader = new JsonReader(BusinessConfig.USER_CREDENTIALS);
    CustomUser validUser = jsonReader.getValidUser();

    @Test(description = "Verify Search result that display only appropriate courses with 'By Skill' filter")
    public void verifyTrainingListSearchResultBySkill() {
        new HomeBO()
                .proceedToHomePage()
                .clickAcceptCookiesButton()
                .clickSignInButton()
                .login(validUser.email, validUser.password)
                .proceedToTrainingListPage()
                .closeAllFilters()
                .addSkillToSearchByName(SkillsConfig.JAVA)
                .verifyAllElementsContainsAppropriateText(SkillsConfig.JAVA);
    }

    @Test(description = "Verify that message is displayed when training list in empty")
    public void verifyErrorMessageOfEmptyTrainingListDisplayed() {
        new HomeBO()
                .proceedToHomePage()
                .clickAcceptCookiesButton()
                .clickSignInButton()
                .login(validUser.email, validUser.password)
                .proceedToTrainingListPage()
                .closeAllFilters()
                .addSkillToSearchByName(SkillsConfig.RUBY)
                .verifyEmptyTrainingListMessageIsDisplayed();
    }

    @Test(description = "Verify Search result that display only appropriate courses with 'By Location' filter")
    public void verifySearchResultWithLocationCountryCityFilter() {
        new HomeBO()
                .proceedToHomePage()
                .clickAcceptCookiesButton()
                .clickSignInButton()
                .login(validUser.email, validUser.password)
                .proceedToTrainingListPage()
                .closeAllFilters()
                .addLocationToSearchByName(LocationConfig.LVIV)
                .verifyAllElementsBelongsToAppropriateCountyOrMultiLocation(LocationConfig.LVIV);
    }
}
