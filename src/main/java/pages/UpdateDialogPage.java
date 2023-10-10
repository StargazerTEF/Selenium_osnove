package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateDialogPage extends BasicPage{

    public UpdateDialogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForDialogToBeVisible () {
        wait
                .withMessage("Edit dialog should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
    }

    public WebElement getFirstNameInput () {
        return driver.findElement(By.id("fn"));
    }

    public void clearAndTypeFirstName (String firstName) {
        getFirstNameInput().clear();
        getFirstNameInput().sendKeys(firstName);
    }
    public WebElement getLastNameInput () {
        return driver.findElement(By.id("ln"));
    }

    public void clearAndTypeLastName (String lastName) {
        getFirstNameInput().clear();
        getFirstNameInput().sendKeys(lastName);
    }
    public WebElement getMiddleNameInput () {
        return driver.findElement(By.id("mn"));
    }

    public void clearAndTypeMiddleName (String middleName) {
        getFirstNameInput().clear();
        getFirstNameInput().sendKeys(middleName);
    }

    public WebElement getUpdateButton () {
        return driver.findElement(By.id("update"));
    }

    public void clickOnUpdateButton () {
        getUpdateButton().click();
    }

    public void waitForDialogToBeInvisible () {
        wait
                .withMessage("Edit dialog should be invisible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit")));
    }
 }
