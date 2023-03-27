package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.w3c.dom.stylesheets.LinkStyle;
import swaglabbase.BaseTest;

import java.security.PublicKey;
import java.util.List;
import java.util.ListIterator;

public class RemoveItem extends BaseTest {
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement addToCart;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement clickOnCart;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    WebElement remove;
    @FindBy(xpath = "//div[@class='cart_item']")
    List<WebElement> showItem;
    public RemoveItem(){
        PageFactory.initElements(driver,this);
    }
    public void  setAddToCart(){
        addToCart.click();
        clickOnCart.click();
        remove.click();
    }
    public boolean showText(){
        if ( showItem.size()== 0)
            return true;
        else
            return false;
    }

}
