package all.balabol;

import all.TestBase;
import all.balabol.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {
    @Test
    public void mainPage_uploadFile_Failure(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        var filePath = System.getProperty("user.dir") + "\\src\\test\\java\\all\\balabol\\proverka_tcveta.jpg";
        page.uploadInput.sendKeys(filePath);

        //assert
        Assertions.assertTrue(page.errorDownload.isDisplayed(), "Файл успешно загружен");
    }

}
