package p26_09_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 1s
//Hvata sve elemente prvog reda i stampa tekst svakog elementa
//Ceka 5s
//Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/z80en");


        for (int i = 1; i <= 3; i++) {
            System.out.println(driver.findElement(By.cssSelector("#lorem > table > tbody > tr:nth-child(" + i + ") > td:nth-child(1)")).getText());
        }

        Thread.sleep(1000);

        List<WebElement> pages = driver.findElements(By.cssSelector("#lorem > table > tbody > tr:nth-child(1) > td"));

        for (int i = 0; i < pages.size(); i++) {
            System.out.print(pages.get(i).getText() + " | ");
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
