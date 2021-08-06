package data;

import org.testng.annotations.DataProvider;

public class EmailsDataProvider {

    @DataProvider(name = "incorrectEmailsProvider")
    public static Object[][] getInvalidEmailsFromDataProvider() {
        return new Object[][]{
                {"email without '@'", "username.com"},
                {"email with '@' at beginning", "@gmail.com"},
                {"email without '.' in domain ", "username@gmail"},
                {"email without '.' in domain", "user.name@gmail"},
                {"one symbol in top-level domain", "user.name@gmail.c"},
                {"11 symbols in top-level domain", "user.name@gmail.comcomcomco"}
        };
    }

    @DataProvider(name = "validByBVAEmailsProvider")
    public static Object[][] getValidByBVAEmailsFromDataProvider() {
        return new Object[][]{
                {"2 symbols in top-level domain", "mykhailotsalan@gmail.ua"},
                {"3 symbols in top-level domain", "mykhailotsalan@gmail.com"},
                {"9 symbols in top-level domain", "mykhailotsalan@gmail.comcomcom"},
                {"10 symbols in top-level domain", "mykhailotsalan@gmail.strawberry"},
                {"recipient name with 63 symbols", "ananasananasananasananasananasananasananasananasananasananasana@gmail.ua"},
                {"recipient name with 64 symbols", "ananasananasananasananasananasananasananasananasananasananasanas@gmail.ua"}
        };
    }
}

