package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenericMethods;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBar;
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement showCartButton;
    @FindBy(xpath = "//span[normalize-space()='Women']")
    WebElement womenMenuItem;
    @FindBy(xpath = "//a[normalize-space()='Argus All-Weather Tank']")
    WebElement hotSellersProduct;

    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[3]")
    WebElement addToCartButton;


    public boolean verifyIfSearchBarIsAvailable(){
        return searchBar.isDisplayed();
    }

    public void enterTextInSearch(String text){
        searchBar.sendKeys(text);
    }

    public boolean verifyIfProductIsAvailable(){
        return hotSellersProduct.isDisplayed();
    }

    public void clickOnProduct() {
        hotSellersProduct.click();
    }

    public boolean verifyAddToCartButtonShowsWithProduct(){
        Actions action = new Actions(driver);
        action.moveToElement(hotSellersProduct).build().perform();
        GenericMethods.pauseExecutionFor(1);
        return addToCartButton.isDisplayed();
    }



}
