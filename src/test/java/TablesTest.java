import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WebTablesPage;
import utils.User;

public class  TablesTest extends BaseTest {



    @Test(dataProvider = "users")
    void testTables(User user){
        MainPage mainPage = new MainPage();
        WebTablesPage webTablesPage = new WebTablesPage();
        int defaultNumberOfRows;

        mainPage.scrollDownToAlertFrameWindowsButton();
        mainPage.clickElementsButton();
        webTablesPage.clickWebTablesButton();
        Assert.assertTrue(webTablesPage.isPageOpened(), "Web Table Menu has not been opened!");
        defaultNumberOfRows = webTablesPage.getNumberOfRowsWithData();
        webTablesPage.clickAddButton();
        Assert.assertTrue(webTablesPage.isRegistrationFormOpen(), "Registration Form has not been opened!");
        webTablesPage.fillRegistrationForm(user);
        webTablesPage.clickSubmitFormButton();
        Assert.assertEquals(webTablesPage.getNumberOfRowsWithData(), defaultNumberOfRows + 1, "New user has not been uploaded");
        Assert.assertTrue(webTablesPage.isUserPresentInTable(user), "User has not been added!");
        webTablesPage.deleteUserFromTable(user);
        Assert.assertFalse(webTablesPage.isUserPresentInTable(user), "User has not been deleted!");
        Assert.assertEquals(webTablesPage.getNumberOfRowsWithData(), 3, "Row has not been deleted");
    }
}
