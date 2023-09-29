package d28_09_2023.Zadatak5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) {
//Ucitati stranicu http://seleniumdemo.com/?product=bdd-cucumber
//Klik na korpu iz gornjeg desnog ugla
//Sacekati da naslov stranice bude Cart – Selenium Demo Page
//Proveriti da li element koji prikazuje stanje korpe ima tekst Your cart is currently empty.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://seleniumdemo.com/?product=bdd-cucumber");

        Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.cssSelector(".icn-shoppingcart:nth-child(1)"))).build().perform();
            actions.moveToElement(driver.findElement(By.cssSelector(".icn-shoppingcart:nth-child(1)"))).click().build().perform();

        WebElement title = driver.findElement(By.cssSelector(".entry-title"));

        wait.until(ExpectedConditions.titleIs("Cart – Selenium Demo Page"));

        String x = driver.findElement(By.cssSelector(".cart-empty")).getText();

        if (x.equals("Your cart is currently empty.")) {
            System.out.println("Results match.");
        } else {
            System.out.println("Results don't match.");
        }
        driver.quit();
    }
}
