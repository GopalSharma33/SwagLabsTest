package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import swaglabbase.BaseTest;
public class ValidateFaceBookPage extends BaseTest {
    @FindBy(xpath = "//a[@href='https://www.facebook.com/saucelabs']")
    WebElement faceBook;
    @FindBy(xpath = "(//span[text()='Photos'])[1]")
    WebElement faceBookText;

    public ValidateFaceBookPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnFaceBook(){
        faceBook.click();
    }
   public String getTextOfFaceBook(){
        return faceBookText.getText();
    }

}
