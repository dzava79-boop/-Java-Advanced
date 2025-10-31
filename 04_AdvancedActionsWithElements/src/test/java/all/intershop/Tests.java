package all.intershop;

import all.TestBase;
import all.intershop.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void openPhonesCategory_Success() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.hoverOverCatalog();
        page.hoverOverElectronics();
        page.goToPhones();

        //assert
        Assertions.assertEquals("ТЕЛЕФОНЫ", page.getSectionTitle(),
                "Не открылся раздел 'Телефоны'");
    }

    @Test
    public void openTabletsCategory_Success() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.hoverOverCatalog();
        page.hoverOverElectronics();
        page.goToTablets();

        //assert
        Assertions.assertEquals("ПЛАНШЕТЫ", page.getSectionTitle(),
                "Не открылся раздел 'Планшеты'");
    }

    @Test
    public void openTVCategory_Success() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.hoverOverCatalog();
        page.hoverOverElectronics();
        page.goToTV();

        //assert
        Assertions.assertEquals("ТЕЛЕВИЗОРЫ", page.getSectionTitle(),
                "Не открылся раздел 'Телевизоры'");
    }

    @Test
    public void openPhotoVideoCategory_Success() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.hoverOverCatalog();
        page.hoverOverElectronics();
        page.goToPhotoVideo();

        //assert
        Assertions.assertEquals("ФОТО/ВИДЕО", page.getSectionTitle(),
                "Не открылся раздел 'Фото/Видео'");
    }

    @Test
    public void openWatchesCategory_Success() {
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.hoverOverCatalog();
        page.hoverOverElectronics();
        page.goToWatches();

        //assert
        Assertions.assertEquals("ЧАСЫ", page.getSectionTitle(),
                "Не открылся раздел 'Часы'");
    }
}
