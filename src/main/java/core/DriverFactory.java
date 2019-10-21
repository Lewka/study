package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public DriverFactory() {
    }

    public static WebDriver initDriver() {
        DriverType browser = getBrowser();
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriverProvider().createWebDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriverProvider().createWebDriver();
            default:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriverProvider().createWebDriver();
        }
    }

    private static DriverType getBrowser() {
        return DriverType.CHROME;
    }
}