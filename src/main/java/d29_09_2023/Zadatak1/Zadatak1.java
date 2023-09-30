package d29_09_2023.Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) {
//Napisati program koji testira infinity scroll.
//Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//Selektujte delay od 2000ms, koristeci Select klasu.
//Skrol do Show more dugmeta koje se nalazi na dnu stranice
//Sacekajte da dugme bude klikljivo
//Klik na Show more dugme
//Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//Sacekajte da dugme vise ne bude klikljivo

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        List<WebElement> previousItems = driver.findElements(By.cssSelector("div.item"));

        WebElement delay = driver.findElement(By.id("delay-select"));

        Select select = new Select(delay);
        select.selectByValue("2000");

        WebElement showMore = driver.findElement(By.cssSelector("button#infinite-scroll-button"));
        WebElement d = driver.findElement(By.cssSelector("#infinite-scroll-container div:nth-child(5)"));

        Actions actions = new Actions(driver);

        actions.scrollToElement(d).perform();
        actions.scrollToElement(showMore).perform();

        wait
                .withMessage("Button is not clickable.")
                .until(ExpectedConditions.elementToBeClickable(showMore));

        showMore.click();

        List<WebElement> latterItems = driver.findElements(By.cssSelector("div.item"));

        wait
                .withMessage("Number of elements hasn't change.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.item"), latterItems.size()));
        System.out.println("Number of elements is higher now by " + (latterItems.size() - previousItems.size()));

        wait
                .withMessage("Button is still clickable.")
                .until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(showMore)));
        System.out.println("Button is not clickable anymore.");

        driver.quit();
    }
}
