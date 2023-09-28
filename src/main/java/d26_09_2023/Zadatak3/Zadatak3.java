package d26_09_2023.Zadatak3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zadatak3 {
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
//Nakon svakog unosa todo-a, unosi se enter
//Validira da li je novi todo dodat na stranici  (ispisati poruku)
//Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//Validirati da je na kraju programa broj todo-a na stranici 0. (ispisati poruku)
//Cekanje od 5s
//Zatvorite pretrazivac

        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Visit Paris", "Visit Prague", "Visit London", "Visit New York", "Visit Belgrade"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://example.cypress.io/todo");

        List<WebElement> previousToDo = driver.findElements(By.cssSelector(".todo-list>li"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < previousToDo.size(); i++) {
            actions.moveToElement(driver.findElement(By.cssSelector(".todo-list>li:nth-child(1)"))).build().perform();
            actions.moveToElement(driver.findElement(By.cssSelector(".todo-list>li:nth-child(1) button"))).click().build().perform();
      }

        for (int i = 0; i < cities.size(); i++) {
            driver.findElement(By.cssSelector(".new-todo")).sendKeys(cities.get(i));
            driver.findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTER);
            List<WebElement> addedRows = driver.findElements(By.cssSelector(".todo-list>li:nth-child(" + (i + 1) + ")"));
            if (!addedRows.isEmpty()) {
                System.out.println((i + 1) + ". is added");
            } else {
                System.out.println((i + 1) + ". is not added");
            }
            Thread.sleep(500);
        }

        for (int i = 0; i < cities.size(); i++) {
            actions.moveToElement(driver.findElement(By.cssSelector(".todo-list>li:nth-child(1)"))).build().perform();
            actions.moveToElement(driver.findElement(By.cssSelector(".todo-list>li:nth-child(1) button"))).click().build().perform();
            Thread.sleep(500);
        }

            List<WebElement> latterToDo = driver.findElements(By.cssSelector(".todo-list>li"));
            System.out.println("Number of to-do's left on the page is " + latterToDo.size());

        Thread.sleep(5000);

        driver.quit();
    }
}
