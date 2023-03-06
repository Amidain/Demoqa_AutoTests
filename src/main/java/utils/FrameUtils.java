package utils;

import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FrameUtils {

    public static void switchToMainFrame(String mainFrameID){
        WebDriverFactory.getDriver().switchTo().frame(mainFrameID);
    }
    public static void switchBackToDefaultContent(){
        Log.info("Switch back to default content from frame.");
        WebDriverFactory.getDriver().switchTo().defaultContent();
    }

    public static void switchToAnotherFrame(int frameNum){
        Log.info("Switch to another frame.");
        List<WebElement> frames = WebDriverFactory.getDriver().findElements(By.tagName("iframe"));
        if(frames.size() > 0){
            WebDriverFactory.getDriver().switchTo().frame(frameNum);
        }
    }
    public static void switchToAnotherFrame(String frameName){
        Log.info("Switch to another frame.");
        List<WebElement> frames = WebDriverFactory.getDriver().findElements(By.tagName("iframe"));
        if(frames.size() > 0){
            WebDriverFactory.getDriver().switchTo().frame(TestDataReader.getFrameName(frameName));
        }
    }
}
