package d28_09_2023.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
//Ucitati stranicu http://seleniumdemo.com/?post_type=product
//Klik na search dugme u gornjem desnom uglu
//Cekati da forma za pretragu bude vidljiva
//Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst koji je unet za pretragu.
//Ispisati odgovarajuce poruke u terminalu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://seleniumdemo.com/?post_type=product");

        driver.findElement(By.cssSelector(".topbar-nav__utils ul li:nth-child(1) a")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search__wrapper")));

        String searchInput = "BDD Cucumber";

        driver.findElement(By.id("s-651536d633c09")).sendKeys(searchInput);
        driver.findElement(By.id("s-651536d633c09")).sendKeys(Keys.ENTER);

        String text = driver.findElement(By.cssSelector(".czr-title")).getText();

        if (text.equals(searchInput)) {
            System.out.println("Results match.");
        } else {
            System.out.println("Results don't match.");
        }
        driver.quit();
    }
}
