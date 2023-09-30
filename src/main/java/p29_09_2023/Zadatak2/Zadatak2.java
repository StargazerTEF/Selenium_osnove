package p29_09_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji ucitava stranicu https://youtube.com i u search baru unosi tekt Breskvica i ceka da se
//pojavi vise od 3 rezultata iz padajuceg menija i zatim klikce na prvi.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://youtube.com");

        driver.findElement(By.cssSelector("input#search")).sendKeys("Breskvica");
        driver.findElement(By.cssSelector("input#search")).sendKeys(Keys.ENTER);

        wait
                .withMessage("Pretraga nije prikazala preporuke.")
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#contents > ytd-video-renderer"), 2));

        driver.findElement(By.cssSelector("#contents > ytd-video-renderer:nth-child(1)")).click();

        driver.quit();
    }
}
