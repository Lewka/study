package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

class SimpleDDTTest extends BaseTest {

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("545"),
                Arguments.of("950146464"));
    }

    @ParameterizedTest
    @MethodSource("data")
    void test(String number) {
        driver.get("https://yandex.by");
        WebElement searchInput = driver.findElement(By.id("text"));
        sleep();
        searchInput.sendKeys(number);
        sleep();
        searchInput.sendKeys(Keys.ENTER);
        sleep();
        System.out.println();
    }
}