package pageObjects;

import constants.DriverConfig;
import driver.CustomDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {

    private static WebDriverWait wait = new WebDriverWait(CustomDriver.getDriver(), DriverConfig.EXPLICITLY_WAIT.getSeconds());

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        CustomDriver.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    List<WebElement> getElements(By locator) {
        return CustomDriver.getDriver().findElements(locator);
    }

    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
