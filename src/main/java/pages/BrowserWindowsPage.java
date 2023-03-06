package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;
import utils.Log;

public class BrowserWindowsPage extends BaseForm {

    private final Button NEW_TAB_BUTTON = new Button(By.id("tabButton"), "New Tab Button");

    public BrowserWindowsPage() {
        super(By.xpath("//div[@class='main-header' and text()='Browser Windows']"), "Browser Windows Page");
    }
    public void clickNewTabButton(){
        Log.info("New Tab open.");
        NEW_TAB_BUTTON.waitAndClick();
    }
}
