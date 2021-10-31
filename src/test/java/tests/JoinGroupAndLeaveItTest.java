package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.groups.Group;
import pages.groups.GroupPage;
import pages.groups.GroupsPage;

public class JoinGroupAndLeaveItTest extends BasicTest {

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
    }
}
