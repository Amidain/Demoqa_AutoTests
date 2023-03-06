package elements;

import base.BaseElement;
import org.openqa.selenium.By;
import utils.WaitsUtil;
import drivers.WebDriverFactory;

public class Button extends BaseElement {
    public Button(By elementLocator, String name) {
        super(elementLocator, name);
    }

    public void submit(){
        WaitsUtil.waitForElementToBeVisible(super.getElement());
        super.getElement().submit();
    }
}
