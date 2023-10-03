package p02_10_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji:
//Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//Uploadujte sliku
//Ceka se da se pojavi slika u listi uploadovanih fajlova
//Koristite uslov da broj elemenata bude 1.
//Klik na Start dugme u okviru item-a koji se uploadovao
//Ceka se da se pojavi delete dugme pored itema
//Klik na delete dugme pored itema
//Ceka se da se element obrise
//Koristite da broj elemenata bude 0

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        File uploadFile = new File("test_data/intelij.png");

        WebElement uploadInput = driver.findElement(By.cssSelector("input[type='file']"));

        uploadInput.sendKeys(uploadFile.getAbsolutePath());

        wait
                .withMessage("There is no list of files ready for upload.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".template-upload"), 1));

        driver.findElement(By.cssSelector(".template-upload button:nth-child(2)")).click();

        wait
                .withMessage("Delete button is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".template-download button")));

        driver.findElement(By.cssSelector(".template-download button")).click();

        wait
                .withMessage("List of files is still visible.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".template-upload"), 0));

        driver.quit();
    }
}
