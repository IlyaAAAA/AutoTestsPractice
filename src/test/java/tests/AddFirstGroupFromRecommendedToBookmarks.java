package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.groups.Group;

public class AddFirstGroupFromRecommendedToBookmarks extends BasicTest {

    @Test
    public void test() {
        Group group = new MainPage()
                .openGroups()
                .getRecommendedGroups()
                .openFirstGroup()
                .addToBookmark()
                .getGroup();

        Assertions.assertTrue(openMainPage()
                .openBookmarks()
                .isGroupInBookmarks(group));
    }
}
