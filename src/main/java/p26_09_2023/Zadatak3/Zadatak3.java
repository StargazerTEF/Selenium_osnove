package p26_09_2023.Zadatak3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente iz tabele i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 5s
//Zatvara pretrazivac
//Stampa treba da bude kao u primeru:
//John	Doe	john@example.com
//Mary	Moe	mary@example.com
//July	Dooley	july@example.com
//HINT: bice vam lakse da radite ulancano trazenje. findElement().findELement()...

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

        List<WebElement> pages = driver.findElements(By.cssSelector("#lorem > table > tbody > tr > td"));

        for (int i = 0; i < pages.size(); i++) {
            if (i == 2 || i == 5) {
                System.out.println(pages.get(i).getText() + " | ");
            } else {
                System.out.print(pages.get(i).getText() + " | ");
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
