package all.parrots.pages;

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

    @FindBy(tagName = "iframe")
    public WebElement frameElement;

    @FindBy(id = "anotherEmail")
    public WebElement anotherEmailLink;

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to(url);
    }

    public String getPageUrl(){
        return url;
    }

    private String url = "https://qajava.skillbox.ru/module5/homework/";

    public void switchToFrame(){
        driver.switchTo().frame(frameElement);
    }

}

