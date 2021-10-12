package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthorizePage;
import pages.MainPage;
import pages.groups.Group;
import pages.groups.GroupsPage;

import static com.codeborne.selenide.Selenide.open;

public class GroupTest {

    private GroupsPage groupPage = new GroupsPage();
    private AuthorizePage authorizePage = new AuthorizePage();

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
        authorizePage.login();
    }

    @AfterEach
    public void close() {
        Selenide.closeWindow();
    }

    @Test
    public void testPage() {
        MainPage mainPage = new MainPage();
        mainPage.isLoaded();

        GroupsPage groupsPage = mainPage.openGroups();
        groupsPage.isLoaded();

        Group group = groupsPage.joinFirstGroupFromActual();

        groupsPage.reloadPage();
        groupsPage.isLoaded();

        groupsPage.checkGroupInMyGroups(group);
    }
}
