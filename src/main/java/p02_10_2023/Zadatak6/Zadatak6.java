package p02_10_2023.Zadatak6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import p02_10_2023.Helper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Zadatak6 {
    public static void main(String[] args) throws IOException {
//Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u folderu screenshots pod
//imenom screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
//Koristan link https://www.javatpoint.com/java-date-to-string

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://google.com");

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String strDate = dateFormat.format(date);

        String downloadPath = "screenshots/screenshot-" + strDate + ".jpg";

        try {
            Helper.takeScreenshot(driver, downloadPath);
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.quit();
    }
}
