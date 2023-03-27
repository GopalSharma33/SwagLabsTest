package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import swaglabbase.BaseTest;

public class ValidateManuButton extends BaseTest {
     @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
     WebElement checkMenu;
    @FindBy(xpath = "//nav[@class='bm-item-list']")
    WebElement allitems;
    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    WebElement close;
    public ValidateManuButton(){
        PageFactory.initElements(driver,this);
    }
    public boolean clickOnThreeDots(){

        checkMenu.click();
       return allitems.isDisplayed();
    }
    public void clickOnCloseButton(){
        close.click();
    }
}
