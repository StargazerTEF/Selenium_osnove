package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage extends BasicPage{
    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFooter () {
        return driver.findElement(By.className("footer"));
    }
    public void waitUntilFooterIsVisible () {
        wait
                .withMessage("Footer should be visible.")
                .until(ExpectedConditions.visibilityOf(getFooter()));
    }
    public WebElement getTwitterIcon () {
        return driver.findElement(By.cssSelector(".social_twitter a"));
    }
    public void waitUntilTwitterIconIsVisible () {
        wait
                .withMessage("Twitter icon in the footer should be visible.")
                .until(ExpectedConditions.visibilityOf(getTwitterIcon()));
    }
    public WebElement getFacebookIcon () {
        return driver.findElement(By.cssSelector(".social_facebook a"));
    }
    public void waitUntilFacebookIconIsVisible () {
        wait
                .withMessage("Facebook icon in the footer should be visible.")
                .until(ExpectedConditions.visibilityOf(getFacebookIcon()));
    }
    public WebElement getLinkedInIcon () {
        return driver.findElement(By.cssSelector(".social_linkedin a"));
    }
    public void waitUntilLinkedInIconIsVisible () {
        wait
                .withMessage("LinkedIn icon in the footer should be visible.")
                .until(ExpectedConditions.visibilityOf(getLinkedInIcon()));
    }
    public void clickOnTwitterIcon () {
        getTwitterIcon().click();
    }
    public void clickOnFacebookIcon () {
        getFacebookIcon().click();
    }
    public void clickOnLinkedInIcon () {
        getLinkedInIcon().click();
    }
    public WebElement getFooterCopyRightMessage () {
        return driver.findElement(By.className("footer_copy"));
    }
    public String getFooterCopyRightMessageText () {
        return getFooterCopyRightMessage().getText();
    }
}
