package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static utils.TestBase.extent;
import static utils.TestBase.test;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement logo;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void verifyLoginPage() {
        try {
            String actualTitle = logo.getText();
            Assert.assertEquals(actualTitle, "Swag Labs");
            userName.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            loginButton.click();
            Thread.sleep(6000);
            extent.createTest("Login Page")
                    .log(Status.PASS, "User logged into Sauce Lab application");
        } catch (Exception e) {
            e.printStackTrace();
            test.fail("Failed to login to the Application");
        }
    }
}
