import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverUtils;

public class BrowserWindowsTest extends BaseTest {

    @Test
    void testBrowserWindows(){
        MainPage mainPage = new MainPage();
        AlertFramesWindowsPage alertFramesWindowsPage = new AlertFramesWindowsPage();
        ElementsPage elementsPage = new ElementsPage();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        LinksPage linksPage = new LinksPage();

        SamplePage samplePage = new SamplePage();
        mainPage.scrollDownToAlertFrameWindowsButton();
        mainPage.clickAlertFrameWindowsButton();
        alertFramesWindowsPage.clickBrowserWindowsButton();
        Assert.assertTrue(browserWindowsPage.isPageOpened(),"Browser Windows Menu has not been displayed!");
        browserWindowsPage.clickNewTabButton();
        DriverUtils.switchTab(1);
        Assert.assertTrue(samplePage.isPageOpened(), "Sample Page has not been opened!");
        DriverUtils.closeTab();
        DriverUtils.switchTab(0);
        Assert.assertTrue(browserWindowsPage.isPageOpened(),"Browser Windows Menu has not been displayed!");
        elementsPage.clickElementsMainButton();
        elementsPage.clickLinksButton();
        linksPage.clickHomeButton();
        DriverUtils.switchTab(1);
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page is not open!");
        DriverUtils.switchTab(0);
        Assert.assertTrue(linksPage.isPageOpened(), "Link menu is not open!");
    }
}
