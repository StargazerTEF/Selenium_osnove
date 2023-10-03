package p02_10_2023.Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import p02_10_2023.Helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException, IOException {
//Napisati program koji:
//Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//U folder skinite i postavite proizvoljnu sliku
//Ucitava stranu https://tus.io/demo.html
//Skrola do dela za upload fajla
//Aploadujte sliku
//Cekajte da se pojava dugme za download fajla

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");

        File uploadFile = new File("test_data/intelij.png");

        WebElement uploadInput = driver.findElement(By.cssSelector("input#P0-0"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(uploadInput);
                uploadInput.sendKeys(uploadFile.getAbsolutePath());

                wait
                        .withMessage("Download is not visible.")
                        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._buttons_gq6c0_28 a")));

        System.out.println(uploadFile.length() / 1024 + "Kb");

        String urlToDownloadFrom = driver.findElement(By.cssSelector("._buttons_gq6c0_28 a")).getAttribute("href");

        String downloadPath = "C:\\Users\\Marko\\Desktop\\Projekti\\Selenium_osnove\\downloads\\donloaded_intelij.png";

        Helper.downloadUsingNIO(urlToDownloadFrom, downloadPath);

        File downloadedFile = new File("downloads/donloaded_intelij.png");

        System.out.println(downloadedFile.length() / 1024 + "Kb");

        if (uploadFile.length() == downloadedFile.length()) {
            System.out.println("Uploaded and downloaded file are the same size.");
        } else {
            System.out.println("Uploaded and downloaded file are not the same size.");
        }
        driver.quit();
    }
}
