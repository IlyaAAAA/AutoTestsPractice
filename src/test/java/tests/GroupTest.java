package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthorizePage;
import pages.groups.Group;
import pages.groups.GroupsPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class GroupTest {

    private GroupsPage groupPage = new GroupsPage();

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
    }

    @Test
    public void testPage() {
        AuthorizePage authorizePage = new AuthorizePage();
        authorizePage.isLoaded();

        MainPage mainPage = authorizePage.login();
        mainPage.isLoaded();

        GroupsPage groupsPage = mainPage.openGroups();
        groupsPage.isLoaded();

        Group group = groupsPage.joinFirstGroupFromActual();

        groupsPage.reloadPage();
        groupsPage.isLoaded();

        groupsPage.checkGroupInMyGroups(group);
    }
}
