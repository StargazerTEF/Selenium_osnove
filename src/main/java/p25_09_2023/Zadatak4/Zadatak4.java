package p25_09_2023.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji:
//Maksimizuje stranicu
//Ucitava stranicu https://demoqa.com/webtables
//Vrsi klik na edit dugme prvog reda
//Unosi informacije za sva polja u edit formi
//Klik na submit
//Ceka par sekundi
//Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.cssSelector(".mr-2 > svg > path")).click();
        driver.findElement(By.cssSelector("#firstName")).clear();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Pera");
        driver.findElement(By.cssSelector("#lastName")).clear();
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Peric");
        driver.findElement(By.cssSelector("#userEmail")).clear();
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("pera@gmail.com");
        driver.findElement(By.cssSelector("#age")).clear();
        driver.findElement(By.cssSelector("#age")).sendKeys("38");
        driver.findElement(By.cssSelector("#salary")).clear();
        driver.findElement(By.cssSelector("#salary")).sendKeys("80 000");
        driver.findElement(By.cssSelector("#department")).clear();
        driver.findElement(By.cssSelector("#department")).sendKeys("IT");
        driver.findElement(By.cssSelector("#submit")).click();

        Thread.sleep(5000);

        driver.quit();

    }
}
