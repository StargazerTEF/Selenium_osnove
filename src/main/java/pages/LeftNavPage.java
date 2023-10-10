package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftNavPage extends BasicPage{
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForLeftNavMenuToBeVisible () {
        wait
                .withMessage("Left navigation menu is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu")));
    }

    public boolean doesLogoutButtonExist () {
       return elementExists(By.linkText("Logout"), 0);
    }
    public WebElement getLogoutButton () {
        return driver.findElement(By.id("logout_sidebar_link"));
    }
    public void clickOnLogoutButton () {
        getLogoutButton().click();
    }

    public List<WebElement> getOptionsFromLeftNavMenu () {
        return driver.findElements(By.cssSelector(".bm-item-list a"));
    }

    public int getNumberOfOptionsInLeftNavMenu () {
        return getOptionsFromLeftNavMenu().size();
    }
    public boolean checkSpellingOfAllOptionsInLeftNavMenu () {
        ArrayList<String> namesOfLeftNavMenuOptions = new ArrayList<>(Arrays.asList("All Items", "About", "Logout", "Reset App State"));
        for (int i = 0; i < getOptionsFromLeftNavMenu().size(); i++) {
            if (getOptionsFromLeftNavMenu().get(i).getText().equals(namesOfLeftNavMenuOptions.get(i))) {
                return true;
            }
        }
        return false;
    }
    public WebElement getAllItemsLink () {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public void clickOnAllItemsLink () {
        getAllItemsLink().click();
    }
    public WebElement getAboutLink () {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public void clickOnAboutLink () {
        getAboutLink().click();
    }
    public WebElement getResetAppButton () {
        return driver.findElement(By.id("reset_sidebar_link"));
    }

    public void clickOnResetAppButton () {
        getResetAppButton().click();
    }
    public WebElement getExitButton () {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }

    public void clickOnExitButton () {
        getExitButton().click();
    }
    public void waitUntilExitButtonIsVisible () {
        wait
                .withMessage("Exit button should be visible.")
                .until(ExpectedConditions.visibilityOf(getExitButton()));
    }
}


