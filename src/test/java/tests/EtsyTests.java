package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.EtsyHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class EtsyTests  extends TestBase {

    @Test
    public void testEtsy(){
        driver.get(ConfigReader.getProperty("EtsyURL"));
        // we need to create an object out of home page
        EtsyHomePage etsyHomePage=new EtsyHomePage();
        // Keys.ENTER it will press Enter
        etsyHomePage.searchBox.sendKeys("Carpet" + Keys.ENTER);

    }
}
