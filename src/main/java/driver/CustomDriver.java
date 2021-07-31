package driver;

import constants.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CustomDriver {

    private static WebDriver webDriver;

    protected void initDriver(final String browserName) {

        if (DriverConfig.CHROME_NAME.getPath().equals(browserName)) {
            System.setProperty(DriverConfig.CHROME_NAME.getPath(), DriverConfig.CHROME_DRIVER_LOCATION.getPath());
            webDriver = new ChromeDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(DriverConfig.IMPLICITLY_WAIT.getSeconds(), TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    protected void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
