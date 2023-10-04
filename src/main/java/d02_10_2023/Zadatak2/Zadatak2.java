package d02_10_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
//Napisati program koji:
//Ucitava stranu https://itbootcamp.rs/
//Misem prelazi preko Vesti iz navigacionog menija
//Ceka da se prikaze padajuci meni za Vesti
//Misem prelazi preko Kursevi iz navigacionog menija
//Ceka da se prikaze padajuci meni za Kursevi
//Misem prelazi preko Prijava i pravilnik iz navigacionog menija
//Ceka da se prikaze padajuci meni za Prijava i pravilnik
//Koristan link. Mouse over preko seleniuma https://www.selenium.dev/documentation/webdriver/actions_api/mouse/#move-to-element

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");

        WebElement newsTab = driver.findElement(By.id("menu-item-6408"));

        new Actions(driver).moveToElement(newsTab).perform();

        wait
                .withMessage("Drop down many is not visible.")
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#menu-item-6408 ul")));

        WebElement coursesTab = driver.findElement(By.id("menu-item-5362"));

        new Actions(driver).moveToElement(coursesTab).perform();

        wait
                .withMessage("Drop down many is not visible.")
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#menu-item-5362 ul")));

        WebElement applyTab = driver.findElement(By.id("menu-item-5453"));

        new Actions(driver).moveToElement(applyTab).perform();

        wait
                .withMessage("Drop down many is not visible.")
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#menu-item-5453 ul")));

        driver.quit();
    }
}
