package all.onlinecinematester.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = ".form-row button") // кнопка "Зарегистрироваться"
    private WebElement registerButton;

    @FindBy(css = ".form-title.result")   // заголовок «Спасибо за регистрацию!»
    private WebElement successMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void register(String name, String email, String password) {
        type(nameField, name);
        type(emailField, email);
        type(passwordField, password);
        registerButton.click();
    }


    public boolean isSuccessMessageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
