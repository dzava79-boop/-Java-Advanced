package all.onlinecinematester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "forgot-email")
    private WebElement emailField;

    @FindBy(xpath = "//*[text()='Восстановить пароль']")
    private WebElement recoverButton;

    @FindBy(css = ".fadeInDown")
    private WebElement successMessage;

    @FindBy(css = ".error")
    private WebElement errorMessage;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void resetPassword(String email) {
        type(emailField, email);
        click(recoverButton);
    }

    public boolean isSuccessMessageVisible() {
        return isElementVisible(successMessage, 5);
    }

    public boolean isErrorMessageVisible() {
        return isElementVisible(errorMessage, 5);
    }

    public boolean isSuccessMessageInvisible() {
        return isElementInvisible(successMessage, 3);
    }


}
