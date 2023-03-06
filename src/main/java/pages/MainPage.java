package pages;

import base.*;
import elements.Button;
import org.openqa.selenium.By;
import utils.JSUtils;
import utils.Log;

public class MainPage extends BaseForm {
    private final Button ALERT_FRAME_WINDOWS_BUTTON = new Button(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"), "Alert, Frames & Windows Button");
    private final Button ELEMENTS_BUTTON = new Button(By.xpath("//h5[contains(text(), 'Elements')]"), "Elements Button");
    public MainPage() {
        super(By.className("category-cards"), "Main Page");
    }
    public void clickAlertFrameWindowsButton (){
        Log.info("Alerts, Frame & Windows menu is open.");
        ALERT_FRAME_WINDOWS_BUTTON.waitAndClick();
    }
    public void clickElementsButton(){
        Log.info("Elements menu is open.");
        ELEMENTS_BUTTON.waitAndClick();
    }
    public void scrollDownToAlertFrameWindowsButton (){
        JSUtils.scrollDownToElement(ALERT_FRAME_WINDOWS_BUTTON.getElement());
    }
}
