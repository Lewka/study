package core;

import org.openqa.selenium.WebDriver;

public class WebDriverRunner {

    private static final DriverThreadLocalContainer threadDriver = new DriverThreadLocalContainer();

    private WebDriverRunner() {
    }

    public static WebDriver getDriver() {
        return threadDriver.getAndCheckWebDriver();
    }

    public static void driverQuit() {
        threadDriver.closeWebDriver();
    }
}