package all.coursetester.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPanel {

    @FindBy(className = "baseHeader__user")
    private WebElement user;

    @FindBy(className = "baseHeader__button")
    public WebElement exitButton;

    @FindBy(className = "baseHeader__logo")
    private WebElement logo;

    private WebDriver driver;
    private WebDriverWait wait;
    public PersonalPage page;



    public HeaderPanel(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.page = new PersonalPage(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public PersonalPage openPersonalPage(){
        user.click();
        return new PersonalPage(driver, wait);
    }

    public void openMainPage(){
        logo.click();
    }


}
