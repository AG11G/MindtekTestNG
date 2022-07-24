package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyHomePage {
    // we need to create a constructor first

    public EtsyHomePage(){
        WebDriver driver = Driver.getDriver();
        // get all the web elements
        PageFactory.initElements(driver,this);
    }
    // elements on searchBox
    // we use anptation @FINDby
    @FindBy(id = "global-enhancements-search-query")
    // we find the searchBox by id
    public WebElement searchBox;
}


///// This is Page Object Model Design Pattern or POM (Pom design pattern)
///// this is where i keep my webelements in separate classes and for each page i have separate page class

///// pom.xml it stores the dependancies the information about