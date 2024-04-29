package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import static utils.TestBase.driver;
import static utils.TestBase.test;

public class Utilities {

    // Select a option from a dropdown using Select class [By Value]
    public void selectByValue(WebElement ele, String value) {
        Select select = new Select(ele);
        select.selectByValue(value);
    }

    //Read data from JSON file using Jackson binding

    public static String ReadTestData(String filepath, String key) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filepath);
            Map<String, String> testData = mapper.readValue(file, new TypeReference<Map<String, String>>() {
            });
            return testData.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Explicit wait

    public void waitForElement(WebElement ele){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }catch (Exception e){
            e.printStackTrace();
            test.fail("Failed to find the webElement "+ele);
        }
    }
}
