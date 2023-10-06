package p03_10_2023.Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

import java.time.Duration;

public class Zadatak1 {
//Kreirati klasu KatalonLoginTests za testove
//Base url: https://cms.demo.katalon.com
//Test #1: Visit login page from Nav bar
//Koraci:
//Ucitati home stranicu
//Kliknuti na My account link
//Verifikovati da je naslov stranice My account – Katalon Shop
//Verifikovati da se u url-u stranice javlja /my-account
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Test #2: Check input types
//Koraci:
//Ucitati /my-account stranicu
//Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci informaciu da li je checkbox cekiran ili ne.
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Test #3: Display error when credentials are wrong
//Podaci:
//email: invalidemail@gmail.com
//password: invalid123
//Koraci:
//Ucitati home stranicu
//Kliknuti na My account link
//Unesite email
//Unesite password
//Kliknite na login dugme
//Verifikovati da postoji element koji prikazuje gresku
//Verifikovati da je prikazana greska ERROR: Invalid email address
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Verifikovati da smo idalje na login stranici posle greske, tako sto proveravamo da se url-u javlja /my-account
//Test #4: Successful login with valid credentials
//Podaci:
//username: customer
//password: crz7mrb.KNG3yxv1fbn
//Koraci:
//Ucitati home stranicu
//Kliknuti na My account link
//Unesite email
//Unesite password
//Kliknite na login dugme
//Verifikovati da se pojavljuje link za logout na stranici

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
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://cms.demo.katalon.com");
    }

    @Test (priority = 1)
    public void visitLoginPageFromNavBar() {
        driver
                .findElement(By.cssSelector("li.page-item-10 a")).click();

        wait
                .withMessage("Title is not 'My account – Katalon Shop'")
                .until(ExpectedConditions.titleIs("My account – Katalon Shop"));

        wait
                .withMessage("Url doesn't contain '/my-account'")
                .until(ExpectedConditions.urlContains("/my-account"));

    }

    @Test (priority = 2)
    public void checkInputTypes() {
        driver
                .findElement(By.cssSelector("li.page-item-10 a")).click();

        Assert.assertEquals(driver.findElement(By.id("username")).getAttribute("type"), "text", "Username field type is not 'text'");

        Assert.assertEquals(driver.findElement(By.id("password")).getAttribute("name"), "password", "Password field type is not 'password'");

        Assert.assertEquals(driver.findElement(By.id("rememberme")).getAttribute("type"), "checkbox", "Checkbox type of the field Remember me is not 'checkbox'");

        Assert.assertFalse(driver.findElement(By.id("rememberme")).isSelected(), "Rememberme should be unchecked by default");

    }

    @Test (priority = 3)
    public void displayErrorWhenCredentialsAreWrong() {

        String email = "invalidemail@gmail.com";
        String password = "invalid123";

        driver
                .findElement(By.cssSelector("li.page-item-10 a")).click();

        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("woocommerce-button")).click();

        wait
                .withMessage("Logout button is not present.")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#post-10 > div > div > div > ul > li")));

        String textOfErrorMessage = driver.findElement(By.cssSelector("#post-10 > div > div > div > ul > li")).getText();

        Assert.assertEquals(textOfErrorMessage, "ERROR: Invalid email address. Lost your password?", "Error message is not 'ERROR: Invalid email address'");


        wait
                .withMessage("Url doesn't contain '/my-account'")
                .until(ExpectedConditions.urlContains("/my-account"));
    }

    @Test (priority = 4)
    public void  successfulLoginWithValidCredentials () {

        String email = "customer";
        String password = "crz7mrb.KNG3yxv1fbn";

        driver
                .findElement(By.cssSelector("li.page-item-10 a")).click();

        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("woocommerce-button")).click();

        wait
                .withMessage("There is no logout on page.")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.entry-content li:nth-child(6) a")));

    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
