package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import swaglabbase.BaseTest;

public class ItemsAreDisplayed extends BaseTest {
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement slect1;
    @FindBy(xpath = "//div[@id='inventory_container' and @class='inventory_container']")
    WebElement allElements;
    public ItemsAreDisplayed(){
        PageFactory.initElements(driver,this);
    }
    public void setElement(){
        Select select = new Select(slect1);
        select.selectByValue("lohi");
    }
    public boolean displayingElements(){
       return allElements.isDisplayed();
    }
}
