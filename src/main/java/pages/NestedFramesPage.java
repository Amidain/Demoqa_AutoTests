package pages;

import base.*;
import elements.Button;
import elements.TextBox;
import org.openqa.selenium.By;
import utils.FrameUtils;
import utils.Log;

public class NestedFramesPage extends BaseForm {

    private final TextBox NESTED_FRAME_MESSAGE = new TextBox(By.tagName("body"), "Parent Frame Message");

    public NestedFramesPage() {
        super(By.xpath("//div[@class='main-header' and text()='Nested Frames']"), "Nested Frames Page");
    }
    public void switchToParentFrame(){
        FrameUtils.switchToMainFrame("frame1");
    }
    public void switchToChildFrame(){
        FrameUtils.switchToAnotherFrame(0);
    }
    public String getParentFrameMsg(){
        Log.info("Parent frame text found.");
        return NESTED_FRAME_MESSAGE.getText();
    }
    public String getChildFrameMsg(){
        Log.info("Child frame text found.");
        return NESTED_FRAME_MESSAGE.getText();
    }
}
