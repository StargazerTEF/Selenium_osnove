package d26_09_2023.Zadatak4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
//Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
//Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
//1243+329=
//21912-4=
//12913÷4=
//U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere.
//Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
//Zatim u odnosu na karakter uradite odredjenu logiku

        Scanner s = new Scanner(System.in);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");

        System.out.print("Enter equation: ");
        String equation = s.next();

            List<Character> chars = new ArrayList<>();
        for (char ch : equation.toCharArray()) {
            chars.add(ch);
        }

            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i) == '1') {
                    driver.findElement(By.name("cs_one")).click();
                } else if (chars.get(i) == '2') {
                    driver.findElement(By.name("cs_two")).click();
                } else if (chars.get(i) == '3') {
                    driver.findElement(By.name("cs_three")).click();
                } else if (chars.get(i) == '4') {
                    driver.findElement(By.name("cs_four")).click();
                } else if (chars.get(i) == '5') {
                    driver.findElement(By.name("cs_five")).click();
                } else if (chars.get(i) == '6') {
                    driver.findElement(By.name("cs_six")).click();
                } else if (chars.get(i) == '7') {
                    driver.findElement(By.name("cs_seven")).click();
                } else if (chars.get(i) == '8') {
                    driver.findElement(By.name("cs_eight")).click();
                } else if (chars.get(i) == '9') {
                    driver.findElement(By.name("cs_nine")).click();
                } else if (chars.get(i) == '0') {
                    driver.findElement(By.name("cs_zero")).click();
                } else if (chars.get(i) == '.') {
                    driver.findElement(By.name("cs_decimal")).click();
                } else if (chars.get(i) == '=') {
                    driver.findElement(By.name("cs_equal")).click();
                } else if (chars.get(i) == '+') {
                    driver.findElement(By.name("cs_add")).click();
                } else if (chars.get(i) == '-') {
                    driver.findElement(By.name("cs_minus")).click();
                } else if (chars.get(i) == '*') {
                    driver.findElement(By.name("cs_multiply")).click();
                } else if (chars.get(i) == '/') {
                    driver.findElement(By.name("cs_divide")).click();
                }
                Thread.sleep(1000);
            }
            Thread.sleep(5000);
        driver.quit();
    }
}
