package pages.profilePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Feed {
    private static final String FEED_GROUP_FILTER_LOCATOR = "//*[contains(text(), 'Заметки')]";
    private static final String FEED_NOTE_TEXT_LOCATOR = ".//*[contains(@class, 'media-text_cnt_tx')]";


    public boolean isNoteWithTextInFeed(String text) {
        clickFilterNote();

        ElementsCollection notes = $$x(FEED_NOTE_TEXT_LOCATOR).shouldBe();

        for (SelenideElement note : notes) {
            String noteText = note.text();

            if (noteText.compareTo(text) == 0) {
                return true;
            }
        }

        return false;
    }

    private void clickFilterNote() {
        $x(FEED_GROUP_FILTER_LOCATOR).shouldBe(Condition.visible).click();
    }
}
