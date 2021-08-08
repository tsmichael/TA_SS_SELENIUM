package pageObjects.businessObjects;

import constants.search_enum.LocationConfig;
import constants.search_enum.SkillsConfig;
import io.qameta.allure.Step;
import org.testng.Assert;
import pageObjects.TrainingListPage;

public class TrainingListBO {

    TrainingListPage trainingListPage;

    TrainingListBO() {
        trainingListPage = new TrainingListPage();
    }

    public TrainingListBO closeAllFilters() {
        trainingListPage.closeAllFilters();
        return this;
    }

    @Step("Adding skill to search filter, running method: {method}")
    public TrainingListBO addSkillToSearchByName(SkillsConfig skill) {
        trainingListPage
                .clickSearchField()
                .clickSearchBySkillsButton()
                .clickSkillsCheckboxByName(skill)

        ;
        return this;
    }

    @Step("Adding location to search filter, running method: {method}")
    public TrainingListBO addLocationToSearchByName(LocationConfig locationConfig) {
        trainingListPage
                .clickSearchField()
                .clickSearchByLocationsButton()
                .clickLocationsCountryItemByName(locationConfig)
                .clickLocationsCityCheckboxByName(locationConfig)
        ;
        return this;
    }

    @Step("checking that returned courses contains skill, running method: {method}")
    public void verifyAllElementsContainsAppropriateText(SkillsConfig skillName) {
        String skill = skillName.getSkillName();
        Assert.assertEquals(trainingListPage.getTrainingsListSizeByTitleName(skill), trainingListPage.getTrainingsListSize(), String.format("NOT all courses has connection to '%s' skill filter.", skill));
    }

    @Step("checking message that no courses is displayed, running method: {method}")
    public void verifyEmptyTrainingListMessageIsDisplayed() {
        Assert.assertTrue(trainingListPage.isEmptyListMessageIsDisplayed(), "'Message' about empty list is not shown.");
    }

    @Step("checking that returned courses list belongs to the same country or multi location, running method: {method}")
    public void verifyAllElementsBelongsToAppropriateCountyOrMultiLocation(LocationConfig locationConfig) {
        String countryName = locationConfig.getCountryName();
        int listSizeWithCountryMatch = trainingListPage.getTrainingsListSizeByLocationName(countryName);
        int listSizeWithMultiMatch = trainingListPage.getTrainingsListSizeWithMultiLocation();
        int actualTotalListSize = listSizeWithCountryMatch + listSizeWithMultiMatch;
        Assert.assertEquals(actualTotalListSize, trainingListPage.getTrainingsListSize(), "Search result is not match expectation");
    }
}
