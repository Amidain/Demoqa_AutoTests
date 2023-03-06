package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;
import utils.DriverUtils;
import utils.Log;

public class WebDriverFactory {
    private static WebDriver driver;
    private static String type;
    public static WebDriver getDriver(){
        Log.info("Getting driver type from WebDriver Factory.");
        type = DriverUtils.getDriverType();

        if (driver==null) {
            switch (type) {
                case "Firefox":
                    Log.info("Instantiate Firefox driver.");
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments(ConfigReader.getJsonObject().get("browser-mode").getAsString());
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "Chrome":
                default:
                    Log.info("Instantiate Chrome driver.");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments(ConfigReader.getJsonObject().get("browser-mode").getAsString());
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }
        }
        return driver;
    }
}
