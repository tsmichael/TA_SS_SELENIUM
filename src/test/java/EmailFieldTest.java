import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;

public class EmailFieldTest extends BaseTest {

    @Test
    @Parameters({"emailWithoutAt"})
    public void verifyContinueButtonIsDisabledWithEmailWithoutAtSymbol(String emailWithoutAt) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(emailWithoutAt);
        new SignInBO()
                .verifyAtSymbolNotPresentInEmail();
        new SignInBO()
                .verifyContinueButtonIsDisabled();
    }

    @Test
    @Parameters({"emailWithAtAtStart"})
    public void verifyContinueButtonIsDisabledWithEmailAtSymbolAtStart(String emailWithAtAtStart) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(emailWithAtAtStart);
        new SignInBO()
                .verifyAtSymbolAtStartInEmail();
        new SignInBO()
                .verifyContinueButtonIsDisabled();
    }


    @Test
    @Parameters({"emailWithoutDot"})
    public void verifyContinueButtonIsDisabledWithEmailWithoutDot(String emailWithoutDot) {
        new HomeBO()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(emailWithoutDot);
        new SignInBO()
                .verifyDotSymbolNotPresentInEmail();
        new SignInBO()
                .verifyContinueButtonIsDisabled();
    }
}
