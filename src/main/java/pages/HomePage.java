package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import swaglabbase.BaseTest;

public class HomePage extends BaseTest {


    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
    WebElement elementText;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addItem;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement clickOnCart;
    @FindBy(xpath = "//div[ text()='Sauce Labs Backpack']")
    WebElement discription;



    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public String addToCart(){
        String text = elementText.getText();
        addItem.click();
        return text;
    }
    public String ValidateThatProductIsInTheCard(){
        clickOnCart.click();
        return discription.getText();
    }






}
