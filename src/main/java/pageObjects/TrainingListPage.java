package pageObjects;

import constants.search_enum.LocationConfig;
import constants.search_enum.SkillsConfig;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(TrainingListPage.class);

    private By filterFieldCloseButtons = By.cssSelector(".filter-field__title.ng-binding span");

    private By searchContainer = By.cssSelector(".training-list .filters .input-field-search");

    private By searchField = By.xpath("//input[@name='training-filter-input']");

    private By searchBySkillsButton = By.xpath("//div[@class='drop-down-choose__header']/div[contains(@ng-click,'Skill')]");

    private By searchByLocationsButton = By.xpath("//div[@class='drop-down-choose__header']/div[contains(@ng-click,'Location')]");

    private By fieldForScrollInSkills = By.xpath("//label[@ng-class=\"{'location__location-active-label': checkActiveSkills()}\"]");

    private By fieldForScrollInLists = By.xpath("//div[contains(@class,'location__countryCheckBox')]");

    private By trainingsList = By.xpath("//div[contains(@class,'training-list__container')]//div[@class='training-item__info-wrapper']/div[1]");

    private By trainingListTitles = By.xpath("//div[contains(@class,'training-list__container')]//div[contains(@class,'training-item__title')]");

    private By trainingListLocations = By.xpath("//div[contains(@class,'training-list__container')]//div[contains(@class,'training-item__location')]/span");

    private By trainingListMultiLocations = By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(@class,'rd-tooltip-text')]");

    private By emptyListMessage = By.xpath("//span[@ng-show]");


    @Step("{method}: Closed all search filters")
    public TrainingListPage closeAllFilters() {
        scrollToElement(getElementPresence(searchContainer));
        if (isDisplayed(filterFieldCloseButtons)) {
            List<WebElement> closeButtons = getElements(filterFieldCloseButtons);
            for (WebElement button : closeButtons) {
                button.click();
            }
        }
        LOG.info("All filters closed");
        return this;
    }

    @Step(": 'Search field' is clicked")
    public TrainingListPage clickSearchField() {
        getElementToClick(searchField).click();
        LOG.info("'Search Field' clicked");
        return this;
    }


    @Step(": 'By Skills' tab clicked")
    public TrainingListPage clickSearchBySkillsButton() {
        getElement(searchBySkillsButton).click();
        scrollToElement(getElementPresence(fieldForScrollInSkills));
        LOG.info("'By Skills' tab clicked");
        return this;
    }

    @Step(": 'Locations' tab clicked")
    public TrainingListPage clickSearchByLocationsButton() {
        getElement(searchByLocationsButton).click();
        scrollToElement(getElementPresence(fieldForScrollInLists));
        LOG.info("'By Locations' tab clicked");
        return this;
    }


    @Step(": Checkbox with '{0}' clicked")
    public TrainingListPage clickSkillsCheckboxByName(SkillsConfig skillName) {
        String skill = skillName.getSkillName();
        String locator = String.format("//label[@class='location__not-active-label ng-binding'][normalize-space()='%s']", skill);
        By searchBySkillsCheckbox = By.xpath(locator);
        getElement(searchBySkillsCheckbox).click();
        LOG.info(String.format("'%s' checkbox clicked", skill));
        return this;
    }

    @Step(": List item with '{0}' clicked")
    public TrainingListPage clickLocationsCountryItemByName(LocationConfig locationConfig) {
        String countryName = locationConfig.getCountryName();
        String locator = String.format("//ul[@class='location__countries-list-countries']//div[normalize-space()='%s']", countryName);
        By searchByLocationCountry = By.xpath(locator);
        getElement(searchByLocationCountry).click();
        LOG.info(String.format("'%s' item clicked", countryName));
        return this;

    }

    @Step(": Checkbox with '{0}' clicked")
    public TrainingListPage clickLocationsCityCheckboxByName(LocationConfig locationConfig) {
        String cityName = locationConfig.getCityName();
        String locator = String.format("//ul[@class='location__cities-list-cities ng-scope']//label[normalize-space()='%s']", cityName);
        By searchByLocationCity = By.xpath(locator);
        getElement(searchByLocationCity).click();
        LOG.info(String.format("'%s' checkbox clicked", cityName));
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
        if (!isNotExist(trainingListLocations)) {
            List<WebElement> courses = getElements(trainingListLocations);
            for (WebElement course : courses) {
                if (course.getAttribute("outerText").toLowerCase().contains(location.toLowerCase())) {
                    size++;
                }
            }
        } else {
            LOG.info(String.format("Results of search not contains courses in '%s'", location));
        }
        return size;
    }

    public int getTrainingsListSizeWithMultiLocation() {
        int emptyList = 0;
        if (isNotExist(trainingListMultiLocations)) {
            LOG.info("Results of search not contains Multi Location courses");
            return emptyList;
        } else {
            return getElements(trainingListMultiLocations).size();
        }
    }

    public boolean isEmptyListMessageIsDisplayed() {
        return isDisplayed(emptyListMessage);
    }
}
