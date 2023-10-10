package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasicPage {
    public ItemPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitUntilCurrentUrlContainsPageName () {
        wait
                .withMessage("Url should contain page name.")
                .until(ExpectedConditions.urlContains("item"));
    }
}
