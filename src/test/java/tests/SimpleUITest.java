package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

class SimpleUITest extends BaseTest {

    @Test
    void test() {
        driver.get("https://yandex.by");
        WebElement searchInput = driver.findElement(By.id("text"));
        sleep();
        searchInput.sendKeys("Ищем что нибудь");
        sleep();
        searchInput.sendKeys(Keys.ENTER);
        sleep();
        System.out.println();
    }
}