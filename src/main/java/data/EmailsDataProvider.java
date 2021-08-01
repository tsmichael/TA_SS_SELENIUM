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
}

