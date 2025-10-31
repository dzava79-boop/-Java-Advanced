package all.thenoteswebsite;

import all.TestBase;
import all.thenoteswebsite.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void mainPage_SettingTheDateForNotes_Success(){
        //arrange
        var page = new MainPage(driver);
        page.open();
        var initialDate = page.getDate();

        //act
        page.setDate("01/02/2022");

        //assert
        Assertions.assertEquals(initialDate, page.getDate(), "Не изменилась дата после проставления");
    }
}
