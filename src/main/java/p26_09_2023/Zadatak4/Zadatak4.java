package p26_09_2023.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://cms.demo.katalon.com/my-account/");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#rememberme")).click();

        if (driver.findElement(By.cssSelector("#rememberme")).isSelected()) {
            System.out.println("Box je cekiran");
        } else {
            System.out.println("Box nije cekiran");
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
