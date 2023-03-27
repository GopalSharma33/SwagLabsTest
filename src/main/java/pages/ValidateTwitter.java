package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import swaglabbase.BaseTest;

import java.util.Set;

public class ValidateTwitter extends BaseTest {
    @FindBy(xpath = "//a[text()='Twitter']")
    WebElement twitter;

    @FindBy(xpath = "//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'and text()='Follow']")
    WebElement checkLink;

    public ValidateTwitter(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnTwitter() throws InterruptedException {
       twitter.click();
    }
    public String   validateText() throws InterruptedException {
        String parentWindow = driver.getWindowHandle();
        Set<String > handles= driver.getWindowHandles();
        String twitter = null;
        for (String windowHandle:handles){
            if (!windowHandle.equals(parentWindow)){
                driver.switchTo().window(windowHandle);
                twitter=checkLink.getText();
                driver.close();
                driver.switchTo().window(parentWindow);
            }
        }
       return twitter;

    }
}
