package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO extends HomePage {

    private HomePage homePage;

    public HomeBO(){
        homePage = new HomePage();
    }

    public void verifyTopRightUserNameIsDisplayed(){
        Assert.assertTrue(isUserNameIsDisplayed());
    }
}
