package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TestBase {

    public static WebDriver driver;
    public ExtentSparkReporter spark = new ExtentSparkReporter("sparkReport.html");
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;

    @BeforeTest
    public void setUp() {
        extent.attachReporter(spark);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("no-sandbox");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        test = extent.createTest("Setting Up Browser")
                .log(Status.INFO, "Launched SauceDemo Application");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        test = extent.createTest("Closing the Browser")
                .log(Status.INFO, "Closing the Application");
        extent.flush();
    }

//    @DataProvider(name ="Json Parsing")
//    public static String[] ReadTestData(String filepath) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            File file = new File(filepath);
//            Map<String, String> testData = mapper.readValue(file, new TypeReference<Map<String, String>>() {
//            });
//            return testData.keySet().toArray(new String[0]);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    }

    @DataProvider(name = "Json_Parsing")
    public static Object[] readJson() {
        //object to sore the json data
        Object[] data = new Object[1];
        try {
            //parsing the files
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader("filepath"));
            JSONObject jsonObject = (JSONObject) obj;

            //Stores json data as key value pairs in HashMap

            HashMap<String, String> map = new LinkedHashMap<>();
            Set<String> jsonObjectKeys = jsonObject.keySet();
            for (String jsonKey : jsonObjectKeys) {
                map.put(jsonKey, (String) jsonObject.get(jsonKey));
            }

            data[0] = map;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
