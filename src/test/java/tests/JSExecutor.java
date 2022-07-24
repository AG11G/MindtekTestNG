//package tests;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class JSExecutor {
//
//    WebDriver driver;
//    String item = "web camera";
//
//    @BeforeMethod
//    public void setUp(){
//        //setting up our chromedriver
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }
//    // creating out test case
//    @Test(priority = 0)
//    public void searchTest(){
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item+ Keys.ENTER);
//        String searchItem = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
//   //   Assert.assertEquals(searchItem, "\""+ item + "\"");
//        Assert.assertEquals((searchItem.replaceAll("\"","")), item);
//    }
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//
//    }
//    @Test(priority = 1)
//    public void outOfStockCheckboxTest() {
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item + Keys.ENTER);
//// we create jse to be able to reach a certain point on the page ( search google for more info)
//        JavascriptExecutor jse = ((JavascriptExecutor) driver);
//        jse.executeScript("window.scrollBy(0,1200)");
//
//        driver.findElement(By.xpath("//li[@id='p_n_availability/2661601011']//i")).click();
//
//        jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
//    }
//
//    @Test(priority = 2)
//    public void jseTest(){
//   // We can access the website like this or      driver.get("https://www.amazon.com/");
//        JavascriptExecutor jse =((JavascriptExecutor) driver);
//        jse.executeScript("window.location='https://www.amazon.com/'");
//        WebElement customerServiceTab = driver.findElement(By.xpath("//a[contains(text(), 'Customer Service')]"));
//        jse.executeScript("arguments[0].click()",customerServiceTab);
//
//        Assert.assertEquals(driver.getTitle(), "Amazon Customer Service Support – Amazon.com");
//    }
//
////    @AfterMethod
////   // public void tearDown() throws InterruptedException {
////        Thread.sleep(3000);
////        driver.quit();
////    }
////}
