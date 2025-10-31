package all.coursetester.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PersonalCourseElement {

    private WebDriver driver;
    private int index;

    @FindBy(css = ".baseTabsItem--show .baseCard__title")
    private List<WebElement> titles;

    @FindBy(css = ".baseCard .baseCard__label")
    private List<WebElement> startDates;

    @FindBy(css = ".baseCard .baseCondition:nth-of-type(1)")
    private List<WebElement> videoCounts;

    @FindBy(css = ".baseCard .baseCondition:nth-of-type(2)")
    private List<WebElement> lessonsCounts;

    @FindBy(css = ".baseCard .baseCondition:nth-of-type(3)")
    private List<WebElement> durations;

    public PersonalCourseElement(WebDriver driver, int index) {
        this.driver = driver;
        this.index = index;
        PageFactory.initElements(driver, this);
    }

    public String getStartDate() {
        return startDates.get(index).getText();
    }
    public String getTitle() {
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
}
