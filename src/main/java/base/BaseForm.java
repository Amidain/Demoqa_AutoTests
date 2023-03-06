package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitsUtil;
import drivers.WebDriverFactory;

import java.util.List;

public abstract class BaseForm {
    private By uniqueLocator;
    private String name;

    public BaseForm(By uniqueLocator, String name) {
        this.uniqueLocator = uniqueLocator;
        this.name = name;
    }
    public By getUniqueLocator() {
        return uniqueLocator;
    }
    public boolean isPageOpened(){
        WaitsUtil.waitForElementPresence(uniqueLocator);
        List<WebElement> uniqueElement = WebDriverFactory.getDriver().findElements(uniqueLocator);
        return uniqueElement.size() > 0;
    }
}
