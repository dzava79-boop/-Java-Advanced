import intershop.pages.LoyaltyProgramPage;
import org.junit.Assert;
import org.junit.Test;

public class LoyaltyProgramPageTest extends TestBase{
    private String messageForWrongResultText = "Неверный заголовок при успешном оформлении карты";
    private String messageForInvisibleResultText = "Не отобразился заголовок при успешном оформлении карты";
    private String expectedSuccessResultMessage = "Ваша карта оформлена!";
    private String expectedNameResultMessage = "Поле \"Имя\" обязательно для заполнения";
    private String expectedPhoneResultMessage = "Поле \"Телефон\" обязательно для заполнения";

    @Test
    public void loyaltyProgramPage_FillFormWithPhoneWith8_Success() {
        //arrange
        var page = new LoyaltyProgramPage(driver);
        page.open();

        //act
        page.name.sendKeys("Вася");
        page.phone.sendKeys("89001112233");
        page.getCard.click();

        //assert
        Assert.assertTrue(messageForInvisibleResultText, page.isSuccessResultMessageDisplayed());
        Assert.assertEquals(messageForWrongResultText, expectedSuccessResultMessage, page.getSuccessResultMessage());
    }

    @Test
    public void loyaltyProgramPage_FillFormWithPlus7_Success() {
        //arrange
        var page = new LoyaltyProgramPage(driver);
        page.open();

        //act
        page.name.sendKeys("Vasya");
        page.phone.sendKeys("+79003335588");
        page.getCard.click();

        //assert
        Assert.assertTrue(messageForInvisibleResultText, page.isSuccessResultMessageDisplayed());
        Assert.assertEquals(messageForWrongResultText, expectedSuccessResultMessage, page.getSuccessResultMessage());
    }

    @Test
    public void loyaltyProgramPage_FillOutTheFormWithoutPassword() {
        //arrange
        var page = new LoyaltyProgramPage(driver);
        page.open();

        //act
        page.name.sendKeys("Vasya");
        page.getCard.click();

        //assert
        Assert.assertTrue(messageForInvisibleResultText, page.isMessageIsDisplayedIndicatingThatTheFieldMustBeFilledIn());
        Assert.assertEquals(messageForWrongResultText, expectedPhoneResultMessage, page.getMessageIsDisplayedIndicatingThatTheFieldMustBeFilledIn());
    }

    @Test
    public void loyaltyProgramPage_FillOutTheFormWithoutName() {
        //arrange
        var page = new LoyaltyProgramPage(driver);
        page.open();

        //act
        page.phone.sendKeys("+79003335588");
        page.getCard.click();

        //assert
        Assert.assertTrue(messageForInvisibleResultText, page.isMessageIsDisplayedIndicatingThatTheFieldMustBeFilledIn());
        Assert.assertEquals(messageForWrongResultText, expectedNameResultMessage, page.getMessageIsDisplayedIndicatingThatTheFieldMustBeFilledIn());
    }

    @Test
    public void loyaltyProgramPage_FillOutTheFormWithoutNameAndPhone() {
        //arrange
        var page = new LoyaltyProgramPage(driver);
        page.open();

        //act
        page.getCard.click();

        //assert
        Assert.assertTrue(messageForInvisibleResultText, page.isMessageIsDisplayedIndicatingThatTheFieldMustBeFilledIn());
    }

}
