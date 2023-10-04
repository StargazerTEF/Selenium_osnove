package d02_10_2023.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import p02_10_2023.Helper;

import java.io.File;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji:
//Ucitava stranicu https://blueimp.github.io/jQuery-File-Upload/
//Uploaduje sve cetiri slike odjenom (slike iz prvog zadatka)
//Ceka da se prikazu 4 item-a a upload
//Klik na upload
//Ceka da se upload zavrsi

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        WebElement inputFiles = driver.findElement(By.cssSelector("input[type='file']"));

        String path1 = "C:\\Users\\Marko\\Desktop\\Projekti\\Selenium_osnove\\itbootcamp_slider\\0.png";
        String path2 = "C:\\Users\\Marko\\Desktop\\Projekti\\Selenium_osnove\\itbootcamp_slider\\1.png";
        String path3 = "C:\\Users\\Marko\\Desktop\\Projekti\\Selenium_osnove\\itbootcamp_slider\\2.png";
        String path4 = "C:\\Users\\Marko\\Desktop\\Projekti\\Selenium_osnove\\itbootcamp_slider\\3.png";

        inputFiles.sendKeys((path1 + "\n" + path2 + "\n" + path3 + "\n" + path4));

        wait
                .withMessage("There is no 4 files for upload")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tr.template-upload"), 4));

        driver.findElement(By.cssSelector("button.btn-primary")).click();

        wait
                .withMessage("Upload progress is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className(".fileupload-progress")));

        driver.quit();
    }
}
