package p28_09_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
//Kreirati klasu TestHelper koja ima:
//privatan atribut driver
//kontukstor sa parametrom
//metodu elementExists koja vraca true ili false ako element postoji. Metoda kao parametar prima nacin trazenja By objekat.
//Metoda radi proveru preko TryCatch-a
//metodu elementExistsByList koja takodje vraca true ili false. Metoda kao parametar prima By objekat za trazenje.
//metodu setDefaultImplicitWait koja postavlja implicino cekanje na 10s.
//metodu setImplicitWait koja postavlja implicitno cekanje iz prosledjene vrednosti.
//U glavnom programu resiti prvi zadatak koriseci objekat klase TestHelper za proveru elemenata i za postavljanje implicitnog cekanja.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/modal-dialogs");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        TestHelper helper = new TestHelper(driver);
        helper.setDefaultImplicitWait();

        driver.findElement(By.id("showLargeModal")).click();

        boolean x = helper.elementExists(By.cssSelector(".modal-content"));

        if (x) {
            System.out.println("Large modal is present and visible.");
        } else {
            System.out.println("Large modal is not present and visible.");
        }
        driver.quit();
    }
}
