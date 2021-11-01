package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.groupPage.GroupPage;
import pages.groupsPage.Group;
import pages.groupsPage.GroupsPage;
import pages.mainPage.MainPage;

public class JoinGroupAndLeaveItTest extends BasicTest {
    @Test
    void test() {
        GroupsPage groupsPage = new MainPage()
                .getLeftNavigationBar()
                .openGroups();

        Group newGroup = groupsPage
                .getRecommendedGroups()
                .clickJoinFirstGroup();

        groupsPage.reloadPage();

        GroupPage groupPage = groupsPage
                .getMyGroups()
                .openGroup(newGroup);

        Assertions.assertTrue(groupPage.checkGroup(newGroup));

        groupPage.leave();

        Assertions.assertFalse(openMainPage()
                .getLeftNavigationBar()
                .openGroups()
                .getMyGroups()
                .isInMyGroups(newGroup));
    }
}
