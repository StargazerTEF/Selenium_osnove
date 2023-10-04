package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import p02_10_2023.Helper;
import p28_09_2023.Zadatak2.TestHelper;

import java.time.Duration;

public class UvodUTestng {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to("https://google.com");
    }

    @Test
    public void googleTitleTest() {
        Assert.assertTrue(driver.getTitle().contains("Google"), "Expected...");
        Assert.assertEquals(driver.getTitle(), "Google", "Home page title should be 'Google'");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/", "Url should be 'google.com'");

//        TestHelper testHelper = new TestHelper(driver);
//        boolean elementExists = testHelper.elementExists(By.name("dsgsgsds"));
//        Assert.assertFalse(elementExists);

        wait
                .withMessage("Number of elements is not 0.")
                .until(ExpectedConditions.numberOfElementsToBe(By.name("dsgsgsds"), 0));

        WebElement searchInput = driver.findElement(By.name("q"));

        searchInput.sendKeys("it bootcamp");
        searchInput.sendKeys(Keys.ENTER);

        wait
                .withMessage("Title doesn't contain 'it bootcamp'")
                .until(ExpectedConditions.titleContains("it bootcamp"));

    }

    @Test
    public void googleSearchTest() {
        driver
                .findElement(By.name("q"))
                .sendKeys("IT Bootcamp");
        driver.navigate().to("https://youtube.com");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
