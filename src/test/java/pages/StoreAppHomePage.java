package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class StoreAppHomePage {
    // we declare the web driver
    WebDriver driver;
    // we create constructor
    public  StoreAppHomePage(){
        driver = Driver.getDriver();
        // we initialise driver
        // we initialise the elements from This Page
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
        public WebElement signInButton;

    }

