package all.nameforaparrot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(css = "input[placeholder='e-mail']")
    public WebElement email;

    @FindBy(id = "sendMe")
    public WebElement button;

    @FindBy(id = "resultTextBlock")
    public WebElement resultText;

    @FindBy(className = "form-error")
    public WebElement errorText;

    @FindBy(css = "iframe")
    private WebElement formFrame;

    @FindBy(css = ".socialLinks__link:nth-of-type(2)")
    public WebElement VkontakteLink;

    @FindBy(css = ".footer__contactItem.descriptionText:last-of-type")
    public WebElement skillboxlink;

    @FindBy(className = "header")
    public WebElement header;

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to("https://qajava.skillbox.ru/module5/homework/");
    }

    public void switchToFrame() {
        driver.switchTo().frame(formFrame);
    }

    public void switchToMainPage(){
        driver.switchTo().defaultContent();
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public Boolean getErrorText(){
        return errorText.isDisplayed();
    }

    public Boolean getResultText(){
        return resultText.isDisplayed();
    }




}
