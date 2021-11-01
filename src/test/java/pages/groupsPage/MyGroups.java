package pages.groupsPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.groupPage.GroupPage;

import static com.codeborne.selenide.Selenide.$$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class MyGroups {
    private final Logger logger = LoggerFactory.getLogger(MyGroups.class);

    private static final String MY_GROUPS_LOCATOR = "//*[@class='scroll-slider_item mr-x']";
    private static final String IMAGE_GROUP_LOCATOR = ".//*[@class='photo_img']";
    private static final String ATTRIBUTE_WITH_NAME = "alt";


    public boolean isInMyGroups(Group group) {
        logger.info("Group to find: " + group.name);

        for (SelenideElement myGroup : getMyGroups()) {
            SelenideElement image = myGroup.$x(IMAGE_GROUP_LOCATOR);
            String name = image.attr(ATTRIBUTE_WITH_NAME);

            logger.info("group in loop: " + name);

            if (name.compareTo(group.name) == 0) {
                return true;
            }
        }

        return false;
    }

    public GroupPage openGroup(Group group) {

        SelenideElement groupToClick = null;
        for (SelenideElement myGroup : getMyGroups()) {
            SelenideElement image = myGroup.$x(IMAGE_GROUP_LOCATOR);
            String name = image.attr(ATTRIBUTE_WITH_NAME);

            if (name.compareTo(group.name) == 0) {
                groupToClick = myGroup;
                break;
            }
        }

        assertThat(groupToClick, notNullValue());

        groupToClick.click();
        return new GroupPage();
    }

    private ElementsCollection getMyGroups() {
        return $$x(MY_GROUPS_LOCATOR);
    }
}
