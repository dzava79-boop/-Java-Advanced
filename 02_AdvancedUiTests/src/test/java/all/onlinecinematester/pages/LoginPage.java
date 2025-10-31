package all.onlinecinematester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[text()='Войти']")
    private WebElement loginButton;

    @FindBy(css = ".forgot-password")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }

    public void goToForgotPassword() {
        click(forgotPasswordLink);
    }

    public boolean isLoginFormPresent() {
        try {
            return emailField.isDisplayed() && passwordField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
