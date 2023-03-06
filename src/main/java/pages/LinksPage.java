package pages;

import base.BaseForm;
import elements.Button;
import org.openqa.selenium.By;
import utils.Log;

public class LinksPage extends BaseForm {
    private final Button HOME_BUTTON = new Button(By.id("simpleLink"), "Home Button");
    public LinksPage() {
        super(By.xpath("//div[@class='main-header' and text()='Links']"), "Links Page");
    }
    public  void clickHomeButton(){
        Log.info("New tab with main page open.");
        HOME_BUTTON.waitAndClick();
    }
}
