package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.ProductDetailsPage;
import utils.BrowserFactory;
import utils.GenericMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static Properties prop = new Properties();

    WebDriver driver= null;
    HomePage homePage;
    ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void setUp(){
        driver = BrowserFactory.launchGivenBrowser("chrome");
        homePage = new HomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test(priority = 1)
    public void verifyIfTheApplicationLaunchSuccessfully(){
        Assert.assertTrue(homePage.verifyIfSearchBarIsAvailable());
    }

    @Test(priority = 2)
    public void verifyIfTheProductDisplayOnHomePage(){
        Assert.assertTrue(homePage.verifyIfProductIsAvailable());
    }

    @Test(priority = 3)
    public void verifyIfAddCartButtonIsAvailableOnProduct(){
        Assert.assertTrue(homePage.verifyAddToCartButtonShowsWithProduct());
    }

    @Test(priority = 4)
    public void verifyClickingOnProductRedirectsOnDetailPage(){
        homePage.clickOnProduct();
        GenericMethods.click(homePage.searchBar);
        Assert.assertTrue(productDetailsPage.verifyAddToCartButtonShowsWithProduct());

    }

    @Test(priority = 5)
    public void DemoTest(){
        System.out.println("test method");

    }

    
    @AfterClass
    public void tearDown(){
        driver.quit();
    }



    public BaseTest(){
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"testdata"+File.separator+"config.properties");
            prop.load(file);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e1) {
            e1.printStackTrace();
        }
    }

}
