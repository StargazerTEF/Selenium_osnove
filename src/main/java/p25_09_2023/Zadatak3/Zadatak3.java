package p25_09_2023.Zadatak3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji:
//Ucitava stranicu https://demoqa.com/text-box
//Unosi informacije za 3 osobe koristeci petlju
//Full Name
//Email
//Current Address
//Permanent Address
//Klik na submit
//Ceka 2 sekunde
//Osvezava stranicu
//Zatvara pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("#userName")).sendKeys("Pera" + (i+1));
            driver.findElement(By.cssSelector("#userEmail")).sendKeys("pera" + (i+1) + "@.gmail");
            driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Sremska" + (i+1));
            driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("Sremska" + (i+1));
            driver.findElement(By.cssSelector("#submit")).click();
            Thread.sleep(2000);
            driver.navigate().refresh();
        }

        driver.quit();

    }
}
