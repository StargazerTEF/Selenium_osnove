package p28_09_2023.Zadatak3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji ucitava stranicu Zadatak4.html
//Skinite Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom na fajl i Downloads-a i ikopirajte url. To je url za get u programu:
//I na stranici vrsi klik na Show in dugme
//Ceka da se pojavi itbootcamp poruka koristeci explicitni wait
//(za vezbanje)
//I na stranici dodaje 5 poruka “IT Bootcamp”
//Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//Sacekati da se novi element pojavi pre nego sto se doda sledeci

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:/Users/Marko/Downloads/Zadatak4.html");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement x = driver.findElement(By.id("showInBtn"));
        x.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));

        driver.findElement(By.id("showInBtn")).click();

        for (int i = 0; i < 5; i++) {
            WebElement y = driver.findElement(By.id("showInBtn"));
            y.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-" + (i + 2))));
        }
        driver.quit();
    }
}
