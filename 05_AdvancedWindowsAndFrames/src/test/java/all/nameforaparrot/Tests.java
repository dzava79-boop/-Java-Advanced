package all.nameforaparrot;

import all.TestBase;
import all.nameforaparrot.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {
    @Test
    public void mainPage_FormSubmission_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        var email = "skillbox@test.ru";
        page.email.sendKeys(email);
        page.button.click();

        //assert
        Assertions.assertTrue(page.getResultText(), "Не отобразился текс отправки имени");
    }

    @Test
    public void mainPage_IncorrectEmail_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        page.email.sendKeys("skillbox@test");
        page.button.click();

        //assert
        Assertions.assertTrue(page.getErrorText(), "Не отобразился текст о неверном e-mail");
    }

    @Test
    public void mainPage_withoutEnteringEmail_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        page.button.click();

        //assert
        Assertions.assertTrue(page.getErrorText(), "Не отобразился текст о неверном e-mail");
    }

    @Test
    public void mainPage_SubmittingAFormInRussian_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        var email = "скиллбокс@test.ru";
        page.email.sendKeys(email);
        page.button.click();

        //assert
        Assertions.assertTrue(page.getResultText(), "Не отобразился текс отправки имени");
    }

    @Test
    public void mainPage_SubmittingAFormInRussianWithASpace_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        var email = "скиллбокс @test.ru";
        page.email.sendKeys(email);
        page.button.click();

        //assert
        Assertions.assertTrue(page.getResultText(), "Не отобразился текс отправки имени");
    }

    @Test
    public void mainPage_clickOnVkontakteLink_WasOpenedNewWindow(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        page.switchToFrame();
        page.VkontakteLink.click();

        //assert
        Assertions.assertEquals(2, getAllWindows().size(), "Не открылось новое окно после клика");
    }

    @Test
    public void mainPage_GoToVkontakteAndClose_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        page.switchToFrame();
        page.switchToFrame();
        page.skillboxlink.click();
        switchToFirstNewWindow();

        //act
        driver.close();
        switchToWindow(initialWindow);

        //assert
         Assertions.assertEquals(1, getAllWindows().size(), "После закрытия окна Skillbox кол-во окон осталось неверным");

    }

    @Test
    public void mainPage_sendEmail_HeaderIsVisible(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        var email = "test@skillbox.ru";
        page.email.sendKeys(email);
        page.button.click();
        page.switchToMainPage();

        //assert
        Assertions.assertTrue(page.header.isDisplayed(), "Не отображается хэдер страницы после заполнения формы");
    }

    @Test
    public void mainPage_CheckingTheErrorDisplay_AfterClosingTheNewWindow(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.switchToFrame();
        page.button.click();
        page.switchToFrame();
        page.skillboxlink.click();
        page.switchToParentFrame();

        //assert
        Assertions.assertTrue(page.getErrorText(), "Не отобразился текст о неверном e-mail");
    }
}
