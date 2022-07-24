//package tests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
//
//public class Waits {
//
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//
//    }
////    @Test
////    public void expWait(){
////        WebElement addRemoveBtn = driver.findElement(By.xpath("//form[@id='checkbox-example']//button"));
////        WebElement checkboxBtn = driver.findElement(By.xpath("//div[@id='checkbox']//input"));
////
////        checkboxBtn.click();
////        addRemoveBtn.click();
////
////        WebDriverWait explicitlyWait = new WebDriverWait(driver,10);
////
////        String expectedMessage = explicitlyWait.until(ExpectedCondition
////
////        Assert.assertEquals(expectedMessage,"It's gone!");
//
//    }
//    @Test
//    public void fluWait(){
//        WebElement enableBtn = driver.findElement(By.xpath("//form[@id='input-example']/button"));
//        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
//                .withTimeout(20, TimeUnit.SECONDS
//                        .pollingEvery(5,TimeUnit.SECONDS)
//                        .ignoring(NoSuchElementException.class));
//
//        WebElement element =
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
// //       driver.quit();
//    }
//}
