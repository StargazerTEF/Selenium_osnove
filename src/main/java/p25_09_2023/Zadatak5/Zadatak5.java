package p25_09_2023.Zadatak5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class Zadatak5 {
    public static void main(String[] args) {
//Napisati program koji ima:
//Niz stranica (niz stringova) koje treba da ucita. Niz je:
//https://google.com/
//https://youtube.com/
//https://www.ebay.com/
//https://www.kupujemprodajem.com/
//Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili navigate i od svake stranice na ekranu
//ispisuje naslov stranice. Kako od stranice procitati naslov imate na ovom linku
//U prevodu u konzoli treba da se ispisu:
//Google
//YouTube
//Electronics, Cars, Fashion, Collectibles & More | eBay
//KupujemProdajem
//Zatvara pretrazivac

        ArrayList<String> urls = new ArrayList<>(Arrays.asList("https://google.com/", "https://youtube.com/", "https://www.ebay.com/", "https://www.kupujemprodajem.com/"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        for (int i = 0; i < urls.size(); i++) {
            driver.get(urls.get(i));
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}
