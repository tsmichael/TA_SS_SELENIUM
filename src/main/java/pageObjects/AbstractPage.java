package pageObjects;

import constants.ConstantConfig;
import driver.CustomDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {

    private WebDriverWait wait = new WebDriverWait(CustomDriver.getDriver(), ConstantConfig.EXPLICITLY_WAIT.getSeconds());

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        CustomDriver.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    public void waitForPageTranslateItself(String lang) {
        String link = "lang=" + lang;
        wait.until(ExpectedConditions.urlContains(link));
    }

    List<WebElement> getElements(By locator) {
        List<WebElement> webElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return webElements;
    }

    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        try {
            return getElement(locator)
                    .isEnabled();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
