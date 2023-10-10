package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasicPage {
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSauceLabsBackpack () {
        return driver.findElement(By.id("item_4_title_link"));
    }

    public WebElement getSauceLabsBackpackAddToCartButton () {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }
    public void clickOnAddToCartForSauceLabsBackpack () {
        getSauceLabsBackpackAddToCartButton().click();
    }
    public WebElement getRemoveButtonForSauceLabsBackpack () {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }
    public void waitForRemoveButtonToBeVisibleForSauceLabsBackpack () {
        wait
                .withMessage("Remove button for Sauce Lab Backpack should be visible.")
                .until(ExpectedConditions.visibilityOf(getRemoveButtonForSauceLabsBackpack()));
    }

}

