package pages.notesPage;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class NotesPage {
    private static final String NOTES_PAGE_ADD_NOTE_LOCATOR = "//*[contains(@class, 'pf-head_itx')]";

    private final NotesModalWindow notesModalWindow = new NotesModalWindow();

    public void addNoteWithText(String text) {
        $x(NOTES_PAGE_ADD_NOTE_LOCATOR).shouldBe(Condition.visible).click();

        notesModalWindow.shareNotes(text);
    }
}
