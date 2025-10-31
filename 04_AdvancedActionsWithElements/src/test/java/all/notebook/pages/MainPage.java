package all.notebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class MainPage {
    @FindBy(css = ".pageCreate__sidebarHeaderAdd svg")
    private WebElement addNoteButton;

    @FindBy(className = "popup__content")
    private WebElement popUp;

    @FindBy(css = ".popup__content .baseInput__field")
    private WebElement headerTextInput;

    @FindBy(css = ".popup__content .baseTextarea__text")
    private WebElement mainTextInput;

    @FindBy(css = ".baseButton.popup__baseButton")
    private WebElement addNoteButtonInPopup;

    @FindBy(id = "icon_delete")
    public WebElement deleteNoteButton;

    @FindBy(css = ".articlePreview.pageCreate__articlePreview:last-of-type")
    public WebElement defaultNote;

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
        driver.navigate().to("https://qa.skillbox.ru/module15/bignotes/#/");
    }

    public void addRandomNotes(int count){
        for(int i=0; i < count; i++){
            addNoteButton.click();
            wait.until(ExpectedConditions.visibilityOf(popUp));
            headerTextInput.sendKeys(Integer.toString(i));
            mainTextInput.sendKeys(UUID.randomUUID().toString());
            addNoteButtonInPopup.click();
        }

    }

    public void deleteNote(int index){
        var noteLocator = getNoteLocator(index);
        new Actions(driver)
                .moveToElement(driver.findElement(noteLocator))
                .perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getDeleteNoteLocator(index)));
        driver.findElement(getDeleteNoteLocator(index)).click();
    }

    private By getNoteLocator(int index){
        return By.cssSelector(String.format(".articlePreview.pageCreate__articlePreview:nth-of-type(%d)", index));
    }

    private By getDeleteNoteLocator(int index){
        return By.cssSelector(String.format(".articlePreview.pageCreate__articlePreview:nth-of-type(%d) .articlePreview__button:last-of-type", index));
    }

    public void scrollToBottomInAllNotesSection(){
        new Actions(driver)
                .moveToElement(defaultNote)
                .perform();
    }

    public boolean isNoteDisplayed(int index){
        var noteLocator = getNoteLocator(index);
        var noteElement = driver.findElement(noteLocator);
        return noteElement.isDisplayed();
    }
}
