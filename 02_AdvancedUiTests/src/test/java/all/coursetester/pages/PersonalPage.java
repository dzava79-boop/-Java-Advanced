package all.coursetester.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PersonalPage extends Page {

    @FindBy(css = ".baseTabs__header .baseTabs__link:nth-child(2)")
    public WebElement delayedCoursesTab;

    @FindBy(css = ".baseTabsItem--show .pagePersonal__card")
    public List<WebElement> courseCards;

    @FindBy(linkText = "К списку курсов")
    public WebElement backToCoursesButton;

    private WebDriver driver;

    public PersonalPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait,"personal/");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PersonalCourseElement getCourseCard(int index){
        return new PersonalCourseElement(driver, index);
    }


}
