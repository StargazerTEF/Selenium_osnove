package tests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.SwagLabRetry;

public class SwagLabTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = SwagLabRetry.class)
    public void VerifyErrorIsDisplayedWhenUsernameIsMissing() {

        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getLoginErrorMessageText(),
                "Epic sadface: Username is required",
                "Error message should be 'Epic sadface: Username is required' ");
    }

    @Test(priority = 2, retryAnalyzer = SwagLabRetry.class)
    public void VerifyErrorIsDisplayedWhenPasswordIsMissing() {

        String username = "abc";

        loginPage.clearAndTypeUserName(username);

        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getLoginErrorMessageText(),
                "Epic sadface: Password is required",
                "Error message should be 'Epic sadface: Password is required' ");
    }

    @Test(priority = 3, retryAnalyzer = SwagLabRetry.class)
    public void VerifyErrorIsDisplayedWhenCredentialsAreWrong() {

        String username = "standard_user";
        String password = "invalidpassword";

        loginPage.clearAndTypeUserName(username);
        loginPage.clearAndTypePassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getLoginErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message should be 'Epic sadface: Username and password do not match any user in this service' ");


    }

    @Test(priority = 4, retryAnalyzer = SwagLabRetry.class)
    public void VerifyErrorIsDisplayedWhenUserIsLocked() {

        String username = "locked_out_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUserName(username);
        loginPage.clearAndTypePassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getLoginErrorMessageText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message should be 'Epic sadface: Sorry, this user has been locked out.' ");
    }

    @Test(priority = 5, retryAnalyzer = SwagLabRetry.class)
    public void VerifySuccessfulLogin() {

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUserName(username);
        loginPage.clearAndTypePassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html",
                "Current url should be 'https://www.saucedemo.com/inventory.html' ");

        topNavPage.clickOnLeftNavMenuButton();

        leftNavPage.waitForLeftNavMenuToBeVisible();

        Assert.assertTrue(leftNavPage.doesLogoutButtonExist(),
                "Logout link should exist on left navigation menu bar.");

        leftNavPage.clickOnLogoutButton();

        Assert.assertTrue(loginPage.doesUserNameInputExist(),
                "Should be redirected to the login page after logout.");

    }

    @Test(priority = 6, retryAnalyzer = SwagLabRetry.class)
    public void AddingProductsToCart() {

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUserName(username);
        loginPage.clearAndTypePassword(password);

        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html",
                "Current url should be 'https://www.saucedemo.com/inventory.html' ");

        inventoryPage.getSauceLabsBackpack();

        inventoryPage.clickOnAddToCartForSauceLabsBackpack();

        inventoryPage.waitForRemoveButtonToBeVisibleForSauceLabsBackpack();

        Assert.assertEquals(topNavPage.getNumberOfProductsInCart(), "1",
                "Number of products in cart should be 1.");

    }

    @Test(priority = 7, retryAnalyzer = SwagLabRetry.class)
    public void VerifyUrlForCartPage() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();

    }

    @Test(priority = 8, retryAnalyzer = SwagLabRetry.class)
    public void VerifyTitleNameForCartPage() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitForCartPageToContainAddedProducts();

        Assert.assertEquals(topNavPage.getTitleName(), "Swag Labs",
                "Title for this page should be 'Swag Labs'.");

    }
    @Test(priority = 9, retryAnalyzer = SwagLabRetry.class)
    public void VerifyTitleNameForCartPageWithoutAddingProducts() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();

        Assert.assertEquals(driver.getTitle(), "Swag Labs",
                "Title for this page should be 'Swag Labs'.");

    }

    @Test(priority = 10, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatBurgerMenuButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();

        Assert.assertTrue(topNavPage.doesLeftNavButtonExist(),
                "Left navigation menu button should exist on the cart page.");

    }
    @Test(priority = 11, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconIsPresentOnCartPage() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();

        Assert.assertTrue(topNavPage.doesCartIconExist(),
                "Shopping cart icon should exist on the cart page.");

    }
    @Test(priority = 12, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatBurgerMenuButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();

        Assert.assertTrue(topNavPage.isLeftNavButtonEnabled(),
                "Left navigation menu button should be enabled on the cart page.");

    }

    @Test(priority = 13, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconIsEnabled() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();

        Assert.assertTrue(topNavPage.isCartIconEnabled(),
                "Cart icon should be enabled on the cart page.");

    }
    @Test(priority = 14, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatBurgerMenuButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();

    }
    @Test(priority = 15, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconIsClickable() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        topNavPage.waitUntilCartIconIsClickable();

    }
    @Test(priority = 16, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCartIconHasCorrectNumberOfAddedProducts() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();

        Assert.assertEquals(topNavPage.getNumberOfProductsInCart(), "",
                "Number of products in cart icon should be 0.");

    }
    @Test(priority = 17, retryAnalyzer = SwagLabRetry.class)
    public void VerifyTheSubHeaderTitleForCartPage() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();

        Assert.assertEquals(cartPage.getSubHeaderTitleText(), "Your Cart",
                "Sub title header for cart page should be 'Your Cart'.");

    }
    @Test(priority = 18, retryAnalyzer = SwagLabRetry.class)
    public void VerifyTotalNumberOfOptionsInLeftNavigationMenu() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();

        Assert.assertEquals(leftNavPage.getNumberOfOptionsInLeftNavMenu(), 4,
                "Left navigation menu should contain 4 options.");

    }
    @Test(priority = 19, retryAnalyzer = SwagLabRetry.class)
    public void VerifySpellingOfAllOptionsInLeftNavigationMenu() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();

        Assert.assertTrue(leftNavPage.checkSpellingOfAllOptionsInLeftNavMenu(),
                "Spelling of elements in left navigation manu is not valid.");

    }
    @Test(priority = 20, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatAllItemsOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnAllItemsLink();

        Assert.assertEquals(inventoryPage.getSubTitleText(), "Products",
                "Sub title of inventory page should be 'Products'.");
    }
    @Test(priority = 21, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatAboutOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnAboutLink();

        Assert.assertEquals(sauceLabsWebsitePage.getPageUrl(),
                "https://saucelabs.com/",
                "Should be redirected to the Sauce Labs Website.");
    }
    @Test(priority = 22, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatLogoutOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnLogoutButton();

        Assert.assertTrue(loginPage.doesUserNameInputExist(),
                "Should be redirected to the login page.");
    }
    @Test(priority = 23, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatResetAppOptionFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();

        Assert.assertEquals(topNavPage.getNumberOfProductsInCart(), "1",
                "After reset the cart icon should be empty.");

        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitForLeftNavMenuToBeVisible();
        leftNavPage.clickOnResetAppButton();

        Assert.assertEquals(topNavPage.getNumberOfProductsInCart(), "",
                "After reset the cart icon should be empty.");
    }
    @Test(priority = 24, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatExitButtonFromLeftNavigationMenuIsVisible() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();

    }
    @Test(priority = 25, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatExitButtonFromLeftNavigationMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        cartPage.waitForUrlToContainCartPage();
        topNavPage.clickOnLeftNavMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
        leftNavPage.clickOnExitButton();
        cartPage.waitForLeftNavMenuToBecomeInvisible();

    }
    @Test(priority = 26, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsAddedToTheCartAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsToBeVisibleOnThePage();

    }
    @Test(priority = 27, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsTitleAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsTitlesToBeVisibleOnThePage();

    }
    @Test(priority = 28, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsDescriptionAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsDescriptionsToBeVisibleOnThePage();

    }
    @Test(priority = 29, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsPriceAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsPricesToBeVisibleOnThePage();

    }
    @Test(priority = 30, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsQuantityIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitForAddedProductsQuantityToBeVisibleOnThePage();

    }
    @Test(priority = 31, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsTitleIsClickable() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilItemsTitleIsClickable(0);

    }
    @Test(priority = 32, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatItemsTitleIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilItemsTitleIsClickable(0);
        cartPage.clickOnItemsTitle(0);
        itemPage.waitUntilCurrentUrlContainsPageName();

    }
    @Test(priority = 33, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatRemoveButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilRemoveButtonIsVisible();

    }
    @Test(priority = 34, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatRemoveButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilRemoveButtonIsVisible();
        cartPage.clickOnRemoveButton();
        cartPage.waitForAddedProductsToBecomeInvisibleOnThePage();

    }
    @Test(priority = 35, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatContinueShoppingButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilContinueShoppingButtonIsVisible();

    }
    @Test(priority = 36, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatContinueShoppingButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilContinueShoppingButtonIsVisible();
        cartPage.clickOnContinueShoppingButton();

        Assert.assertEquals(inventoryPage.getSubTitleText(), "Products",
                "Should be redirected to the inventory page.");

    }
    @Test(priority = 37, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCheckoutButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilCheckoutButtonIsVisible();

    }
    @Test(priority = 37, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatCheckoutButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartForSauceLabsBackpack();
        topNavPage.clickOnCart();
        cartPage.waitUntilCheckoutButtonIsVisible();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilUrlContainsPageName();

    }
    @Test(priority = 38, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatTwitterIconIsVisibleInTheFooter() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        footerPage.waitUntilTwitterIconIsVisible();

    }
    @Test(priority = 39, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatFacebookIconIsVisibleInTheFooter() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        footerPage.waitUntilFacebookIconIsVisible();

    }
    @Test(priority = 40, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatLinkedInIconIsVisibleInTheFooter() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        footerPage.waitUntilLinkedInIconIsVisible();

    }
    @Test(priority = 41, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatTwitterIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        footerPage.waitUntilTwitterIconIsVisible();
        footerPage.clickOnTwitterIcon();
        sauceLabsTwitterPage.switchToNewTab();
        sauceLabsTwitterPage.waitUntilUrlContainsTwitterPage();

    }
    @Test(priority = 42, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatFacebookIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        footerPage.waitUntilTwitterIconIsVisible();
        footerPage.clickOnFacebookIcon();
        sauceLabsFacebookPage.switchToNewTab();
        sauceLabsFacebookPage.waitUntilUrlContainsTFacebookPage();

    }
    @Test(priority = 42, retryAnalyzer = SwagLabRetry.class)
    public void VerifyThatLinkedInIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        topNavPage.clickOnCart();
        footerPage.waitUntilTwitterIconIsVisible();
        footerPage.clickOnLinkedInIcon();
        sauceLabsLinkedInPage.switchToNewTab();
        sauceLabsLinkedInPage.waitUntilUrlContainsLinkedInPage();
    }
}
