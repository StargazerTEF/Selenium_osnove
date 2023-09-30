package p29_09_2023.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
//Napisati program koji
//ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik Primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Ceka da se izgubi toasts u gornjem desnom uglu
//Ispisuje da se elment izgubio
//Klik na primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Klik na x dugme iz toasts-a
//Ceka da se element izgubi
//Ispisuje da se element izgubio

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        for (int i = 0; i < 2; i++) {
            driver.findElement(By.cssSelector("#section-basic-example section.pb-4 div section div button:nth-child(1)")).click();
            wait
                    .withMessage("Toast se nije pojavio.")
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-header.toast-primary")));
            System.out.println("Toast se pojavio");

            wait
                    .withMessage("Toast nije nestao.")
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-header.toast-primary")));
            System.out.println("Toast se izgubio.");
        }
        driver.quit();
    }
}
