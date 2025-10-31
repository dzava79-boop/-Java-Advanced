package all.webinarsskillbox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    @FindBy(className = "ui-header__toggle")
    public WebElement catalogButton;

    @FindBy(className = "ui-header-desktop-menu__content")
    public WebElement lightBox;

    @FindBy(name = "search")
    public WebElement search;

    @FindBy(className = "programs-gallery__content")
    public WebElement resultSearch;

    private WebDriver driver;
    private WebDriverWait wait;

    public void open(){
        driver.navigate().to("https://live.skillbox.ru/");
    }

    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public Boolean isSuccessResultSearchDisplayed(){
       return resultSearch.isDisplayed();
    }
}
