package p05_10_2023.Zadatak1;

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
import p02_10_2023.Helper;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com/iframe/K5yrx
//Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima.
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #2: Delete Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Delete dugme prvog reda
//Sacekati da dijalog za brisanje bude vidljiv
//Klik na Delete dugme iz dijaloga
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da je broj redova u tabeli za jedan manji
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//
//Test #3: Take a Screenshot
//Koraci:
//Ucitati stranu  /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Kreirati screenshot stranice.
//Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: screenshots/slike.png

    private WebDriver driver;
    private WebDriverWait wait;
    String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx";

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
        driver.navigate().to(baseUrl);
    }

    @Test(priority = 1)
    public void editRow() {

        String firstName = "Aki";
        String lastName = "Akic";
        String middleName = "Akica";

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Home page title should be 'Table with Edit and Update Data - Bootsnipp.com' ");

        driver.findElement(By.cssSelector("tr#d1 [data-target='#edit']")).click();

        wait
                .withMessage("Edit dialog is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#edit > div.modal-dialog > div > div.modal-header > h4")));

        driver.findElement(By.cssSelector("input#fn")).clear();
        driver.findElement(By.cssSelector("input#fn")).sendKeys(firstName);

        driver.findElement(By.cssSelector("input#ln")).clear();
        driver.findElement(By.cssSelector("input#ln")).sendKeys(lastName);

        driver.findElement(By.cssSelector("input#mn")).clear();
        driver.findElement(By.cssSelector("input#mn")).sendKeys(middleName);

        driver.findElement(By.cssSelector("button#up")).click();

        wait
                .withMessage("Edit dialog is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit > div.modal-dialog > div")));

        Assert.assertEquals(driver.findElement(By.cssSelector("td#f1")).getText(), firstName, "New First Name in first row doesn't match input value.");
        Assert.assertEquals(driver.findElement(By.cssSelector("td#l1")).getText(), lastName, "New Last Name in first row doesn't match input value.");
        Assert.assertEquals(driver.findElement(By.cssSelector("td#m1")).getText(), middleName, "New Middle Name in first row doesn't match input value.");

    }

    @Test(priority = 2)
    public void deleteRow () {

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Home page title should be 'Table with Edit and Update Data - Bootsnipp.com' ");

        driver.findElement(By.cssSelector("tr#d1 [data-target='#delete']")).click();

        wait
                .withMessage("Edit dialog is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#delete > div.modal-dialog > div > div.modal-header > h4")));

        List<WebElement> previousRows = driver.findElements(By.cssSelector("tbody > tr > td"));

        List<WebElement> numberOfCellsInEachRow = driver.findElements(By.cssSelector("#d1 > td"));

        driver.findElement(By.cssSelector("button#del")).click();

        wait
                .withMessage("Edit dialog is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#delete > div.modal-dialog > div > div.modal-header > h4")));

        List<WebElement> formerRows = driver.findElements(By.cssSelector("tbody > tr > td"));

        Assert.assertEquals(formerRows.size(), previousRows.size() - numberOfCellsInEachRow.size(), "Number of rows should be less by one");

    }

    @Test(priority = 3)
    public void takeScreenshot () throws IOException {

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Home page title should be 'Table with Edit and Update Data - Bootsnipp.com' ");

        Helper.takeScreenshot(driver, "screenshots/screenshottest1.png");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
