package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;
import utils.Log;

public class AlertFramesWindowsPage extends BaseForm {

    private final Button ALERT_MENU_BUTTON = new Button(By.xpath("//span[@class='text' and text()='Alerts']"), "Alerts Button");
    private final Button BROWSER_WINDOWS_BUTTON = new Button(By.xpath("//span[@class='text' and text()='Browser Windows']"), "Browser Windows Button");
    private final Button NESTED_FRAMES_BUTTON = new Button(By.xpath("//span[@class='text' and text()='Nested Frames']"), "Nested Frames Button");
    private final Button FRAMES_BUTTON = new Button(By.xpath("//span[@class='text' and text()='Frames']"),"Frames Button");

    public AlertFramesWindowsPage() {
        super(By.xpath("//div[@class='main-header' and text()='Alerts, Frame & Windows']"), "AlertFramesWindowsPage");
    }
    public void clickAlertButton (){
        Log.info("Alerts menu displayed.");
        ALERT_MENU_BUTTON.waitAndClick();
    }
    public void clickBrowserWindowsButton (){
        Log.info("Browser Windows menu displayed.");
        BROWSER_WINDOWS_BUTTON.waitAndClick();
    }
    public void clickNestedFramesButton(){
        Log.info("Nested Frames menu displayed.");
        NESTED_FRAMES_BUTTON.waitAndClick();
    }
    public void clickFramesButton(){
        Log.info("Frames menu displayed.");
        FRAMES_BUTTON.waitAndClick();
    }
}
