package all.balabol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(id = "uploadInput")
    public WebElement uploadInput;

    @FindBy(className = "module__file__error")
    public WebElement errorDownload;

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

    private String url = "https://lm.skillbox.cc/qa_tester/module08/practice2/";

}
