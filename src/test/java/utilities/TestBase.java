package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class TestBase {

  protected WebDriver driver;
  // will run before each test method
    // we use it to set up
    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp() {

        driver = Driver.getDriver();
}

    /**
     *  will run after each test method
     *  we name this method tearDown
     *  quit this driver so we can use a different driver next time
     *  each test case needs to Open Test and Close the browser
     */
    @AfterMethod(groups = {"regression", "smoke"})
    public void tearDown(){

        driver.quit();
    }
}
