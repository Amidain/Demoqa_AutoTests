package pages;

import base.*;
import elements.Button;
import org.openqa.selenium.By;
import utils.Log;

public class ElementsPage extends BaseForm {

    private final Button ELEMENTS_MAIN_BUTTON = new Button(By.xpath("//div[contains(text(),'Elements')]"), "Main Elements Button");
    private final Button LINKS_BUTTON = new Button(By.xpath("//span[text()='Links']"), "Links Button");


    public ElementsPage() {
        super(By.xpath("//div[@class='main-header' and text()='Elements']"), "Elements Page");
    }

    public void clickLinksButton(){
        Log.info("Links menu displayed.");
        LINKS_BUTTON.waitAndClick();
    }

    public void clickElementsMainButton(){
        Log.info("Elements menu displayed.");
        ELEMENTS_MAIN_BUTTON.waitAndClick();
    }


}
