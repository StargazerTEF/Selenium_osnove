package p02_10_2023.Zadatak4;

import java.io.File;

import java.io.IOException;
import java.time.Duration;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



import com.google.common.io.Files;
import org.openqa.selenium.support.ui.WebDriverWait;
import p02_10_2023.Helper;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
//Napisati program koji:
//Kreirati screenshots folder u projektu
//Ucitava stranicu https://google.com
//Kreira screenshot stranice
//Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//Koristan link 1. LAKSE CE VAM BITI PREKO OVOG
//Koristan link 2
//Koristan link 3

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://google.com");

        Helper.takeScreenshot(driver, "screenshots/screenshot1.jpg");

        driver.quit();
    }
}
