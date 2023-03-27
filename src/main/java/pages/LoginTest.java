package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import swaglabbase.BaseTest;

public  class LoginTest extends BaseTest {

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement login;

    public LoginTest(){
        PageFactory.initElements(driver,this);
    }

    public String  getTitle(){
        return driver.getTitle();
    }
    public void login(){
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
    }

}
