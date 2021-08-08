package pageObjects.businessObjects;

import constants.nav_enum.BlogNavElements;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pageObjects.BlogPage;
import tools.AllureLogger;

public class BlogBO {

    private BlogPage blogPage;

    public BlogBO() {
        blogPage = new BlogPage();
    }

    @Step("checking all Blog Titles is displayed, running method: {method}")
    public void verifyAllBlogLinksIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        for (BlogNavElements link : BlogNavElements.values()) {
            boolean isDisplayed = blogPage.isDisplayed(blogPage.getBlogTitleLocatorByName(link.toString()));
            softAssert.assertTrue(isDisplayed, String.format("'%s' title is NOT displayed", link));
            AllureLogger.info(String.format("'%s' title is displayed - [%b]",link.getName(),isDisplayed));
        }
        softAssert.assertAll();
    }

}
