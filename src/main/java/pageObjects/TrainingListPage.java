package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TrainingListPage extends AbstractPage {

    private By filterFieldCloseButtons = By.cssSelector(".filter-field__title.ng-binding span");

    private By searchContainer = By.cssSelector(".training-list .filters .input-field-search");//.training-list .filters
    private By searchField = By.xpath("//input[@name='training-filter-input']");
    private By searchBySkillsButton = By.xpath("//div[@class='drop-down-choose__header']/div[contains(@ng-click,'Skill')]");

    private By fieldForScrollInSkillList = By.xpath("//div[@class='location__countryCheckBox']");

    private By trainingsList = By.xpath("//div[contains(@class,'training-list__container')]//div[@class='training-item__info-wrapper']/div[1]");

    private By emptyListMessage = By.xpath("//span[@ng-show]");

    public TrainingListPage closeAllFilters() {

        scrollToElement(getElement(searchContainer));
        if (isDisplayed(filterFieldCloseButtons)) {
            List<WebElement> closeButtons = getElements(filterFieldCloseButtons);
            for (WebElement button : closeButtons) {
                button.click();
            }
        }
        return this;
    }

    public TrainingListPage clickSearchField() {
        getElementToClick(searchField).click();
        return this;
    }

    public TrainingListPage clickSearchBySkillsButton() {
        getElement(searchBySkillsButton).click();
        scrollToElement(getElement(fieldForScrollInSkillList));
        return this;
    }

    public TrainingListPage clickSkillsCheckboxByName(String skillName) {
        String locator = String.format("//label[normalize-space()='%s']/span", skillName);
        By searchBySkillsCheckbox = By.xpath(locator);
        getElement(searchBySkillsCheckbox).click();
        return this;
    }

    public int getTrainingsListSize() {
        return getElements(trainingsList).size();
    }

    public int getTrainingsListSizeOfCourseByName(String skillName) {
        int size = 0;
        List<WebElement> courses = getElements(trainingsList);
        for (WebElement course : courses) {
            if (course.getText().toLowerCase().contains(skillName.toLowerCase())) {
                size++;
            }
        }
        return size;
    }

    public boolean isEmptyListMessageIsDisplayed(){
        return isDisplayed(emptyListMessage);
    }
}
