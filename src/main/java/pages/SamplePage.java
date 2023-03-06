package pages;

import base.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm{

    public SamplePage() {
        super(By.xpath("//h1[text()='This is a sample page']"), "Sample Page");
    }
}
