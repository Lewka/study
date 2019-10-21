package tests;

import core.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    void setupClass() {
        driver = WebDriverRunner.getDriver();
    }

    @AfterAll
    void cleanUp() {
        WebDriverRunner.driverQuit();
    }
}