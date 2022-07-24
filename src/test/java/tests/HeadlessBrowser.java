package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HeadlessBrowser {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        //We are making it headless. We created an instance of a class
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("disable-popup-blocking");
        options.addArguments("-incognito");

        driver = new ChromeDriver(options);

        // we maximize the window to be able to see all elements
        driver.manage().window().maximize();
        // we manage our timeouts
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");
    }
    // We begin to write our actual test case
    @Test
    public void amazonHomePageVerification(){
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        Assert.assertEquals(driver.getTitle(),expectedTitle);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
