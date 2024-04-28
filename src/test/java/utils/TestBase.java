package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeOptions;
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
}
