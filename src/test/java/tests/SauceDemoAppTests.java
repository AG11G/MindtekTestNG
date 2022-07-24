package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoAppCheckoutPage;
import pages.SauceDemoAppHomePage;
import pages.SauceDemoAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

import java.io.IOException;
import java.util.List;

public class SauceDemoAppTests extends TestBase {

    @Test(groups = {"regression","smoke", "healthcheck"})
    public void verifyLoginPositive(){
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        // after deleting the locaters we need to create an object to be able to acces
        SauceDemoAppLoginPage sdaLoginPage = new SauceDemoAppLoginPage();
        sdaLoginPage.login();

        // Storing into a web element
        WebElement titleProducts = driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));
        Assert.assertTrue(titleProducts.isDisplayed());
    }

    @Test (priority=1,groups = {"smoke","regression"})
    public void verifyPriceHighToLow() throws IOException {

        SauceDemoAppLoginPage sdaLoginPage = new SauceDemoAppLoginPage();
        sdaLoginPage.login();

        BrowserUtils.takeScreenshot("SauceDemoApp-Login");

        Select filterDropdown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        filterDropdown.selectByIndex(3);
        List<WebElement> itemPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        for(int i=1; i<itemPrices.size(); i++){
         double itemPrice1 = Double.parseDouble(itemPrices.get(i-1).getText().substring(1));
         double itemPrice2 = Double.parseDouble(itemPrices.get(i).getText().substring(1));
         System.out.println(itemPrice1+" is greater than "+ itemPrice2);
         Assert.assertTrue((itemPrice1>=itemPrice2));
        }

    }
    @Test(priority =2,groups = {"smoke", "regression", "total" })
    public void verifyTotalPrice(){

        SauceDemoAppLoginPage sdaLoginPage = new SauceDemoAppLoginPage();
        sdaLoginPage.login();

        SauceDemoAppHomePage sdaHomePage = new SauceDemoAppHomePage();
        sdaHomePage.backpackCartBtn.click();
        sdaHomePage.bikeLightCartBtn.click();
        sdaHomePage.cartBtn.click();
        sdaHomePage.checkoutBtn.click();

        SauceDemoAppCheckoutPage sdaCheckoutPage = new SauceDemoAppCheckoutPage();
        sdaCheckoutPage.checkoutWithValidInfo();


        double expectedSubtotal = 0.0;

        for( int i=0; i<sdaCheckoutPage.itemPrices.size()-1; i++){
            double price1 = Double.parseDouble(sdaCheckoutPage.itemPrices.get(i).getText().substring(1));
            double price2 = Double.parseDouble(sdaCheckoutPage.itemPrices.get(i+1).getText().substring(1));
            expectedSubtotal = price1 + price2;

        }
        String subtotalText = sdaCheckoutPage.subtotal.getText();
        double actualSubtotal = Double.parseDouble(subtotalText.substring(subtotalText.indexOf("$")+1));

        Assert.assertEquals(actualSubtotal,expectedSubtotal);
    }

}
