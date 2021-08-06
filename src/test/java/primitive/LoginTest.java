package primitive;

import constants.BusinessConfig;
import data.CustomUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.JsonReader;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    JsonReader jsonReader = new JsonReader(BusinessConfig.USER_CREDENTIALS);
    CustomUser validUser = jsonReader.getValidUser();
    CustomUser invalidUser = jsonReader.getInvalidUser();

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccessfullyLoggedIn() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.epam.ua");

        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.id("username"));
        emailInput.sendKeys(validUser.email);

        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(validUser.password);

        WebElement signInButtonForLogin = driver.findElement(By.id("kc-login"));
        signInButtonForLogin.click();

        WebElement userInfoName = driver.findElement(By.className("user-info__name"));

        Assert.assertTrue(userInfoName.isDisplayed());

        driver.quit();
    }

    @Test(description = "Verify user receives an error message when trying to log in with incorrect credentials")
    public void verifyUserCanNotLoginWithWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.epam.ua");

        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.id("username"));
        emailInput.sendKeys(invalidUser.email);

        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(invalidUser.password);

        WebElement signInButtonForLogin = driver.findElement(By.id("kc-login"));
        signInButtonForLogin.click();

        WebElement errorMessage = driver.findElement(By.className("error-text"));
        String errorMessageText = errorMessage.getAttribute("innerHTML");
        String expectedError = "We can't find user with such credentials.";
        Assert.assertEquals(errorMessageText, expectedError, "error message NOT displayed - something went wrong");

        driver.quit();
    }
}
