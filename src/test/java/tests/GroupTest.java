package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.groups.Group;
import pages.groups.GroupsPage;

public class GroupTest extends BasicTest {

    @Test
    public void testPage() {
        GroupsPage groupsPage = new MainPage().openGroups();

        Group newGroup = groupsPage
                .getRecommendedGroups()
                .clickJoinFirstGroup();

        Assertions.assertTrue(groupsPage
                .reloadPage()
                .getMyGroups()
                .isGroupExist(newGroup)
        );
    }
}
