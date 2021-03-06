package pageObjects;

import constants.ConstantConfig;
import constants.Language;
import driver.CustomDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {

    private WebDriverWait wait = new WebDriverWait(CustomDriver.getDriver(), ConstantConfig.EXPLICITLY_WAIT.getSeconds());

    private Actions action = new Actions(CustomDriver.getDriver());

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        CustomDriver.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    WebElement getElementToClick(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return webElement;
    }

    WebElement getElementPresence(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return webElement;
    }

    public void waitForPageTranslateItself(Language domain) {
        String link = "lang=" + domain.getDomain();
        wait.until(ExpectedConditions.urlContains(link));
    }

    List<WebElement> getElements(By locator) {
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator), ExpectedConditions.presenceOfAllElementsLocatedBy(locator)));
        return CustomDriver.getDriver().findElements(locator);
    }

    public void scrollToElement(WebElement webElement) {
        action.moveToElement(webElement).perform();
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

    public boolean isNotExist(By locator) {
        CustomDriver.getDriver().manage().timeouts().implicitlyWait(ConstantConfig.IMPLICITLY_WAIT_ONE.getSeconds(), TimeUnit.SECONDS);
        boolean isNotExist = CustomDriver.getDriver().findElements(locator).isEmpty();
        CustomDriver.getDriver().manage().timeouts().implicitlyWait(ConstantConfig.IMPLICITLY_WAIT.getSeconds(), TimeUnit.SECONDS);
        return isNotExist;
    }
}
