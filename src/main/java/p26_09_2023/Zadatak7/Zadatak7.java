package p26_09_2023.Zadatak7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {
//Ucitati stranicu https://netoglasi.rs/
//Ispisati sve nazive kategorija iz leve navigacije
//Validirati da je kategorija Automobili na prvom mestu
//Klik na kategoriju Automobili
//Validarati da je kategorija Automobili izbacena iz liste.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://netoglasi.rs/");

        Thread.sleep(5000);

        List<WebElement> links = driver.findElements(By.cssSelector(".category-list:nth-child(2) ion-item:nth-child(1) > a"));

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
