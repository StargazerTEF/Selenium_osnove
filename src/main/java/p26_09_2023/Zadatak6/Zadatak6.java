package p26_09_2023.Zadatak6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
//Ucitati stranicu https://cms.demo.katalon.com/
//Maksimizovati prozor
//Proveriti da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli). Izguglajte na koji nacin se proverava
//da li je neki element vidljiv na stranici.
//Prostavite duzinu prozora na 700px i visinu na 700px
//Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://cms.demo.katalon.com/");

        if (driver.findElement(By.cssSelector("menu-toggle")).isDisplayed()) {
            System.out.println("Dugme je vidljivo.");
        } else {
            System.out.println("Dugme nije vidljivo.");
        }

        Dimension dimension = new Dimension(700, 700);
        driver.manage().window().setSize(dimension);

        if (driver.findElement(By.cssSelector("menu-toggle")).isDisplayed()) {
            System.out.println("Dugme je vidljivo.");
        } else {
            System.out.println("Dugme nije vidljivo.");
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
