package pageObjects;

import constants.LocationConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrainingListPage extends AbstractPage {

    private By filterFieldCloseButtons = By.cssSelector(".filter-field__title.ng-binding span");

    private By searchContainer = By.cssSelector(".training-list .filters .input-field-search");

    private By searchField = By.xpath("//input[@name='training-filter-input']");

    private By searchBySkillsButton = By.xpath("//div[@class='drop-down-choose__header']/div[contains(@ng-click,'Skill')]");

    private By searchByLocationsButton = By.xpath("//div[@class='drop-down-choose__header']/div[contains(@ng-click,'Location')]");

    private By fieldForScrollInLists = By.xpath("//div[contains(@class,'location__countryCheckBox')]");

    private By trainingsList = By.xpath("//div[contains(@class,'training-list__container')]//div[@class='training-item__info-wrapper']/div[1]");

    private By trainingListTitles = By.xpath("//div[contains(@class,'training-list__container')]//div[contains(@class,'training-item__title')]");

    private By trainingListLocations = By.xpath("//div[contains(@class,'training-list__container')]//div[contains(@class,'training-item__location')]/span");

    private By trainingListMultiLocations = By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(@class,'rd-tooltip-text')]");

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
        scrollToElement(getElement(fieldForScrollInLists));
        return this;
    }

    public TrainingListPage clickSearchByLocationsButton() {
        getElement(searchByLocationsButton).click();
        scrollToElement(getElementPresence(fieldForScrollInLists));
        return this;
    }

    public TrainingListPage clickSkillsCheckboxByName(String skillName) {
        String locator = String.format("//ul[@class='city skills']//label[normalize-space()='%s']/span", skillName);
        By searchBySkillsCheckbox = By.xpath(locator);
        getElement(searchBySkillsCheckbox).click();
        return this;
    }

    public TrainingListPage clickLocationsCountryItemByName(LocationConfig locationConfig) {
        String countryName = locationConfig.getCountryName();
        String locator = String.format("//ul[@class='location__countries-list-countries']//div[normalize-space()='%s']", countryName);
        By searchByLocationCountry = By.xpath(locator);
        getElement(searchByLocationCountry).click();
        return this;

    }

    public TrainingListPage clickLocationsCityCheckboxByName(LocationConfig locationConfig) {
        String cityName = locationConfig.getCityName();
        String locator = String.format("//ul[@class='location__cities-list-cities ng-scope']//label[normalize-space()='%s']", cityName);
        By searchByLocationCity = By.xpath(locator);
        getElement(searchByLocationCity).click();
        return this;
    }

    public int getTrainingsListSize() {
        return getElements(trainingsList).size();
    }

    public int getTrainingsListSizeByTitleName(String skillName) {
        int size = 0;
        List<WebElement> courses = getElements(trainingListTitles);
        for (WebElement course : courses) {
            if (course.getText().toLowerCase().contains(skillName.toLowerCase())) {
                size++;
            }
        }
        return size;
    }

    public int getTrainingsListSizeByLocationName(String location) {
        int size = 0;
        try {
            List<WebElement> courses = getElements(trainingListLocations);
            for (WebElement course : courses) {
                if (course.getAttribute("outerText").toLowerCase().contains(location.toLowerCase())) {
                    size++;
                }
            }
        } catch (TimeoutException timeOutEx) {
            size = 0;
        }
        return size;
    }

    public int getTrainingsListSizeWithMultiLocation() {
        int size = 0;
        try {
            size = getElements(trainingListMultiLocations).size();
        } catch (TimeoutException timeOutEx) {
            size = 0;
        }
        return size;
    }

    public boolean isEmptyListMessageIsDisplayed() {
        return isDisplayed(emptyListMessage);
    }
}
