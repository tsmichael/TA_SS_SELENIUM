package pageObjects.businessObjects;

import constants.LocationConfig;
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

    public TrainingListBO addSkillToSearchByName(String skill) {
        trainingListPage
                .clickSearchField()
                .clickSearchBySkillsButton()
                .clickSkillsCheckboxByName(skill)
        ;
        return this;
    }

    public TrainingListBO addLocationToSearchByName(LocationConfig locationConfig) {
        trainingListPage
                .clickSearchField()
                .clickSearchByLocationsButton()
                .clickLocationsCountryItemByName(locationConfig)
                .clickLocationsCityCheckboxByName(locationConfig)
        ;
        return this;
    }

    public void verifyAllElementsContainsAppropriateText(String skill) {
        Assert.assertEquals(trainingListPage.getTrainingsListSizeByTitleName(skill), trainingListPage.getTrainingsListSize(), String.format("NOT all courses has connection to '%s' skill filter.", skill));
    }

    public void verifyEmptyTrainingListMessageIsDisplayed() {
        Assert.assertTrue(trainingListPage.isEmptyListMessageIsDisplayed(), "'Message' about empty list is not shown.");
    }

    public void verifyAllElementsBelongsToAppropriateCountyOrMultiLocation(LocationConfig locationConfig) {
        String countryName = locationConfig.getCountryName();
        int listSizeWithCountryMatch = trainingListPage.getTrainingsListSizeByLocationName(countryName);
        int listSizeWithMultiMatch = trainingListPage.getTrainingsListSizeWithMultiLocation();
        int actualTotalListSize = listSizeWithCountryMatch + listSizeWithMultiMatch;
        Assert.assertEquals(actualTotalListSize, trainingListPage.getTrainingsListSize(), "Search result is not match expectation");
    }
}
