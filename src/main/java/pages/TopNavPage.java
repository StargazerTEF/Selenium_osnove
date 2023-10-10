package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavPage extends BasicPage{
    public TopNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLeftNavMenuButton () {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public void clickOnLeftNavMenuButton () {
        getLeftNavMenuButton().click();
    }

    public WebElement getCart () {
        return driver.findElement(By.className("shopping_cart_badge"));
    }
    public String getNumberOfProductsInCart () {
        return getCart().getText();
    }

}