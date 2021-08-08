package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class BlogPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    public By getBlogTitleLocatorByName(String title) {
        String str = String.format("//a/span[text()='%s']", title);
        By blogTitle = By.xpath(str);
        return blogTitle;
    }

    public By getBlogTitleLocatorByLink(String link) {
        String str = String.format("//a[contains(@href,'%s')]/span", link);
        By blogTitle = By.xpath(str);
        return blogTitle;
    }
}
