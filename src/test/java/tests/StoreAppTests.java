package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StoreAppAccountPage;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class StoreAppTests extends TestBase {

    String email;
    String password;
    String firstName;
    String lastName;
    String address;
    String city;

    @DataProvider(name = "signUpTestData")
    public static Object[][] testData(){
        return new Object[][]{
                {"Create", "Account", "112Pass", "1" , "6" , "1990" ,"123 Buffalo Dr","Chicago","13","12345","123456","MyAlias"}
//                {"Create1", "Account1", "112Pass1", "2","7","1990","123 Buffalo Dr","Chicago","13","12345","123456","MyAlias"},
//                {"Create2", "Account2", "112233B", "3","8","1990","123 Buffalo Dr","Chicago","13","12345","123456","MyAlias"},
        };
    }

    @Test(groups = {"regression","smoke"}, dataProvider = "signUpTestData")
    public void createAccountTest(
            String firstName,
            String lastName,
            String password,
            String day,
            String month,
            String year,
            String address,
            String city,
            String state,
            String postCode,
            String phoneNumber,
            String alias
    ){
        StoreAppHomePage homePage = new StoreAppHomePage();
        StoreAppLoginPage loginPage = new StoreAppLoginPage();
        StoreAppCreateAccountPage createAccountPage = new StoreAppCreateAccountPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        homePage.signInButton.click();
        email = BrowserUtils.getRandomEmail();
        loginPage.createEmailInput.sendKeys(email);
        loginPage.createAccountButton.click();

        this.firstName = firstName;
        createAccountPage.firstNameInput.sendKeys(firstName);
        this.lastName = lastName;
        createAccountPage.lastNameInput.sendKeys(lastName);
        this.password = password;
        createAccountPage.passwordInput.sendKeys(password);

        BrowserUtils.selectDropdownByValue(createAccountPage.daysDropdown, day);
        BrowserUtils.selectDropdownByValue(createAccountPage.monthsDropdown, month);
        BrowserUtils.selectDropdownByValue(createAccountPage.yearsDropdown, year);

        this.address = address;
        createAccountPage.addressInput.sendKeys(address);
        this.city = city;
        createAccountPage.addressInput.sendKeys(city);

        // this is an web element and we need to provide it into an select object
//        Select daysSelect = new Select(createAccountPage.daysDropdown);
//        Select monthSelect = new Select(createAccountPage.monthsDropdown);
//        Select yearSelect = new Select(createAccountPage.yearsDropdown);
//
//        daysSelect.selectByValue(day);
//        monthSelect.selectByValue(month);
//        yearSelect.selectByValue(year);

        /**
         * hard assert it stops the running if theres a mistake
         * soft assert lets you run all methods even tho theres mistakes
         */

        createAccountPage.addressInput.sendKeys(address);
        createAccountPage.cityInput.sendKeys(city);

        BrowserUtils.selectDropdownByValue(createAccountPage.stateDropdown,state);

//        Select citySelect = new Select(createAccountPage.stateDropdown);
//        citySelect.selectByValue(state);

        createAccountPage.postcodeInput.sendKeys(postCode);
        createAccountPage.phoneMobilInput.sendKeys(phoneNumber);
        createAccountPage.aliasInput.sendKeys(alias);
        createAccountPage.submitButton.click();



    }
    @Test(groups = {"regression"}, dependsOnMethods = "createAccountTest")
    public void signInTest(){
        StoreAppHomePage homePage = new StoreAppHomePage();
        StoreAppLoginPage loginPage = new StoreAppLoginPage();
        StoreAppAccountPage accountPage = new StoreAppAccountPage();
        SoftAssert softAssert = new SoftAssert();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        homePage.signInButton.click();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInBtn.click();
        // we need to assert it by tittle
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();
        /**
         *         SoftAssert
         *  // if we have more than 2 to Assert we use SoftAssert
         *  // in order to use it we need to create an object
         */
        accountPage.myAddress.click();

        softAssert.assertEquals(actualTitle,expectedTitle);
        softAssert.assertEquals(accountPage.firstName.getText(), firstName);
        softAssert.assertEquals(accountPage.lastName.getText(),lastName);
//        softAssert.assertEquals(accountPage.address.getText(),address);
//        softAssert.assertEquals(accountPage.city.getText(),city);

        softAssert.assertAll();


    }


}
