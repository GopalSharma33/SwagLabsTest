package testNG;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import swaglabbase.BaseTest;

import java.io.IOException;
import java.lang.reflect.Method;

public class SampleTest extends BaseTest {
    LoginTest loginTest;
    HomePage homePage;
    AddToCard addToCard;
    ValidateManuButton validateManuButton;
    ValidateFaceBookPage validateFaceBookPage;
    ItemsAreDisplayed itemsAreDisplayed;
    ValidateAboutButton validateAboutButton;
    OrderPlace orderPlace;
    RemoveItem removeItem;
    ValidateTwitter validateTwitter;
    LogOut logOut;

    @BeforeMethod
    public void setCheckOut() throws IOException {
        loginTest=new LoginTest();
        loginTest.login();
        homePage=new HomePage();
        addToCard = new AddToCard();
        orderPlace = new OrderPlace();
        removeItem = new RemoveItem();
        validateManuButton = new ValidateManuButton();
        validateFaceBookPage = new ValidateFaceBookPage();
        itemsAreDisplayed = new ItemsAreDisplayed();
        validateAboutButton = new ValidateAboutButton();
        validateTwitter = new ValidateTwitter();
        logOut = new LogOut();
    }
    @Test(priority = 1)
    public void login(){
        String title = loginTest.getTitle();
        Assert.assertEquals(title,"Swag Labs");

    }
    @Test(priority = 2)
    public void addProductInTheCardAndValidateIt(){
        String text = homePage.addToCart();
        String discription= homePage.ValidateThatProductIsInTheCard();
        Assert.assertEquals(text,discription);
    }
    @Test(priority = 3)
    public void validateTheOrderIsPlacedOrNot() throws InterruptedException {
        addToCard.applyFilter();
        addToCard.addToItem();
        orderPlace.setCheckItem();
        orderPlace.clickOnContinue();
        String text=orderPlace.clickOnFinish();
        Assert.assertEquals(text,"Thank you for your order!");
        System.out.println(text+"Thank you for your order!");
    }
    @Test(priority = 4)
    public void removeItemTest() throws InterruptedException {
        removeItem.setAddToCart();
        removeItem.showText();
        Assert.assertEquals(removeItem.showText(),true);

    }
    @Test(priority = 5)
    public void validateManuItemsIsDisplayedOrNot() throws InterruptedException {
        Assert.assertTrue(validateManuButton.clickOnThreeDots());
        validateManuButton.clickOnCloseButton();
    }
    @Test(priority = 6)
    public void checkFaceBookPageTextVerifyOrNot() throws InterruptedException {
       validateFaceBookPage.clickOnFaceBook();
       String getText = validateFaceBookPage.getTextOfFaceBook();
        System.out.println(getText+"======");
       Assert.assertEquals(getText,"Photos");
    }
//    @Test(priority = 7)
//    public void itemsTest() throws InterruptedException {
//        itemsAreDisplayed.setElement();
//        Thread.sleep(5000);
//        Assert.assertTrue(itemsAreDisplayed.displayingElements());
//        Thread.sleep(5000);
//    }
    @Test(priority = 8)
    public void aboutTest() throws InterruptedException {
        validateAboutButton.clickOnThreeDotes();
        String text = validateAboutButton.clickOnAbout();
        Assert.assertEquals(text,"Resources");
    }
    @Test(priority = 9)
    public void validateTwitterTest() throws InterruptedException {
         validateTwitter.clickOnTwitter();
         Thread.sleep(5000);
         String text=validateTwitter.validateText();
        System.out.println(text+"Follow");
        Assert.assertEquals(text,"Follow");
    }
    @Test(priority = 10)
    public void logOutTest() throws InterruptedException {
        logOut.clickOnThreeDots();
        Thread.sleep(5000);
        String title=logOut.clickOnLogOut();
        Assert.assertEquals(title,"Swag Labs");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
