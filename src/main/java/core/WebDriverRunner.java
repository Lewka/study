package core;

public class WebDriverRunner {

    private static org.openqa.selenium.WebDriver threadDriver;

    private WebDriverRunner() {
    }

    public static org.openqa.selenium.WebDriver getDriver() {
        if (threadDriver == null) {
            threadDriver = (DriverFactory.initDriver());
        }
        return threadDriver;
    }

    public static void driverQuit() {
        threadDriver.quit();
    }
}