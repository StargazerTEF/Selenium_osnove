package d25_09_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter. Koristan link
//Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//Cekanje od 5s
//Zatvorite pretrazivac

        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Visit Paris", "Visit Prague", "Visit London", "Visit New York", "Visit Belgrade"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://example.cypress.io/todo");
        
        for (int i = 0; i < cities.size(); i++) {
            driver.findElement(By.cssSelector(".new-todo")).sendKeys(cities.get(i));
            driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
        }

        for (int i = 0; i < cities.size(); i++) {
            driver.findElement(By.cssSelector(".todo-list > li:nth-child(" + (i + 3) + ") > div > input")).click();
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
