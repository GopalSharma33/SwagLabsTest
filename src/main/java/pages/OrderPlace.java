package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import swaglabbase.BaseTest;

public class OrderPlace extends BaseTest {
    @FindBy(xpath = "//button[@name='checkout']")
    WebElement checkItem;
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id ="last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement code;
    @FindBy(xpath = "//input[@class='submit-button btn btn_primary cart_button btn_action']")
    WebElement continueButton;
    @FindBy(id = "finish")
    WebElement finish;
    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement getName;
    @FindBy(xpath = "//button[@name='back-to-products']")
    WebElement homepage;

    public OrderPlace(){
        PageFactory.initElements(driver,this);
    }
    public void setCheckItem(){
        checkItem.click();
        firstName.sendKeys("Gopal");
        lastName.sendKeys("Sharma");
        code.sendKeys("332030");
    }
    public void clickOnContinue() throws InterruptedException {
        continueButton.click();
        Thread.sleep(5000);
    }
    public String clickOnFinish() throws InterruptedException {
        finish.click();
        Thread.sleep(5000);
        String text=getName.getText();
        homepage.click();
        return text;

    }
}
