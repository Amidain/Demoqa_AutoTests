package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import utils.DriverUtils;
import drivers.WebDriverFactory;
import utils.Log;
import utils.TestDataReader;
import model.User;

public abstract class BaseTest {
     @BeforeTest
     public void setupTest (){
         Log.startTestCase(getClass().getName());
         DriverUtils.navigate("main page");
         DriverUtils.maximizeWindow();

    }

    @AfterTest
    public void tearDown(){
        Log.endTestCase(getClass().getName());
        WebDriverFactory.getDriver().quit();
    }

    @DataProvider(name = "users")
    public static Object[][] getUsers(){
        User [] users = TestDataReader.getUsersFromJson();
         return new Object[][]{{users[0]}};
    }
}
