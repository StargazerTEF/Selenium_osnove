package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import p02_10_2023.Helper;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://www.saucedemo.com/";
    protected JavascriptExecutor js;
    protected TablePage tablePage;
    protected UpdateDialogPage updateDialogPage;
    protected LoginPage loginPage;
    protected LeftNavPage leftNavPage;
    protected InventoryPage inventoryPage;
    protected TopNavPage topNavPage;
    protected DeleteDialogPage deleteDialogPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        tablePage = new TablePage(driver, wait);
        updateDialogPage = new UpdateDialogPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        leftNavPage = new LeftNavPage(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        topNavPage = new TopNavPage(driver, wait);
        deleteDialogPage = new DeleteDialogPage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        js.executeScript("window.localStorage.clear();");
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.takeScreenshotWithDateTimeFormat(driver, testResult.getName());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
