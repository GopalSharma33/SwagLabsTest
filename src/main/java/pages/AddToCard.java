package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import swaglabbase.BaseTest;

public class AddToCard extends BaseTest {
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement select;
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    WebElement itemName;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement bag;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement clickOnCart;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement itemNameInCart;

    public AddToCard(){
        PageFactory.initElements(driver,this);
    }
    public void applyFilter() throws InterruptedException {
        Select select1 = new Select(select);
        select1.selectByValue("za");
        Thread.sleep(3000);
    }

    public void addToItem(){
        bag.click();
        clickOnCart.click();
    }

}
