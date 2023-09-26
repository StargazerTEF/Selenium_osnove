package d25_09_2023.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//Maksimizirati prozor
//Ucitati stranicu https://artplayer.org/
//U fokusu je player sa desne strane
//Ceka 3-4s
//Klik na play dugme
//Klik na na zvucnik za mute
//Ceka 3s
//Klik na screenshot
//Klik na PIP mode
//Ceka 1s
//Klik na Exit PIP mode
//Klik na WebFullscreen
//Klik na Exit WebFullscreen
//Cekanje od 5s
//Zatvorite pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://artplayer.org/");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".art-icon-play > svg > path")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".art-icon-volume > svg > path:nth-child(2)")).click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".art-icon-screenshot > svg > path")).click();
        driver.findElement(By.cssSelector(".art-icon-pip > svg")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".art-icon-pip > svg")).click();
        driver.findElement(By.cssSelector(".art-icon-fullscreenWebOn > svg")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".art-icon-fullscreenWebOff > svg")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
