package tests;

import org.junit.jupiter.api.Test;
import pages.AuthorizePage;
import pages.MainPage;
import pages.groups.Group;
import pages.groups.GroupsPage;

public class GroupTest extends BasicTest {

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
