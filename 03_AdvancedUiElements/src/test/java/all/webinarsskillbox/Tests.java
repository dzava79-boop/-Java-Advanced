package all.webinarsskillbox;

import all.TestBase;
import all.webinarsskillbox.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tests extends TestBase {

    @Test
    public void mainPage_OpeningAndClosingTheCatalogButton_Success(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.catalogButton.click();
        page.catalogButton.click();

        //assert
        Assertions.assertTrue(page.lightBox.isDisplayed(),"Не закрылся лайт бокс");
    }

    @Test
    public void mainPage_CatalogButtonOpensLightbox_Success() {
        // arrange
        var page = new MainPage(driver, wait);
        page.open();

        // act
        page.catalogButton.click();

        // assert
        Assertions.assertTrue(page.lightBox.isDisplayed(), "Лайтбокс каталога не открылся после нажатия на кнопку 'Каталог'");
    }
    @Test
    public void mainPage_SearchReturnsResults_Success() {
        // arrange
        var page = new MainPage(driver, wait);
        page.open();

        // act
        page.catalogButton.click();
        page.search.sendKeys("Маркетинг" + Keys.ENTER);

        // assert
        wait.until(ExpectedConditions.invisibilityOf(page.resultSearch));
        Assertions.assertTrue(page.isSuccessResultSearchDisplayed(), "После выполнения поиска результаты не отображаются");
    }
}
