package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestBase;



public class HomePageTest extends TestBase {

    @Test
    public void verifyHomePage(){
        HomePage home = new HomePage(driver);
        home.addItemToCart();
    }
}
