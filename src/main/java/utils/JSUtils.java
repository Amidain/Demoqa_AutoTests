package utils;

import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {
    private static final WebDriver driver = WebDriverFactory.getDriver();
    public static void scrollDownToElement (WebElement element){
        Log.info(String.format("Scroll down to: %s" , element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void scrollDownToElement (By locator){
        Log.info(String.format("Scroll down to: %s" , locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
}
