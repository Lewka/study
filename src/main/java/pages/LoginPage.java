package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    @FindBys({@FindBy(id = "username"), @FindBy(name = "user")})
    private WebElement usernameLocator;

    @FindBy(id = "passwd")
    private WebElement passwordLocator;

    @FindBy(id = "login")
    private WebElement loginButtonLocator;

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeUsername(String username) {
        usernameLocator.sendKeys(username);
        return this;
    }

    @Step("Ввводим значение [{0}] в поле пароль")
    public LoginPage typePassword(String password) {
        List<WebElement> elements = driver.findElements(By.cssSelector("#homefeatured li"));
        elements.forEach(e -> System.out.println(e.getText()));
        return this;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public LoginPage submitLoginExpectingFailure() {
        loginButtonLocator.submit();
        return new LoginPage(driver);
    }
}