package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasicPage{
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitUntilUrlContainsPageName () {
        wait
                .withMessage("Url should contain page name.")
                .until(ExpectedConditions.urlContains("checkout"));
    }
}
