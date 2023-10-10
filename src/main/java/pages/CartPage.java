package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasicPage{
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForUrlToContainCartPage () {
        wait
                .withMessage("Current url should contain 'cart'.")
                .until(ExpectedConditions.urlContains("cart"));
    }

    public void waitForCartPageToContainAddedProducts () {
        wait
                .withMessage("Cart page should contain added products.")
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("cart_item"), 0));
    }
    public WebElement getSubHeaderTitle () {
        return driver.findElement(By.cssSelector("span.title"));
    }
    public String getSubHeaderTitleText () {
        return getSubHeaderTitle().getText();
    }
    public void waitForLeftNavMenuToBecomeInvisible () {
        wait
                .withMessage("Left navigation menu is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("bm-menu")));
    }
    public List<WebElement> getProductsAddedToTheCart () {
        return driver.findElements(By.cssSelector("div.cart_item"));
    }
    public void waitForAddedProductsToBeVisibleOnThePage () {
        wait
                .withMessage("Added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getProductsAddedToTheCart()));
    }
    public List<WebElement> getTitlesOfProductsAddedToTheCart () {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public WebElement getTitleOfProductAddedToTheCart (int indexOfProduct) {
        return getTitlesOfProductsAddedToTheCart().get(indexOfProduct);
    }
    public void waitForAddedProductsTitlesToBeVisibleOnThePage () {
        wait
                .withMessage("Titles of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getTitlesOfProductsAddedToTheCart()));
    }
    public List<WebElement> getDescriptionsOfProductsAddedToTheCart () {
        return driver.findElements(By.className("inventory_item_desc"));
    }

    public void waitForAddedProductsDescriptionsToBeVisibleOnThePage () {
        wait
                .withMessage("Descriptions of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getDescriptionsOfProductsAddedToTheCart()));
    }
    public List<WebElement> getPricesOfProductsAddedToTheCart () {
        return driver.findElements(By.className("inventory_item_price"));
    }

    public void waitForAddedProductsPricesToBeVisibleOnThePage () {
        wait
                .withMessage("Prices of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getPricesOfProductsAddedToTheCart()));
    }
    public List<WebElement> getQuantityOfProductsAddedToTheCart() {
        return driver.findElements(By.cssSelector(".cart_item .cart_quantity"));
    }

    public void waitForAddedProductsQuantityToBeVisibleOnThePage () {
        wait
                .withMessage("Quantities of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getQuantityOfProductsAddedToTheCart()));
    }
    public void waitUntilItemsTitleIsClickable (int indexOfProduct) {
        wait
                .withMessage("Items titles should be clickable.")
                .until(ExpectedConditions.elementToBeClickable(getTitleOfProductAddedToTheCart(indexOfProduct)));
    }
    public void clickOnItemsTitle (int indexOfProduct) {
        getTitleOfProductAddedToTheCart(indexOfProduct).click();
    }
    public WebElement getRemoveButton () {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }
    public void waitUntilRemoveButtonIsVisible () {
        wait
                .withMessage("Remove button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getRemoveButton()));
    }
    public void clickOnRemoveButton () {
        getRemoveButton().click();
    }
    public void waitForAddedProductsToBecomeInvisibleOnThePage () {
        wait
                .withMessage("Added products are still visible on the page.")
                .until(ExpectedConditions.invisibilityOfAllElements(getProductsAddedToTheCart()));
    }
    public WebElement getContinueShoppingButton () {
        return driver.findElement(By.id("continue-shopping"));
    }
    public void waitUntilContinueShoppingButtonIsVisible () {
        wait
                .withMessage("'Continue Shopping' button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getContinueShoppingButton()));
    }
    public void clickOnContinueShoppingButton () {
        getContinueShoppingButton().click();
    }
    public WebElement getCheckoutButton () {
        return driver.findElement(By.id("checkout"));
    }
    public void waitUntilCheckoutButtonIsVisible () {
        wait
                .withMessage("'Checkout' button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getCheckoutButton()));
    }
    public void clickOnCheckoutButton () {
        getCheckoutButton().click();
    }
}

