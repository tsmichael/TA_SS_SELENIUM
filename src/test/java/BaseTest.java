import driver.CustomDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends CustomDriver {

    @BeforeMethod
    public void preTest() {
        initDriver("webdriver.chrome.driver");
    }

    @AfterMethod
    public void postTest() {
        quitDriver();
    }
}
