package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utilities;

import static utils.TestBase.extent;
import static utils.TestBase.test;

public class HomePage extends Utilities {
    WebDriver driver;
    public HomePage(WebDriver driver){
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement filterIcon;
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement backPackAddToCart;
    @FindBy(id="shopping_cart_container")
    private WebElement cart;
    @FindBy(id="checkout")
    private WebElement checkOut;

    public void addItemToCart(){
        try {
            test = extent.createTest("Home Page");
            selectByValue(filterIcon, "hilo");
            backPackAddToCart.click();
            cart.click();
            test.pass("Added the backpack to the cart");
            checkOut.click();
        }catch (Exception e){
            e.printStackTrace();
            test.fail("Failed to add item to the cart");
        }
    }
}
