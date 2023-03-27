package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import swaglabbase.BaseTest;

public class LogOut extends BaseTest {
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement button;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logOut;
    @FindBy(xpath = "//span[text()='Products' and @class='MuiTypography-root MuiTypography-buttonLabelNav css-1pj3is7']")
    WebElement product;
    public LogOut(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnThreeDots(){
        button.click();
    }
    public String clickOnLogOut() throws InterruptedException {
        logOut.click();
        return driver.getTitle();

    }


}
