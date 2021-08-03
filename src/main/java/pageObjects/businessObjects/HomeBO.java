package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;

public class HomeBO extends HomePage {

    private HomePage homePage;

    public HomeBO(){
        homePage = new HomePage();
    }

    public HomeBO proceedToHomePage(){
        homePage.proceedToHomePage();
        return this;
    }

    public SignInBO clickSignInButton(){
        homePage.clickSignInButton();
        return new SignInBO();
    }

    public void verifyTopRightUserNameIsDisplayed(){
        Assert.assertTrue(isUserNameIsDisplayed(), "user name is NOT displayed");
    }
}
