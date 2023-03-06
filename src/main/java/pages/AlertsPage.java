package pages;

import base.BaseForm;
import elements.Button;
import elements.TextBox;
import org.openqa.selenium.By;
import utils.Log;

public class AlertsPage extends BaseForm {
    private final Button DISPLAY_ALERT_BUTTON = new Button(By.id("alertButton"), "Display Alert Button");
    private final Button CONFIRM_BUTTON = new Button(By.id("confirmButton"), "Confirm Box Button");
    private final Button TIMER_ALERT_BUTTON = new Button(By.id("timerAlertButton"), "Timer Alert Button");
    private final Button PROMPT_BUTTON = new Button(By.id("promtButton"), "Prompt Button");
    private final TextBox CONFIRMATION_TEXT_BOX = new TextBox(By.id("confirmResult"), "Result Confirmation");
    private final TextBox PROMPT_INPUT_TEXTBOX = new TextBox(By.id("promptResult"), "Prompt Result");
    public AlertsPage() {
        super(By.xpath("//div[@class='main-header' and text()='Alerts']"), "Alerts Page");
    }
    public void clickDisplayAlertButton(){
        Log.info("Alert displayed.");
        DISPLAY_ALERT_BUTTON.waitAndClick();
    }
    public void clickConfirmButton(){
        Log.info("Confirm alert displayed.");
        CONFIRM_BUTTON.waitAndClick();
    }
    public void clickPromptButton (){
        Log.info("Prompt box displayed.");
        PROMPT_BUTTON.waitAndClick();
    }
    public void clickTimerAlertButton(){
        Log.info("Alert with 5 seconds delay displayed.");
        TIMER_ALERT_BUTTON.waitAndClick();
    }
    public String getBoxClosingConfirmation(){
        Log.info("Confirmation message displayed.");
        return CONFIRMATION_TEXT_BOX.getText();
    }
    public String getPromptResult(){
        Log.info("Prompt box input displayed.");
        return PROMPT_INPUT_TEXTBOX.getText().substring(12);
    }
}
