package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.TrainingListPage;

public class TrainingListBO  {

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

    public void verifyAllElementsContainsAppropriateText(String skill) {
        Assert.assertEquals(trainingListPage.getTrainingsListSizeOfCourseByName(skill), trainingListPage.getTrainingsListSize(), String.format("NOT all courses has connection to '%s' skill filter.", skill));
    }

    public void verifyEmptyTrainingListMessageIsDisplayed() {
        Assert.assertTrue(trainingListPage.isEmptyListMessageIsDisplayed(), "'Message' about empty list is not shown.");
    }
}
