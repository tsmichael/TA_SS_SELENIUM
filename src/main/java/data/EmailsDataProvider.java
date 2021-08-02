package data;

import org.testng.annotations.DataProvider;

public class EmailsDataProvider {

    @DataProvider(name = "incorrectEmailsProvider")
    public static Object[][] getInvalidEmailsFromDataProvider() {
        return new Object[][]{
                {"username.com"},
                {"@gmail.com"},
                {"username@gmail"},
                {"user.name@gmail"}
        };
    }

    @DataProvider(name = "validByBVAEmailsProvider")
    public static Object[][] getValidByBVAEmailsFromDataProvider() {
        return new Object[][]{
                {"mykhailotsalan@gmail.ua"},
                {"mykhailotsalan@gmail.com"},
                {"mykhailotsalan@gmail.comcomcom"},
                {"mykhailotsalan@gmail.strawberry"},
                {"ananasananasananasananasananasananasananasananasananasananasana@gmail.ua"},
                {"ananasananasananasananasananasananasananasananasananasananasanas@gmail.ua"}
        };
    }
}

