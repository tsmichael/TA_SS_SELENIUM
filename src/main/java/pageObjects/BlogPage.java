package pageObjects;

import org.openqa.selenium.By;

public class BlogPage extends AbstractPage {

    public By getBlogTitleLocatorByName(String title) {
        String str = String.format("//a/span[text()='%s']", title);
        By blogTitle = By.xpath(str);
        return blogTitle;
    }
}
