package tests;

import org.testng.annotations.Test;
import pages.CheckOutPage;
import utils.TestBase;

public class CheckOutTest extends TestBase {

    @Test
    public void verifyCheckOutPage(){
        CheckOutPage checkout=new CheckOutPage(driver);
        checkout.verifyCheckOutPage();
    }
}
