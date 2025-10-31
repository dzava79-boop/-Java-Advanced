package all.scrolling;

import all.TestBase;
import all.scrolling.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void mainPage_scrollingInAnOnlineStore_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.scrollToSiteInfo();


        //assert
        Assertions.assertTrue(page.isScrollButtonVisible(),
                "Кнопка 'Скролл к началу' не появилась после прокрутки вниз");
    }
}
