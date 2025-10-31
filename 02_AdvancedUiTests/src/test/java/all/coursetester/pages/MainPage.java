package all.coursetester.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page{
    public HeaderPanel header;

    public MainPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait, "maincatalog/");
        this.header = new HeaderPanel(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public CourseElement getCourseCard(int index){
        return new CourseElement(driver, index);
    }
}
