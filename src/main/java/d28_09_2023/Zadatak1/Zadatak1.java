package d28_09_2023.Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
//        Napisati program koji ucitava stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//Klik na Type drawdown
//Klik na Public iz drowdowna
//Ceka da se Clear dugme u desnom uglu prikaze koristeci explicit wait
//Kilk na Clear filter u desnom uglu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("type-options")).click();
        driver.findElement(By.cssSelector(".SelectMenu-item:nth-child(2) span")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".issues-reset-query")));
        driver.findElement(By.cssSelector(".issues-reset-query svg path")).click();

        driver.quit();
    }
}
