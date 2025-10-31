package all.scrolling.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    @FindBy(className = "site-info")
    public WebElement siteInfo;

    @FindBy(id = "ak-top")
    public WebElement scrollButton;


    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor)driver;
    }

    public void open(){
        driver.navigate().to("https://intershop5.skillbox.ru/");
    }

    public void scrollToSiteInfo(){
        jsExecutor.executeScript("arguments[0].scrollIntoView();", siteInfo);
        wait.until(ExpectedConditions.visibilityOf(siteInfo));
    }

    public boolean isScrollButtonVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(scrollButton));
            return scrollButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
