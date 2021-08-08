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

    @Step("checking all Blog Titles is displayed by name, running method: {method}")
    public void verifyAllBlogLinksIsDisplayedByName() {
        SoftAssert softAssert = new SoftAssert();
        for (BlogNavElements link : BlogNavElements.values()) {
            String linkName = link.getName();
            boolean isDisplayed = blogPage.isDisplayed(blogPage.getBlogTitleLocatorByName(linkName));
            softAssert.assertTrue(isDisplayed, String.format("'%s' title is NOT displayed", linkName));
            AllureLogger.info(String.format("'%s' title-name is displayed - [%b]", linkName, isDisplayed));
        }
        softAssert.assertAll();
    }

    @Step("checking all Blog Titles is displayed by link, running method: {method}")
    public void verifyAllBlogLinksIsDisplayedByLink() {
        SoftAssert softAssert = new SoftAssert();
        for (BlogNavElements link : BlogNavElements.values()) {
            String linkLink = link.getLink();
            boolean isDisplayed = blogPage.isDisplayed(blogPage.getBlogTitleLocatorByLink(linkLink));
            softAssert.assertTrue(isDisplayed, String.format("'%s' link is NOT displayed", linkLink));
            AllureLogger.info(String.format("'%s' title-link is displayed - [%b]", linkLink, isDisplayed));
        }
        softAssert.assertAll();
    }

}
