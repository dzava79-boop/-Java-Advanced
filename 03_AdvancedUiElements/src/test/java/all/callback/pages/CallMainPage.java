package all.callback.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallMainPage {
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private WebDriverWait wait;

    @FindBy(name = "from")
    private WebElement fromTimeSelect;

    @FindBy(name = "to")
    private WebElement toTimeSelect;

    @FindBy(name = "phone")
    public WebElement phone;

    @FindBy(className = "baseButton")
    public WebElement callMeButton;

    @FindBy(css = ".firstModul__col:nth-of-type(1) .h2")
    private WebElement resultDate;

    @FindBy(css = ".firstModul__col:nth-of-type(2) .h2")
    private WebElement resultTimePeriod;

    @FindBy(className = "baseInput__tipMessage")
    private WebElement resultPhoneError;

    @FindBy(className = "datepicker__tipMessage")
    private WebElement errorDate;

    @FindBy(className = "timePicker__message")
    private WebElement errorTime;

    public String classNameLocator = "datepicker__main";
    public String expectedErrorTextDateAndTime = "К сожалению, в это время мы отдыхаем, выберите другое время";
    public String expectedErrorTextPhoneAndDate = "Поле обязательно для заполнения";

    public CallMainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        jsExecutor = (JavascriptExecutor)driver;
    }

    public void setDate(String date){
        jsExecutor.executeScript(String.format("document.getElementsByClassName(\"%s\")[0].__vue__.setDate(\"%s\");", classNameLocator, date));
    }

    public String getDate(){
        return String.valueOf(jsExecutor.executeScript(String.format("return document.getElementsByClassName(\"%s\")[0].__vue__.selectedDate", classNameLocator)));
    }

    public void setFromTime(String value){
        jsExecutor.executeScript("document.getElementsByName(\"from\")[0].style = \"display:block;\"");
        var fromTime = new Select(fromTimeSelect);
        fromTime.selectByValue(value);
    }

    public void setToTime(String value){
        jsExecutor.executeScript("document.getElementsByName(\"to\")[0].style = \"display:block;\"");
        var toTime = new Select(toTimeSelect);
        toTime.selectByValue(value);
    }

    public String getResultDate(){
        wait.until(x ->!resultDate.getText().isEmpty());
        return resultDate.getText();
    }

    public String getResultPeriod(){
        wait.until(x -> !resultTimePeriod.getText().isEmpty());
        return resultTimePeriod.getText();
    }

    public String getResultPhone(){
        wait.until(x -> !resultPhoneError.getText().isEmpty());
        return resultPhoneError.getText();
    }

    public String getErrorDate(){
        wait.until(x -> !errorDate.getText().isEmpty());
        return errorDate.getText();
    }

    public String getErrorTime(){
        wait.until(x -> !errorTime.getText().isEmpty());
        return errorTime.getText();
    }

    public void open(){
        driver.navigate().to("http://qa.skillbox.ru/module11/practice/feedbacksingle/");
    }
}
