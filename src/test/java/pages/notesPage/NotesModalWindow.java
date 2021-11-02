package pages.notesPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NotesModalWindow {
    //Большой локатор, но иначе не ищется div, куда вводится текст
    private static final String NOTES_MODAL_WINDOW_TEXTBOX_LOCATOR = "//*[contains(@class, 'posting_itx emoji-tx h-mod js-ok-e js-posting-itx ok-posting-handler')]";
    private static final String NOTES_MODAL_WINDOW_SUBMIT_BUTTON_LOCATOR = "//*[contains(@class, 'posting_submit')]";


    public void shareNotes(String text) {
        SelenideElement textBox = $x(NOTES_MODAL_WINDOW_TEXTBOX_LOCATOR).shouldBe(Condition.visible);
        textBox.click();
        textBox.sendKeys(text);

        $x(NOTES_MODAL_WINDOW_SUBMIT_BUTTON_LOCATOR).shouldBe(Condition.visible).click();
    }
}
