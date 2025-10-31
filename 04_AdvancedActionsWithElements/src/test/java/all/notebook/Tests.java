package all.notebook;

import all.TestBase;
import all.notebook.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends TestBase {

    @Test
    public void AllNotesPage_Add10NotesAndDeleteFirst_DefaultNotesAreVisible(){
        //arrange
        var page = new MainPage(driver, wait);
        page.open();

        //act
        page.addRandomNotes(10);
        page.deleteNote(1);
        page.scrollToBottomInAllNotesSection();

        //assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(page.isNoteDisplayed(11), "Не отображается первая из базовых записей"),
                () -> Assertions.assertTrue(page.isNoteDisplayed(12), "Не отображается вторая из базовых записей")
        );
    }
}
