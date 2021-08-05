package pageObjects.businessObjects;

import constants.BlogNavElements;
import org.testng.asserts.SoftAssert;
import pageObjects.BlogPage;

public class BlogBO extends BlogPage {

    private BlogPage blogPage;

    public BlogBO() {
        blogPage = new BlogPage();
    }

    public void verifyAllBlogLinksIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        for (BlogNavElements link : BlogNavElements.values()) {
            softAssert.assertTrue(isDisplayed(blogPage.getBlogTitleLocatorByName(link.toString())),String.format("'%s' title is NOT displayed",link));
        }
        softAssert.assertAll();
    }

}
