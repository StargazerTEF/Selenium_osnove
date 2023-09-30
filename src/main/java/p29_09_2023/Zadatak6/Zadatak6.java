package p29_09_2023.Zadatak6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak6 {
    public static void main(String[] args) {
//Napisati program koji:
//Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//Ceka da broj toasts-a bude 4
//Ispisuje poruku, toasts su prikazani
//Ceka da broj toasts-a bude 0
//Ispisuje poruku, toasts su se izgubili

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        List<WebElement> buttons = driver.findElements(By.cssSelector("#section-basic-example section.pb-4 div section div button"));
        List<WebElement> toasts = new ArrayList<>();
        WebElement toast1 = driver.findElement(By.id("basic-primary-example"));
        WebElement toast2 = driver.findElement(By.id("basic-secondary-example"));
        WebElement toast3 = driver.findElement(By.id("basic-success-example"));
        WebElement toast4 = driver.findElement(By.id("basic-danger-example"));
        toasts.add(toast1);
        toasts.add(toast2);
        toasts.add(toast3);
        toasts.add(toast4);

        for (int i = 0; i < 4; i++) {
            buttons.get(i).click();
        }
            wait
                    .withMessage("Nije prikazano 4 toasta.")
                    .until(ExpectedConditions.visibilityOfAllElements(toasts));

        System.out.println("Prikazano je 4 toasta.");

        wait
                .withMessage("Toasti se nisu izgubili.")
                .until(ExpectedConditions.invisibilityOfAllElements(toasts));

        System.out.println("Toasti su se izgubili.");
        driver.quit();
    }
}
