package all.thenoteswebsite.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @FindBy(className = "vdp-datepicker__calendar")
    public WebElement calendar;

    @FindBy(className = "pageStatistic__date")
    public WebElement dateNotes;

    private String classNameDateLocator = "vdp-datepicker";


    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor)driver;
    }

    public void setDate(String date){
        jsExecutor.executeScript(String.format("document.getElementsByClassName(\"%s\")[0].__vue__.setDate(\"%s\");", classNameDateLocator, date));
    }

    public String getDate(){
        return String.valueOf(jsExecutor.executeScript(String.format("document.getElementsByClassName(\"%s\")[0].__vue__.setDate(\"getDate\");", classNameDateLocator)));
    }

    public void open(){
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
    }
}
