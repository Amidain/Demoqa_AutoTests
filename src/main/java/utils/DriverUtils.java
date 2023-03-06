package utils;

import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class DriverUtils {

    private static final WebDriver driver = WebDriverFactory.getDriver();
    public  DriverUtils() {
    }
    public static String getDriverType (){
        return ConfigReader.getJsonObject().get("current-driver").getAsString();
    }
    public static void navigate(String website){
        Log.info("Open " + website);
        driver.get(ConfigReader.getJsonObject().get(website).getAsString());
    }
    public static void maximizeWindow (){
        Log.info("Maximize window size.");
        driver.manage().window().maximize();
    }

    public static void switchTab (int tabNumber){
        WaitsUtil.waitForWindowToLoad();
        Log.info("Switch to another tab");
        ArrayList<String> openTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.get(tabNumber));
    }
    public static void closeTab(){
        Log.info("Close current tab.");
        WebDriverFactory.getDriver().close();

    }
    public static void refreshWindow(){
        Log.info("Refresh window.");
        WebDriverFactory.getDriver().navigate().refresh();
    }
}
