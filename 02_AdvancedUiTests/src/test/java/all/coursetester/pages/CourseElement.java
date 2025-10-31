package all.coursetester.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CourseElement {
    @FindBy(className = "popup__button")
    private WebElement popUpButton;

    @FindBy(css = ".baseCard .baseCard__label")
    private List<WebElement> startDates;

    @FindBy(css = ".baseCard .baseCard__title")
    private List<WebElement> titles;

    @FindBy(css = ".baseCard .baseCondition:nth-of-type(1)")
    private List<WebElement> videoCounts;

    @FindBy(css = ".baseCard .baseCondition:nth-of-type(2)")
    private List<WebElement> lessonsCounts;

    @FindBy(css = ".baseCard .baseCondition:nth-of-type(3)")
    private List<WebElement> durations;

    @FindBy(css = ".baseCard .baseButton:nth-child(1)")
    private List<WebElement> addButtons;

    @FindBy(css = ".baseCard .baseButton:nth-child(2)")
    private List<WebElement> detailsButton;

    private WebDriver driver;
    private int index;

    public CourseElement(WebDriver driver, int index){
        this.driver = driver;
        this.index = index;
        PageFactory.initElements(driver, this);
    }

    public String getStartDate() {
        return startDates.get(index).getText();
    }
    public String getTitles() {
        return titles.get(index).getText();
    }
    public String getVideosCount() {
        return videoCounts.get(index).getText();
    }
    public String getLessonsCount() {
        return lessonsCounts.get(index).getText();
    }
    public String getDuration() {
        return durations.get(index).getText();
    }
    public void add() {
        addButtons.get(index).click();
        popUpButton.click();
    }
    public void details() {
        detailsButton.get(index).click();
    }
}
