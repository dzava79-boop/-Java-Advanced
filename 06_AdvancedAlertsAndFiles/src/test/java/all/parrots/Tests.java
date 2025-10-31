package all.parrots;

import all.TestBase;
import all.parrots.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tests extends TestBase {
    @Test
    public void mainPage_changeEmail_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        var email = "test@mail.ru";
        page.switchToFrame();
        page.email.sendKeys(email);
        page.button.click();

        //act
        page.anotherEmailLink.click();
        var alert = driver.switchTo().alert();
        var newEmail = "new@email.com";
        alert.sendKeys(newEmail);
        alert.accept();

        //assert
        var newAlert = driver.switchTo().alert();
        var expectedText = "E-mail успешно изменён на " + newEmail;
        var actualText = newAlert.getText();
        Assertions.assertEquals(expectedText, actualText, "E-mail изменился на неверный");
    }

    @Test
    public void mainPage_cancelingAnEmailChange_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        var email = "skillbox@mail.ru";
        page.switchToFrame();
        page.email.sendKeys(email);
        page.button.click();

        //act
        page.anotherEmailLink.click();
        var alert = driver.switchTo().alert();
        alert.dismiss();

        //assert
        String emailValue = page.email.getAttribute("value");
        Assertions.assertAll(
                () -> Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("anotherEmail"))),
                        "Ссылка 'Указать другой email' должна исчезнуть после отмены"),
                () -> Assertions.assertTrue(emailValue.isEmpty(), "Поле e-mail должно быть пустым после отмены")
        );
    }

    @Test
    public void mainPage_checkingTheAlertText_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();
        var email = "skillbox@mail.ru";
        page.switchToFrame();
        page.email.sendKeys(email);
        page.button.click();

        //act
        page.anotherEmailLink.click();
        var alert = driver.switchTo().alert();

        //assert
        var expectedText = "Укажите другой e-mail";
        Assertions.assertEquals(expectedText, alert.getText(), "Текст в alert должен быть 'Укажите другой email'");
        alert.dismiss();
    }
}

