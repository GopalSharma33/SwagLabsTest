package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import swaglabbase.BaseTest;

public class ValidateAboutButton extends BaseTest {
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement checkMenu;
//    @FindBy(xpath = "//a[@id='about_sidebar_link']")
//    WebElement checkAbout;
    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    WebElement closee;
    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    WebElement clickOnAbout;
    @FindBy(xpath = "//span[text()='Resources' and @class='MuiTypography-root MuiTypography-buttonLabelNav css-1pj3is7']")
    WebElement resources;
    public ValidateAboutButton(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnThreeDotes(){
        checkMenu.click();
    }
    public String  clickOnAbout() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='about_sidebar_link']")).click();
//        clickOnAbout.click();
        return resources.getText();
    }
}

