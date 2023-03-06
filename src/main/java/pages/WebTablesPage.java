package pages;

import base.BaseForm;
import drivers.WebDriverFactory;
import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Log;
import utils.User;

import java.util.List;

public class WebTablesPage extends BaseForm {
    private final TextBox REGISTRATION_FORM_LABEL = new TextBox(By.id("registration-form-modal"), "Registration Form Label");
    private final Button WEB_TABLES_BUTTON = new Button(By.xpath("//li[@id='item-3']//span[text()='Web Tables']"), "Web TablesButton");
    private final Button ADD_BUTTON = new Button(By.id("addNewRecordButton"), "Add New Record Button");
    private final Button SUBMIT_FORM_BUTTON = new Button(By.id("submit"), "Submit Form Button");
    private final TextBox FIRST_NAME_INPUT_BOX = new TextBox(By.id("firstName"), "First Name Input Box");
    private final TextBox LAST_NAME_INPUT_BOX = new TextBox(By.id("lastName"),"Last Name Input Box");
    private final TextBox EMAIL_INPUT_BOX = new TextBox(By.id("userEmail"),"Email Input Box");
    private final TextBox AGE_INPUT_BOX = new TextBox(By.id("age"),"Age Input Box");
    private final TextBox SALARY_INPUT_BOX = new TextBox(By.id("salary"),"Salary Input Box");
    private final TextBox DEPARTMENT_INPUT_BOX = new TextBox(By.id("department"),"Department Input Box");

    public WebTablesPage() {
        super(By.xpath("//div[@class='main-header' and text()='Web Tables']"), "Web Tables");
    }
    public void clickWebTablesButton(){
        Log.info("Web Tables Menu is open.");
        WEB_TABLES_BUTTON.waitAndClick();
    }
    public void clickAddButton(){
        Log.info("Registration form is open.");
        ADD_BUTTON.waitAndClick();
    }

    public void fillRegistrationForm(User user){
        Log.info("Filled out registration form.");
        FIRST_NAME_INPUT_BOX.sendText(user.getFirstName());
        LAST_NAME_INPUT_BOX.sendText(user.getLastName());
        EMAIL_INPUT_BOX.sendText(user.getEmail());
        AGE_INPUT_BOX.sendText(String.valueOf(user.getAge()));
        SALARY_INPUT_BOX.sendText(String.valueOf(user.getSalary()));
        DEPARTMENT_INPUT_BOX.sendText(user.getDepartment());
    }
    public boolean isRegistrationFormOpen(){
        Log.info("Checked if registration form is displayed.");
        return REGISTRATION_FORM_LABEL.getText().equals("Registration Form");
    }

    public void clickSubmitFormButton(){
        Log.info("New record submitted.");
        SUBMIT_FORM_BUTTON.waitAndClick();
    }

    public int getNumberOfRowsWithData (){
        Log.info("Number of rows with data calculated");
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.xpath("//div[@class='action-buttons']"));
        return elements.size();
    }

    public boolean isUserPresentInTable(User user) {
        Log.info("Check if user is present in table.");
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.xpath("//div[@role='row']"));
        for (WebElement row : elements) {
            if (row.getText().contains(user.getFirstName())
                    && row.getText().contains(user.getLastName())
                    && row.getText().contains(user.getEmail())
                    && row.getText().contains(user.getDepartment())) {
                return true;
            }
        }
        return false;
    }
    public void deleteUserFromTable (User user){
        Log.info("Delete user from table.");
        String path = "";
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(By.xpath("//div[@role='row']"));
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getText().contains(user.getFirstName())
                    && elements.get(i).getText().contains(user.getLastName())
                    && elements.get(i).getText().contains(user.getEmail())
                    && elements.get(i).getText().contains(user.getDepartment())){
                path = String.format("//span[@id='delete-record-%s']", i);
                elements.get(i).findElement(By.xpath(path)).click();
            }
        }
    }
}

