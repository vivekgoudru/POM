package tests;

import org.testng.annotations.CustomAttribute;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestBase;


public class LoginTest extends TestBase {

    @Test
    public void verifyLoginPage() {
        try {
            LoginPage login = new LoginPage(driver);
            login.verifyLoginPage();
        }catch (Exception e){
            e.printStackTrace();
            test.fail("User failed to login to the application");
        }
    }
}