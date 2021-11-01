package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.mainPage.MainPage;
import pages.groupsPage.Group;
import pages.groupsPage.GroupsPage;

public class JoinFirstGroupTest extends BasicTest {

    @Test
    public void testPage() {
        GroupsPage groupsPage = new MainPage()
                .getLeftNavigationBar()
                .openGroups();

        Group newGroup = groupsPage
                .getRecommendedGroups()
                .clickJoinFirstGroup();

        Assertions.assertTrue(groupsPage
                .reloadPage()
                .getMyGroups()
                .isInMyGroups(newGroup)
        );
    }
}
