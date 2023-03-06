package utils;

import drivers.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class WaitsUtil {
    private static final WebDriver driver = WebDriverFactory.getDriver();
    private static final byte waitTime = ConfigReader.getJsonObject().get("explicit_waiting_time").getAsByte();
    private final static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(waitTime));

    public static void waitForElementToBeClickable(WebElement element){
         wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }
    public static void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementPresence(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForAlertToBePresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForWindowToLoad () {
        final int MAX_ATTEMPTS = 50;
        try {
            for (int i = 0; i <= MAX_ATTEMPTS; i++) {
                ArrayList<String> openTabs = new ArrayList<>(driver.getWindowHandles());
                if (openTabs.size() <= 1) {
                    wait.withTimeout(Duration.ofSeconds(3));
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("New window did not open.");
        }
    }
}
