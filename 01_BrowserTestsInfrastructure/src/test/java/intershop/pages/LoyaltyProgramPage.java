package intershop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoyaltyProgramPage extends Page{
    private String url = "https://intershop6.skillbox.ru/bonus/";

    @FindBy(id = "bonus_username")
    public WebElement name;

    @FindBy(id = "bonus_phone")
    public WebElement phone;

    @FindBy(name = "bonus")
    public WebElement getCard;

    @FindBy(css = "#bonus_main h3")
    public WebElement successResultMessage;

    @FindBy(id = "bonus_content")
    public WebElement entryError;

    public LoyaltyProgramPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoyaltyProgramPage open() {
        driver.navigate().to(url);
        return this;
    }

    public String getSuccessResultMessage() {
        return successResultMessage.getText();
    }

    public Boolean isSuccessResultMessageDisplayed() {
        return successResultMessage.isDisplayed();
    }

    public Boolean isMessageIsDisplayedIndicatingThatTheFieldMustBeFilledIn() {
        return entryError.isDisplayed();
    }

    public String getMessageIsDisplayedIndicatingThatTheFieldMustBeFilledIn() {
        return entryError.getText();
    }

}
