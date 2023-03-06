import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertFramesWindowsPage;
import pages.AlertsPage;
import pages.MainPage;
import utils.AlertUtils;
import utils.RandomUtil;

public class AlertTest extends BaseTest {

    @Test
    void testAlerts() {
        MainPage mainPage = new MainPage();
        AlertFramesWindowsPage alertFramesWindowsPage = new AlertFramesWindowsPage();
        AlertsPage alertsPage = new AlertsPage();

        Assert.assertTrue(mainPage.isPageOpened(), "Main Page has not been opened!");
        mainPage.scrollDownToAlertFrameWindowsButton();
        mainPage.clickAlertFrameWindowsButton();
        alertFramesWindowsPage.clickAlertButton();
        Assert.assertTrue(alertsPage.isPageOpened(), "Alert menu has not been opened!");
        alertsPage.clickDisplayAlertButton();
        Assert.assertEquals(AlertUtils.getAlertText(), "You clicked a button", "Alert does not contain searched value!");
        AlertUtils.acceptAlert();
        Assert.assertFalse(AlertUtils.isAlertDisplayed(), "Alert is still displayed!");
        alertsPage.clickConfirmButton();
        Assert.assertEquals(AlertUtils.getAlertText(), "Do you confirm action?", "Alert does not contain searched value!");
        AlertUtils.acceptAlert();
        Assert.assertFalse(AlertUtils.isAlertDisplayed(), "Alert is still displayed!");
        Assert.assertEquals(alertsPage.getBoxClosingConfirmation(), "You selected Ok", "Confirmation has not been displayed!");
        alertsPage.clickPromptButton();
        String generatedString = RandomUtil.getRandomString();
        AlertUtils.sendText(generatedString);
        AlertUtils.acceptAlert();
        Assert.assertEquals(generatedString, alertsPage.getPromptResult(), "Prompt Alert input is not the same as result in confirmation!");
        alertsPage.clickTimerAlertButton();
        Assert.assertEquals(AlertUtils.getAlertText(), "This alert appeared after 5 seconds", "Alert has not been displayed, message inaccessible");
        AlertUtils.acceptAlert();
    }
}
