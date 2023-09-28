package d26_09_2023.Zadatak1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji:
//Ucitava stranicu https://demoqa.com/automation-practice-form
//Popunjava formu sta stranice. Korisnik unosi podatke sa tastature za popunu forme.
//(za vezbanje) Probajte da unese i datum. Sa datumom se radi isto kao i sa obicnim inputom sa sendKeys.
//Klik na submit

        Scanner s = new Scanner(System.in);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        System.out.print("Please input your first name: ");
        String firstName = s.next();
        driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);

        System.out.print("Please input your last name: ");
        String lastName = s.next();
        driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);

        System.out.print("Please input your email: ");
        String email = s.next();
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(email);

        System.out.print("Please input your gender: ");
        String gender = s.next();

        if (gender.equals("Male")) {
            driver.findElement(By.cssSelector("[for='gender-radio-1']")).click();
        } else if (gender.equals("Female")) {
            driver.findElement(By.cssSelector("[for='gender-radio-2']")).click();
        } else {
            driver.findElement(By.cssSelector("[for='gender-radio-3']")).click();
        }

        System.out.print("Please input your phone number: ");
        String phone = s.next();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys(phone);

        System.out.print("Please input your subject: ");
        String subject = s.next();
        driver.findElement(By.id("subjectsInput")).sendKeys(subject);

        System.out.print("Please input your hobbies: ");
        String hobbies = s.next();

        if (hobbies.equals("Sports")) {
            driver.findElement(By.cssSelector("[for='hobbies-checkbox-1']")).click();
        } if (hobbies.equals("Reading")) {
            driver.findElement(By.cssSelector("[for='hobbies-checkbox-2']")).click();
        } if (hobbies.equals("Music")) {
            driver.findElement(By.cssSelector("[for='hobbies-checkbox-3']")).click();
        }
        System.out.print("Do you have other hobbies maybe?: ");
        String hobbies2 = s.next();

        if (hobbies2.equals("Sports")) {
            driver.findElement(By.cssSelector("[for='hobbies-checkbox-1']")).click();
        } if (hobbies2.equals("Reading")) {
            driver.findElement(By.cssSelector("[for='hobbies-checkbox-2']")).click();
        } if (hobbies2.equals("Music")) {
            driver.findElement(By.cssSelector("[for='hobbies-checkbox-3']")).click();
        }

        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Marko\\Desktop\\intelij.png");

        System.out.print("Please input your current address: ");
        String currentAddress = s.next();
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(currentAddress);

        System.out.print("Please select your state: ");
        String state = s.next();
        driver.findElement(By.cssSelector("#state > div > div > div.css-1wa3eu0-placeholder")).click();
        driver.findElement(By.cssSelector("#state > div > div > div.css-1wa3eu0-placeholder")).sendKeys(state);

        System.out.print("Please select your city: ");
        String city = s.next();
        driver.findElement(By.cssSelector("#city")).click();
        driver.findElement(By.cssSelector("#city")).sendKeys(city);

        driver.findElement(By.id("submit")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
