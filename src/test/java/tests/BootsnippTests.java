package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.BootsnippRetry;


public class BootsnippTests extends BasicTest{


    @Test(priority = 1, retryAnalyzer = BootsnippRetry.class)
    public void verifyThatPageIsOpened() {
        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com", "" +
                        "Error message");
    }


    @Test(priority = 2, retryAnalyzer = BootsnippRetry.class)
    public void editRow() {

        String firstName = "Milan";
        String lastName = "Jovanovic";
        String middleName = "Miki";

        Assert.assertEquals(tablePage.getVisibleRowNumber(), 2,
                "Error message");

        tablePage.clickOnEditButtonByRowIndex(0);

        updateDialogPage.waitForDialogToBeVisible();

        updateDialogPage.clearAndTypeFirstName(firstName);
        updateDialogPage.clearAndTypeLastName(lastName);
        updateDialogPage.clearAndTypeMiddleName(middleName);
        updateDialogPage.clickOnUpdateButton();
        updateDialogPage.waitForDialogToBeInvisible();

        Assert.assertEquals(tablePage.getFirstNameColumnValue(0),
                firstName,
                "First name should be updated in the first row ");

        Assert.assertEquals(tablePage.getLastNameColumnValue(0),
               lastName,
                "Last name should be updated in the first row");

        Assert.assertEquals(tablePage.getMiddleNameColumnValue(0),
                middleName,
                "Middle name should be updated in the first row ");

    }
    @Test(priority = 3, retryAnalyzer = BootsnippRetry.class)
    public void deleteRow() {

        int rowNumberBeforeDelete = tablePage.getVisibleRowNumber();

        tablePage.clickOnDeleteButtonByRowIndex(0);
        deleteDialogPage.waitForDialogToBeVisible();
        Assert.assertEquals(deleteDialogPage.getDialogBodyMessage(),
                "Are you sure you want to delete this data?",
                "Delete dialog message is not valid.");

        deleteDialogPage.clickOnDeleteButton();
        deleteDialogPage.waitForDialogToBeInvisible();

        int rowNumberAfterDelete = tablePage.getVisibleRowNumber();

        Assert.assertEquals(rowNumberAfterDelete, rowNumberBeforeDelete - 1,
                "Row should be deleted.");
    }
}
