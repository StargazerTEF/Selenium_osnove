package d26_09_2023.Zadatak2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
//Napisati program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce
//poruke (OVO JE POTREBNO RESITI PETLJOM)
//POMOC: Brisite elemente odozdo.
//(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> colorBars = driver.findElements(By.cssSelector(".alert-dismissable"));

//      deleting rows from bottom to top

        for (int i = colorBars.size() - 1; i >= 0; i--) {
            colorBars.get(i).findElement(By.cssSelector(".close")).click();
            Thread.sleep(1000);
            List<WebElement> deletedRows = driver.findElements(By.cssSelector(".alert-dismissable:nth-child(" + (i + 1) + ")"));
            if (deletedRows.isEmpty()) {
                System.out.println((i + 1) + ". red je obrisan.");
            } else {
                System.out.println((i + 1) + ". red nije obrisan.");
            }
            Thread.sleep(1000);
        }

//       deleting rows from top to bottom

//        for (int i = 0; i < colorBars.size(); i++) {
//            colorBars.get(i).findElement(By.cssSelector(".close")).click();
//            Thread.sleep(1000);
//            List<WebElement> deletedRows = driver.findElements(By.cssSelector(".alert-dismissable:nth-child(" + (colorBars.size() - i) + ")"));
//            if (deletedRows.isEmpty()) {
//                System.out.println((i + 1) + ". red je obrisan.");
//            } else {
//                System.out.println((i + 1) + ". red nije obrisan.");
//            }
//            Thread.sleep(1000);
//        }
        driver.quit();
    }
}
