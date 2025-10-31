package all.intershop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(id = "menu-item-46")
    private WebElement catalogMenu;

    @FindBy(id = "menu-item-47")
    private WebElement electronicsSubMenu;

    @FindBy(id = "menu-item-114")
    private WebElement phonesItem;

    @FindBy(id = "menu-item-116")
    private WebElement tabletsItem;

    @FindBy(id = "menu-item-118")
    private WebElement tvItem;

    @FindBy(id = "menu-item-117")
    private WebElement photoVideoItem;

    @FindBy(id = "menu-item-115")
    private WebElement watchesItem;

    @FindBy(className = "entry-title")
    private WebElement sectionTitle;

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;


    public MainPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void open(){
        driver.navigate().to("https://intershop5.skillbox.ru/");
    }

    public void hoverOverCatalog() {
        actions
                .moveToElement(catalogMenu)
                .perform();
        wait.until(ExpectedConditions.visibilityOf(electronicsSubMenu));
    }

    public void hoverOverElectronics() {
        actions
                .moveToElement(electronicsSubMenu)
                .perform();
    }

    public void clickSubItem(WebElement subItem) {
        wait.until(ExpectedConditions.elementToBeClickable(subItem)).click();
    }

    public String getSectionTitle() {
        wait.until(ExpectedConditions.visibilityOf(sectionTitle));
        return sectionTitle.getText().trim();
    }

    public void goToPhones() { clickSubItem(phonesItem); }
    public void goToTablets() { clickSubItem(tabletsItem); }
    public void goToTV() { clickSubItem(tvItem); }
    public void goToPhotoVideo() { clickSubItem(photoVideoItem); }
    public void goToWatches() { clickSubItem(watchesItem); }



}
