package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericMethods;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='option-label-size-143-item-166']")
    WebElement sizeOfTshirt;
    @FindBy(xpath = "//div[@id='option-label-color-93-item-52']")
    WebElement sizeForProduct;
    @FindBy(xpath = "//span[normalize-space()='Add to Cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "(//div[@class='page messages']//div[contains(.,'You added')])[1]")
    WebElement productAddedSuccessfully;


    public boolean verifyAddToCartButtonShowsWithProduct(){
        return addToCartButton.isDisplayed();
    }

    public void clickOnCartButton(){
         addToCartButton.click();
    }





}
