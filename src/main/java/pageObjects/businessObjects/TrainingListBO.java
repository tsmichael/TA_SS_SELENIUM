package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.TrainingListPage;

public class TrainingListBO extends TrainingListPage {

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
        Assert.assertEquals(getTrainingsListSizeOfCourseByName(skill), getTrainingsListSize(), String.format("NOT all courses has connection to '%s' skill filter.", skill));
    }
}
