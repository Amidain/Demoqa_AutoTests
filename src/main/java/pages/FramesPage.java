package pages;

import base.*;
import elements.Button;
import elements.TextBox;
import org.openqa.selenium.By;
import utils.FrameUtils;
import utils.JSUtils;
import utils.Log;

public class FramesPage extends BaseForm {

    private final TextBox FRAME_MSG_TEXT_BOX = new TextBox(By.id("sampleHeading"), "Frame message");

    public FramesPage() {
        super(By.xpath("//div[@class='main-header' and text()='Frames']"), "Frames Page");
    }

    public boolean areFrameMsgsTheSame(){
        Log.info("Check if messages in both frames are the same.");
        FrameUtils.switchToAnotherFrame("frames-main-frame");
        String firstMsg = FRAME_MSG_TEXT_BOX.getText();
        FrameUtils.switchBackToDefaultContent();

        FrameUtils.switchToAnotherFrame("frames-second-frame");
        String secondMsg = FRAME_MSG_TEXT_BOX.getText();
        FrameUtils.switchBackToDefaultContent();
        return secondMsg.equals(firstMsg);
    }
}
