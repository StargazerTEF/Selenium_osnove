package p29_09_2023.Zadatak7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji:
//Ucitava stranicu https://tus.io/demo.html
//Hvata sve linkove sa stranice
//Skrola do svakog h3 elementa
//Od svakog h3 elementa cita text

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");

        List<WebElement> links = driver.findElements(By.tagName("link"));

        List<WebElement> h3 = driver.findElements(By.tagName("h3"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < h3.size(); i++) {
                js.executeScript("arguments[0].scrollIntoView();", h3.get(i));
                System.out.println(h3.get(i).getText());
                Thread.sleep(1000);
        }
        driver.quit();
    }
}
