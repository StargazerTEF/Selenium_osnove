package p05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import p02_10_2023.Helper;
import p28_09_2023.Zadatak2.TestHelper;
import org.testng.ITestResult;

import java.io.IOException;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

public class SwagLabsTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    private String baseUrl = "https://www.saucedemo.com/";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver
                .findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not visible on the page.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container h3")));

        Assert.assertEquals(driver.findElement(By.cssSelector(".error-message-container h3")).getText(),
                "Epic sadface: Username is required",
                "Error message should be 'Epic sadface: Username is required' ");

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyErroIsDisplayedWhenPasswordIsMissing() {

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("abc");

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not visible on the page.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container h3")));

        Assert.assertEquals(driver.findElement(By.cssSelector(".error-message-container h3")).getText(),
                "Epic sadface: Password is required",
                "Error message should be 'Epic sadface: Password is required' ");

    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {

        String email = "standard_user";
        String password = "invalidpassword";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not visible on the page.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container h3")));

        Assert.assertEquals(driver.findElement(By.cssSelector(".error-message-container h3")).getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message should be 'Epic sadface: Username and password do not match any user in this service' ");


    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyErrorIsDisplayedWhenUserIsLocked() {

        String email = "locked_out_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Error message is not visible on the page.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container h3")));

        Assert.assertEquals(driver.findElement(By.cssSelector(".error-message-container h3")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message should be ' Epic sadface: Sorry, this user has been locked out.' ");

    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void VerifySuccessfulLogin() {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("react-burger-menu-btn")).click();

        wait
                .withMessage("Menu list is not visible on the page.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bm-menu")));

        TestHelper testHelper = new TestHelper(driver);
        Assert.assertTrue(testHelper.elementExists(By.id("logout_sidebar_link")));

        driver.findElement(By.id("logout_sidebar_link")).click();

        wait
                .withMessage("Login form is not visible on the page.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));

    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void addingProductsToCart() {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait
                .withMessage("Remove button is not visible on the page.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("remove-sauce-labs-backpack")));

        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1",
                "Number of products should added to cart should be 1");

    }

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void viewingProductDetails() {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        List<WebElement> backpackElements = driver.findElements(By.className("inventory_item"));

        wait
                .withMessage("Backpack elements are not visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(backpackElements));


    }

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void removingProductsFromCart() {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1",
                "Number of products should added to cart should be 1");

        driver.findElement(By.className("shopping_cart_link")).click();

        wait
                .withMessage("Product wasn't added to the cart.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        wait
                .withMessage("Product hasn't been removed from to the cart.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("inventory_item_name")));

    }

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void productCheckout() {

        String email = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        wait
                .withMessage("Checkout button is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).clear();
        driver.findElement(By.id("first-name")).sendKeys(checkoutName);

        driver.findElement(By.id("last-name")).clear();
        driver.findElement(By.id("last-name")).sendKeys(checkoutLastName);

        driver.findElement(By.id("postal-code")).clear();
        driver.findElement(By.id("postal-code")).sendKeys(checkoutZip);

        driver.findElement(By.id("continue")).click();

        wait
                .withMessage("Checkout form is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_summary_container")));

        Assert.assertEquals(driver.findElement(By.className("summary_total_label")).getText(),
                "Total: $32.39",
                "Total price should be $32.39");

        driver.findElement(By.id("finish")).click();

        Assert.assertEquals(driver.findElement(By.className("complete-header")).getText(),
                "Thank you for your order!",
                "Message doesn't show up.");

    }

    @Test(priority = 10, retryAnalyzer = RetryAnalyzer.class)
    public void validateSocialLinksInFooter() throws IOException {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        WebElement footer = driver.findElement(By.className("footer"));

        new Actions(driver).scrollToElement(footer).perform();

        List<WebElement> links = driver.findElements(By.cssSelector(".social li a"));

        for (int i = 0; i < links.size(); i++) {
            int statusCode = Helper.getHTTPResponseStatusCode(links.get(i).getAttribute("href"));
            Assert.assertEquals(statusCode, 200, "Status code of " + links.get(i).getAttribute("href") + " should be 200");
        }
    }

    @Test(priority = 11, retryAnalyzer = RetryAnalyzer.class)
    public void TestDefaultNameSort() {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));

        int x = 0;

        for (int i = 1; i < products.size(); i++) {
            String previous = products.get(x).getText();
            Assert.assertFalse(products.get(i).getText().compareTo(previous) < 0,
                    "Products are not selected in ascending alphabetical order");
            x++;
        }
    }

    @Test(priority = 12, retryAnalyzer = RetryAnalyzer.class)
    public void TestInvertNamedSort() {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.className("product_sort_container")).click();

        wait
                .withMessage("Reverse name ordering of products is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product_sort_container option:nth-child(2)")));

        driver.findElement(By.cssSelector(".product_sort_container option:nth-child(2)")).click();

        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));

        int x = 0;

        for (int i = 1; i < products.size(); i++) {
            String previous = products.get(x).getText();
            Assert.assertFalse(products.get(i).getText().compareTo(previous) > 0,
                    "Products are not selected in descending alphabetical order");
            x++;
        }
    }

    @Test(priority = 13, retryAnalyzer = RetryAnalyzer.class)
    public void TestSortPriceLowToHigh() {

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait
                .withMessage("Page url doesn't contain '/inventory.html'.")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.className("product_sort_container")).click();

        wait
                .withMessage("Reverse name ordering of products is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product_sort_container option:nth-child(2)")));

        driver.findElement(By.cssSelector(".product_sort_container option:nth-child(3)")).click();

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        ArrayList<String> pricesWithoutDollarSign = new ArrayList<>();

        for (WebElement price : prices) {
            String pricesTrimmed = price.getText().replace("$", "");
            pricesWithoutDollarSign.add(pricesTrimmed);
        }

        ArrayList<Double> pricesDouble = new ArrayList<>();

        for (String s : pricesWithoutDollarSign) {
            double pricesD = Double.parseDouble(s);
            pricesDouble.add(pricesD);
        }

        int x = 0;

        for (int i = 1; i < pricesDouble.size(); i++) {
            Double previous = pricesDouble.get(x);
            Assert.assertFalse(pricesDouble.get(i) < previous,
                    "Products are not selected in ascending price order.");
            x++;
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        js.executeScript("window.localStorage.clear();");
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.takeScreenshotWithDateTimeFormat(driver, testResult.getName());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
