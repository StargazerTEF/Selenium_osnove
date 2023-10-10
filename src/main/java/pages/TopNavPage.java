package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        return driver.findElement(By.className("shopping_cart_link"));
    }
    public String getNumberOfProductsInCart () {
        return getCart().getText();
    }
    public void clickOnCart () {
        getCart().click();
    }
    public WebElement getTitle () {
        return driver.findElement(By.className("app_logo"));
    }
    public String getTitleName () {
        return getTitle().getText();
    }
    public boolean doesLeftNavButtonExist () {
        return elementExists(By.id("react-burger-menu-btn"));
    }
    public boolean doesCartIconExist () {
        return elementExists(By.className("shopping_cart_link"));
    }
    public boolean isLeftNavButtonEnabled () {
       return driver.findElement(By.id("react-burger-menu-btn")).isEnabled();
    }
    public boolean isCartIconEnabled () {
        return driver.findElement(By.className("shopping_cart_link")).isEnabled();
    }
    public void waitUntilCartIconIsClickable () {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
    }
}
