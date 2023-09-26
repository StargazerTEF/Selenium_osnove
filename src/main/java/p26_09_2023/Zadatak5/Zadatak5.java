package p26_09_2023.Zadatak5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
//Zadatak (dok ne stignemo do ovog zadatka izguglajte kako da selektujete vrednost u select elementu)
//Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");

        Thread.sleep(1000);

        WebElement n = driver.findElement(By.cssSelector("#gh-cat"));

        Select select = new Select(n);
        select.selectByVisibleText("Crafts");

        Thread.sleep(5000);

        driver.quit();

    }
}
