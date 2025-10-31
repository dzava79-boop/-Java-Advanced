package all.callback;

import all.TestBase;
import all.callback.pages.CallMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void callMainPage_FillForm_Success(){
        //arrange
        var page = new CallMainPage(driver, wait);
        page.open();

        //act
        page.setFromTime("09:00");
        page.setToTime("11:00");
        page.setDate("04.28.2021");
        page.phone.sendKeys("+7(900)111-22-33");
        page.callMeButton.click();

        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals("09:00-11:00", page.getResultPeriod(), "Неверный временный период у отправленной заявки на звонок"),
                () -> Assertions.assertEquals("Среда 28 апреля", page.getResultDate(), "Неверная дата у отправленной заявки на звонок")
        );
    }

    @Test
    public void callMainPage_ThePhoneNumberFieldIsEmpty_Success(){
        //arrange
        var page = new CallMainPage(driver, wait);
        page.open();

        //act
        page.setFromTime("11:00");
        page.setToTime("15:00");
        page.setDate("10.22.2025");
        page.callMeButton.click();

        //assert

        Assertions.assertEquals(page.expectedErrorTextPhoneAndDate, page.getResultPhone(), "Неверный номер телефона");
    }

    @Test
    public void callMainPage_TheDateFieldIndicatesADayOff_Success(){
        //arrange
        var page = new CallMainPage(driver, wait);
        page.open();

        //act
        page.setDate("10.11.2025");

        //assert
        Assertions.assertEquals(page.expectedErrorTextDateAndTime, page.getErrorDate(), "Дата не указана");
    }

    @Test
    public void callMainPage_TheTimeFieldIndicatesADayOff_Success(){
        //arrange
        var page = new CallMainPage(driver, wait);
        page.open();

        //act
        page.setFromTime("01:00");

        //assert
        Assertions.assertEquals(page.expectedErrorTextDateAndTime, page.getErrorTime(), "Время не указана");

    }

    @Test
    public void callMainPage_ClickingOnAButtonWithEmptyFields_Success(){
        //arrange
        var page = new CallMainPage(driver, wait);
        page.open();

        //act
        page.callMeButton.click();

        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(page.expectedErrorTextPhoneAndDate, page.getErrorDate(),"Дата не указана"),
                () -> Assertions.assertEquals(page.expectedErrorTextPhoneAndDate, page.getResultPhone(), "Неверный номер телефона")
        );
    }

}
