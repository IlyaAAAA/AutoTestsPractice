package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class NotesTest extends BasicTest {
    @Test
    void test() {
        Random random = new Random();

        String noteText = "HELLO!!! + " + random.nextInt(1000);

        openMainPage()
                .getLeftNavigationBar()
                .openNotes()
                .addNoteWithText(noteText);

        Assertions.assertTrue(openMainPage()
                .getLeftNavigationBar()
                .openProfile()
                .getFeed()
                .isNoteWithTextInFeed(noteText));

    }
}
