package swaglabbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest logger;
    @BeforeTest
    public void createReportFile(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator+"fileReports"+File.separator+"AutomationReport.html");
        htmlReporter.config().setEncoding("uft-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Result");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester","Gopal Sharma");
    }
    @BeforeMethod
    public void lounchBrowser(Method testMethod) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\vinayak\\eclipse-workspace\\untitled4\\src\\main\\java\\configswaglab\\properties");
        properties.load(fileInputStream);

        String url=properties.getProperty("url");
        System.out.println(url);

        String browser=properties.getProperty("Browser");
        System.out.println(browser);

        System.setProperty("webdriver.chrome.driver","C:\\Users\\vinayak\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        logger = extent.createTest(testMethod.getName());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void printResult(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: "+ methodName + "Pass";
            Markup n = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,n);

        }
        else if(result.getStatus()==ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: "+ methodName + "Fail";
            Markup n = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,n);
        }
    }
    @AfterTest
    public void closeReport(){
        extent.flush();
    }


}
