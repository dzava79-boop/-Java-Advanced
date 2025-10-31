package all.coursetester.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage extends Page{
    @FindBy(name = "login")
    private WebElement login;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(className = "baseButton")
    private WebElement enterButton;


    public AuthorizationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "autorization1");
        PageFactory.initElements(driver, this);
    }

    public MainPage authorize(String login, String password){
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        enterButton.click();
        return new MainPage(driver, wait);
    }
}


