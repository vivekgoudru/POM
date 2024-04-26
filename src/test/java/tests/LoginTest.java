package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestBase;


public class LoginTest extends TestBase {


    @Test
    public void verifyLoginPage() {
        LoginPage login = new LoginPage(driver);
        login.verifyLoginPage();
    }
}
