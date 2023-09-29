package d28_09_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik na svako dugme od PRIMARY do DARK
//Sacekati da se toasts u desnom gornjem uglu pojavi
//Pauza izmedju klikova 1s
//Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        List<WebElement> buttons = driver.findElements(By.cssSelector("#section-basic-example section.pb-4 div section div button"));

        for (int i = 0; i < buttons.size(); i++) {
            driver.findElement(By.cssSelector("#section-basic-example section.pb-4 div section div button:nth-child(" + (i + 1) + ")")).click();
            if (i == 0) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-primary")));
            } else if (i == 1) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-secondary")));
            } else if (i == 2) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-success")));
            } else if (i == 3) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-danger")));
            } else if (i == 4) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-warning")));
            } else if (i == 5) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-info")));
            } else if (i == 6) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-light")));
            } else if (i == 7) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header.toast-dark")));
            }
            Thread.sleep(1000);
        }
        driver.quit();
    }
}
