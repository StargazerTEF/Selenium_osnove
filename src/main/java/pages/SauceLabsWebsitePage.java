package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceLabsWebsitePage extends BasicPage{
    public SauceLabsWebsitePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getPageUrl () {
        return driver.getCurrentUrl();
    }
}
