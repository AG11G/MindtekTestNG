package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BrowserUtils {

    /**
     * this method generates random emails
     * Ex:
     * .getRandom(); --> returns "userEmail12345
     */

    public static String getRandomEmail() {
        String email = "userEmail";
        // thats how we create a random object
        Random random = new Random();
        int number = random.nextInt(99_999);
        return email + number + "@gmail.com";
    }

    /**
     * This method will accept WebElement of dropdown
     * and String value of dropdown, and will select provided value in dropdown
     */
    public static void selectDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);

    }

    /**
     * This method waits for element to be clickable
     * Ex:
     * .waitForElementToBeClickable(element,10) -> returns the element
     */

    public static WebElement waitForElementToBeClickable(WebElement element, int seconds) {
        // the first parameter is the Driver and the second parameter is seconds
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        return element1;
    }

    /**
     * Explicititly wait
     * This method waits for element to be visible
     * Ex:
     * .waitForElementToBeVisible(element,10) -> returns the element
     */
    public static WebElement waitForElementToBeVisible(WebElement element, int seconds) {
        // the first parameter is the Driver and the second parameter is seconds
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
        // we are applying explicetly wait
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        return element1;
    }

    /**
     * This method takes screenshots
     * void --> because we do not return anyting , we only taking screenshots
     *
     * Ex:
     *     .takeScreenshot("SauceDemoApp test")
     */
    public static void takeScreenshot(String testName) throws IOException {
        // we need to get our driver to get that screenshot
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // we need to create a path to directory that we created (screenshots)
        // when we take a screenshot it assignes a name every time we take it so we need to add the name
        // dont forget to put / after sreenshots. we use it whenever we move to another directory
        String path = "src/test/resources/screenshots/" +testName+".png";
        // we are creating the file for that screenshot to save the path for the .png
        File file = new File(path);
        FileUtils.copyFile(screenshot, file);
    }

}