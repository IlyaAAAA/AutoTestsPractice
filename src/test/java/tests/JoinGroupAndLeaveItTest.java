package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.groups.Group;
import pages.groups.GroupPage;
import pages.groups.GroupsPage;
import utils.Bot;
import utils.PageOpener;

public class JoinGroupAndLeaveItTest extends BasicTest {

    private final Bot bot = new Bot();

    @Test
    void test() {
        GroupsPage groupsPage = new MainPage()
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

        Assertions.assertFalse(PageOpener.openGroups(bot)
                .getMyGroups()
                .isInMyGroups(newGroup));
    }
}
