package p29_09_2023.Zadatak3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program implementira search test case za task-ove:
//Ucitati stranicu https://s.bootsnipp.com/iframe/8dqr
//Klik na filter dugme iz Tasks tabele
//Ceka da polje za input bude vidljivo. (Postaviti odgovarajuce poruke u slucaju greske)
//Za pretragu unosi tekst za koji nema rezultata pretrage npr: dsdsdsds
//Ceka da se pojavi No results found red i proverava ispisanu poruku da li je tekst “No results found”
//Za pretragu unosi sledeci tekst mi
//Validira da red No results found  vise ne postoji
//Validira rezultate pretrage 🔥
//Pravila pretrage:
//Red ce biti u rezultatu ukoliko bar jedna kolona tog reda sadrzi termin pretrage.
//Pretraga nije case sensitive, sto znaci da radi i za velika i mala slova.
//Ispisuje odgovarajuce poruke
//Klik na filter dugme
//Ceka da polje za pretragu postane nevidljivo. (Postaviti odgovarajuce poruke u slucaju greske)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://s.bootsnipp.com/iframe/8dqr");

        driver.findElement(By.cssSelector("body div div div:nth-child(2) div div.panel-heading div span i")).click();

        wait
                .withMessage("Input bar is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("task-table-filter")));

        driver.findElement(By.id("task-table-filter")).sendKeys("dsdsdsds");

        wait
                .withMessage("No results row is not present.")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".filterTable_no_results > td")));

        String x = driver.findElement(By.cssSelector(".filterTable_no_results > td")).getText();

        if (x.equals("No results found")) {
            System.out.println("Text matches.");
        } else {
            System.out.println("Text doesn't match.");
        }

        List<WebElement> oldRows = driver.findElements(By.cssSelector("#task-table > tbody > tr"));

        String searchInput = "mI";

        driver.findElement(By.id("task-table-filter")).clear();
        driver.findElement(By.id("task-table-filter")).sendKeys(searchInput);

        List<WebElement> newRows = driver.findElements(By.cssSelector("#task-table > tbody > tr"));

        if (oldRows.size() != newRows.size()) {

            wait
                    .withMessage("No results row is still present.")
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".filterTable_no_results > td")));

        }

                for (int i = 0; i < newRows.size(); i++) {
                    if (newRows.get(i).getText().toLowerCase().contains(searchInput.toLowerCase())) {
                        System.out.println((i + 1) + ". row contains search input.");
                    }
                }

                driver.findElement(By.cssSelector("body div div div:nth-child(2) div div.panel-heading div span i")).click();

                wait
                        .withMessage("Search bar is still visible.")
                        .until(ExpectedConditions.invisibilityOfElementLocated(By.id("task-table-filter")));

                driver.quit();
    }
}
