package utils;

import drivers.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class AlertUtils {

    private static Alert switchToAlert(){
        Log.info("Switched to alert from default content.");
        return WebDriverFactory.getDriver().switchTo().alert();
    }
    public static String getAlertText(){
        Log.info("Alert text found.");
        WaitsUtil.waitForAlertToBePresent();
        return  switchToAlert().getText();
    }

    public static void acceptAlert(){
        Log.info("Alert submitted.");
        WaitsUtil.waitForAlertToBePresent();
        switchToAlert().accept();
    }

    public static void cancelAlert(){
        Log.info("Alert dismissed.");
        WaitsUtil.waitForAlertToBePresent();
        switchToAlert().dismiss();
    }

    public static void sendText(String text){
        Log.info(String.format("Value: '%s' sent to alert.", text));
        WaitsUtil.waitForAlertToBePresent();
        switchToAlert().sendKeys(text);

    }
    public static boolean isAlertDisplayed() {
        try {
            Log.info("Alert is displayed.");
            switchToAlert();
            return true;
        } catch (NoAlertPresentException e) {
            Log.info("Alert is not displayed.");
            return false;
        }
    }
}
