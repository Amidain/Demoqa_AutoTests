import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertFramesWindowsPage;
import pages.FramesPage;
import pages.MainPage;
import pages.NestedFramesPage;
import utils.FrameUtils;

public class FramesTest extends BaseTest {

    @Test
    void testFrames(){
        MainPage mainPage = new MainPage();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        FramesPage framesPage = new FramesPage();
        AlertFramesWindowsPage alertFramesWindowsPage = new AlertFramesWindowsPage();

        Assert.assertTrue(mainPage.isPageOpened(), "Main Page is not open!");
        mainPage.scrollDownToAlertFrameWindowsButton();
        mainPage.clickAlertFrameWindowsButton();
        alertFramesWindowsPage.clickNestedFramesButton();
        Assert.assertTrue(nestedFramesPage.isPageOpened(),"Nested Frames menu is not open!");
        nestedFramesPage.switchToParentFrame();
        Assert.assertEquals(nestedFramesPage.getParentFrameMsg(), "Parent frame", "Parent frame message is not accessible!");
        nestedFramesPage.switchToChildFrame();
        Assert.assertEquals(nestedFramesPage.getChildFrameMsg(), "Child Iframe", "Child Frame message is not accessible!");
        FrameUtils.switchBackToDefaultContent();
        alertFramesWindowsPage.clickFramesButton();
        Assert.assertTrue(framesPage.isPageOpened(), "Frame menu has not been opened!");
        Assert.assertTrue(framesPage.areFrameMsgsTheSame(), "Messages within frames are different");
    }
}
