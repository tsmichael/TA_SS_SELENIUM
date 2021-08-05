import constants.DriverConfig;
import driver.CustomDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest  {

    @BeforeMethod
    public void preTest() {
        CustomDriver.initDriver(DriverConfig.CHROME_NAME);
    }

    @AfterMethod
    public void postTest() {
        CustomDriver.quitDriver();
    }
}
