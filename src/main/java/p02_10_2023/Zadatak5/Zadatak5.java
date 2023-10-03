package p02_10_2023.Zadatak5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import p02_10_2023.Helper;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) throws IOException {
//Napisati program koji:
//Ucitava stranicu https://demoqa.com/broken
//Hvata oba linka sa stranice i
//Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//Koristan link za citanje status koda nekog url-a

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/broken");

        List<WebElement> links = driver.findElements(By.cssSelector("div.col-md-6 div a"));

        try {
            for (int i = 0; i < links.size(); i++) {
                int statusCode = Helper.getHTTPResponseStatusCode(links.get(i).getAttribute("href"));
                if (statusCode >= 200 && statusCode < 400) {
                    System.out.println("Response code from link " + links.get(i).getAttribute("href") + " is successful.");
                } else {
                    System.out.println("Response from link " + links.get(i).getAttribute("href") + "is not successful.");
                }
            }
        } catch (Exception e) {
        }
        driver.quit();
    }
}
