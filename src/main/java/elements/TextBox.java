package elements;

import base.BaseElement;
import org.openqa.selenium.By;
import utils.Log;
import utils.WaitsUtil;

public class TextBox extends BaseElement {

    public TextBox(By elementLocator, String name) {
        super(elementLocator, name);
    }

    public void sendText(String text){
        Log.info(String.format("Input value: '%s' into text box.", text));
        WaitsUtil.waitForElementToBeVisible(super.getElement());
        super.getElement().sendKeys(text);
    }
    public void clear (){
        Log.info("Clear text box");
        WaitsUtil.waitForElementToBeVisible(super.getElement());
        super.getElement().clear();
    }
}
