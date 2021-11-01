package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.groupsPage.Group;
import pages.mainPage.MainPage;

public class AddFirstGroupFromRecommendedToBookmarks extends BasicTest {

    @Test
    public void test() {
        Group group = new MainPage()
                .getLeftNavigationBar()
                .openGroups()
                .getRecommendedGroups()
                .openFirstGroup()
                .addToBookmark()
                .getGroup();

        Assertions.assertTrue(openMainPage()
                .getLeftNavigationBar()
                .openBookmarks()
                .isGroupInBookmarks(group));
    }
}
