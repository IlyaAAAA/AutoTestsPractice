package pages.mainPage;

import com.codeborne.selenide.Condition;
import pages.bookmarks.BookmarkPage;
import pages.groupsPage.GroupsPage;
import pages.notesPage.NotesPage;
import pages.profilePage.ProfilePage;

import static com.codeborne.selenide.Selenide.$x;

public class LeftNavigationBar {
    private static final String NAME_LOCATOR = "//*[@data-l='t,userPage']";
    private static final String NOTES_LOCATOR = "//*[contains(text(), 'Заметки')]";
    private static final String GROUP_LOCATOR = "//*[contains(text(), 'Группы')]";
    private static final String BOOKMARK_LOCATOR = "//*[contains(text(), 'Закладки')]";
    private static final String TOGGLER_LOCATOR = "//*[@data-l='t,toggler']";

    public boolean isLoaded() {
        $x(NAME_LOCATOR).shouldBe(Condition.visible);

        return true;
    }

    public GroupsPage openGroups() {
        $x(GROUP_LOCATOR).shouldBe(Condition.visible).click();

        return new GroupsPage();
    }

    public BookmarkPage openBookmarks() {
        $x(TOGGLER_LOCATOR).shouldBe(Condition.visible).click();
        $x(BOOKMARK_LOCATOR).shouldBe(Condition.visible).click();

        return new BookmarkPage();
    }

    public ProfilePage openProfile() {
        $x(NAME_LOCATOR).shouldBe(Condition.visible).click();

        return new ProfilePage();
    }

    public NotesPage openNotes() {
        $x(NOTES_LOCATOR).shouldBe(Condition.visible).click();

        return new NotesPage();
    }
}
