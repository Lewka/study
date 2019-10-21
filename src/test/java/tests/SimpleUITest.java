package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@Epic("Epic one")
@Feature("Feature one")
@Story("Story one")
class SimpleUITest extends BaseTest {

    @Test
    @Tag("Smoke")
    @DisplayName("Мой крутой тест")
    @Description("Какое то описание")
    @TmsLink("N-253")
    @Severity(SeverityLevel.BLOCKER)
    void test() {
        driver.get("http://automationpractice.com/index.php");
        new LoginPage(driver).typePassword("asd")
                .makeScreenshot(driver);
    }
}