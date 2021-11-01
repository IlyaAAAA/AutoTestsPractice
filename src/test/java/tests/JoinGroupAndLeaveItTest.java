package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.groupsPage.Group;
import pages.groupPage.GroupPage;
import pages.groupsPage.GroupsPage;
import pages.mainPage.MainPage;
import utils.Bot;

public class JoinGroupAndLeaveItTest extends BasicTest {

    private final Bot bot = new Bot();

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
