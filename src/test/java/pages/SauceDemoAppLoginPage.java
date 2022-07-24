package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class SauceDemoAppLoginPage {
    WebDriver driver;

    public SauceDemoAppLoginPage(){

        // setting up the driver
        // we need to initialise the driver to find elements and
        driver = Driver.getDriver();
        // new ( pageFactory.initElements) ->
        // we use this driver to initialise THIS page throu this method
        PageFactory.initElements(driver, this);

    }
    // new annotations (@FindBy) that goes before every webElement. it comes from Selenium
    @FindBy(id = "user-name")
    // we make it public every time to be able to acces it
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id="login-button")
    public WebElement loginBtn;
    // we are creating a method
    // login functionality will be used in every test case
    public void login(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        usernameInput.sendKeys(ConfigReader.getProperty("SauceDemoUserName"));
        passwordInput.sendKeys(ConfigReader.getProperty("SauceDemoPassword"));
        loginBtn.click();

    }


}
