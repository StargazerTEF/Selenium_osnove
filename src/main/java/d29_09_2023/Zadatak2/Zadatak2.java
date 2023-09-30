package d29_09_2023.Zadatak2;

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

public class Zadatak2 {
    public static void main(String[] args) {

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

        for (int i = 0; i < 5; i++) {
            actions.scrollToElement(showMore).perform();

            wait
                    .withMessage("Button is not clickable.")
                    .until(ExpectedConditions.elementToBeClickable(showMore));

            showMore.click();

            List<WebElement> latterItems = driver.findElements(By.cssSelector("div.item"));

            int x = latterItems.size() - previousItems.size();

            wait
                    .withMessage("Number of elements hasn't changed.")
                    .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.item"), latterItems.size()));
            System.out.println("Number of elements is higher now by " + x);

            wait
                    .withMessage("Button is still clickable.")
                    .until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(showMore)));
            System.out.println("Button is not clickable anymore.");

            actions.scrollToElement(latterItems.get((latterItems.size()) - 2)).perform();
        }
        driver.quit();
    }
}
