package driver;

import constants.ConstantConfig;
import constants.DriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CustomDriver {

    private static CustomDriver instance = null;

    private static WebDriver webDriver;

    private CustomDriver() {
    }

    public static CustomDriver initDriver(DriverConfig driverConfig) {
        if (instance == null) {
            instance = new CustomDriver();
            if (DriverConfig.CHROME_NAME.equals(driverConfig)) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(ConstantConfig.IMPLICITLY_WAIT.getSeconds(), TimeUnit.SECONDS);
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
            instance = null;
        }
    }
}
