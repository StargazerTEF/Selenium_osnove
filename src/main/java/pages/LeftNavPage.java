package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

}

