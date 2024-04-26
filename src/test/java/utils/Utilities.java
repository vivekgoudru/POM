package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {

    public void selectByValue(WebElement ele,String value){
        Select select = new Select(ele);
        select.selectByValue(value);
    }
}
