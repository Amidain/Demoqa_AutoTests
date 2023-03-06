package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log;
import utils.WaitsUtil;
import drivers.WebDriverFactory;

import java.util.List;

public abstract class BaseElement {
    By elementLocator;
    String name;

    public BaseElement(By elementLocator, String name) {
        this.elementLocator = elementLocator;
        this.name = name;
    }

    public WebElement getElement(){
        return  WebDriverFactory.getDriver().findElement(elementLocator);
    }
    public void waitAndClick(){
        Log.info(String.format("Click action performed on %s",  name));
        WaitsUtil.waitForElementToBeClickable(elementLocator);
        getElement().click();
    }

    public String getText(){
        Log.info(String.format("Get text value from element: %s", name));
        WaitsUtil.waitForElementPresence(elementLocator);
        return getElement().getText();
    }

    public boolean isDisplayed(){
        Log.info(String.format("Checking if element: %s is displayed", name));
        WaitsUtil.waitForElementPresence(elementLocator);
        List<WebElement> uniqueElement = WebDriverFactory.getDriver().findElements(elementLocator);
        return uniqueElement.size() > 0;
    }

    public String getAttribute(String attributeName){
        Log.info(String.format("Attribute %s of element: %s found.", attributeName, name));
        WaitsUtil.waitForElementPresence(elementLocator);
        return getElement().getAttribute(attributeName);
    }
}
