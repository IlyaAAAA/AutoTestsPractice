package tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.groupPage.GroupPage;
import pages.groupsPage.Group;
import pages.groupsPage.GroupsPage;
import pages.mainPage.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class JoinGroupAndLeaveItTest extends BasicTest {
    @Test
    void test() {
        GroupsPage groupsPage = new MainPage()
                .getLeftNavigationBar()
                .openGroups();

        int groupsNumberBeforeJoin = groupsPage
                .getMyGroups()
                .getGroupsNumber();

        Group newGroup = groupsPage
                .getRecommendedGroups()
                .clickJoinFirstGroup();

        groupsPage.reloadPage();

        int groupsNumberAfterJoin = groupsPage
                .getMyGroups()
                .getGroupsNumber();

        GroupPage groupPage = groupsPage
                .getMyGroups()
                .openGroup(newGroup);

        Assertions.assertTrue(groupPage.isGroupEquals(newGroup));

        groupPage.leave();

        int groupsNumberAfterLeave = openMainPage()
                .getLeftNavigationBar()
                .openGroups()
                .getMyGroups()
                .getGroupsNumber();

//        Assertions.assertFalse(openMainPage()
//                .getLeftNavigationBar()
//                .openGroups()
//                .getMyGroups()
//                .isInMyGroups(newGroup));

        assertThat(groupsNumberBeforeJoin, Matchers.lessThan(groupsNumberAfterJoin));
        assertThat(groupsNumberAfterLeave, Matchers.lessThan(groupsNumberAfterJoin));
        assertThat(groupsNumberBeforeJoin, Matchers.comparesEqualTo(groupsNumberAfterLeave));

    }
}
