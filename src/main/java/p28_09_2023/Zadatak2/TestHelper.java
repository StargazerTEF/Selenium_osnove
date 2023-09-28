package p28_09_2023.Zadatak2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class TestHelper {
//Kreirati klasu TestHelper koja ima:
//privatan atribut driver
//kontukstor sa parametrom
//metodu elementExists koja vraca true ili false ako element postoji. Metoda kao parametar prima nacin trazenja By objekat.
//Metoda radi proveru preko TryCatch-a
//metodu elementExistsByList koja takodje vraca true ili false. Metoda kao parametar prima By objekat za trazenje.
//metodu setDefaultImplicitWait koja postavlja implicino cekanje na 10s.
//metodu setImplicitWait koja postavlja implicitno cekanje iz prosledjene vrednosti.
//
//U glavnom programu resiti prvi zadatak koriseci objekat klase TestHelper za proveru elemenata i za postavljanje implicitnog cekanja.

    private WebDriver driver;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean elementExists (By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean elementExistsByList (By by) {
        return !driver.findElements(by).isEmpty();
    }
    public void setDefaultImplicitWait () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void setImplicitWait (int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
