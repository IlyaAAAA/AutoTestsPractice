package pages.groupsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.groupPage.GroupPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class MyGroups {
    private final Logger logger = LoggerFactory.getLogger(MyGroups.class);

    private static final String MY_GROUPS_LOCATOR = "//*[@class='scroll-slider_item mr-x']";
    private static final String MY_GROUPS_NUMBER_LOCATOR = "//*[@class='portlet_h_count']";
    private static final String MY_LIST_GROUPS_LOCATOR = "//*[@class='scroll-slider_list']";
    private static final String IMAGE_GROUP_LOCATOR = ".//*[@class='photo_img']";
    private static final String ATTRIBUTE_WITH_NAME = "alt";
    private static final String HOVER_GROUP_NAME = "//*[contains(@class, 'entity-shortcut-menu_name')]";


    public boolean isInMyGroups(Group group) {
        logger.info("Group to find: " + group.name);

        for (SelenideElement myGroup : getMyGroups()) {
            myGroup.shouldBe(Condition.visible).hover();
            String name = $x(HOVER_GROUP_NAME).shouldBe(Condition.visible).text();

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
            myGroup.shouldBe(Condition.visible).hover();
            String name = $x(HOVER_GROUP_NAME).shouldBe(Condition.visible).text();

            if (name.compareTo(group.name) == 0) {
                groupToClick = myGroup;
                break;
            }
        }

        assertThat(groupToClick, notNullValue());

        groupToClick.click();
        return new GroupPage();
    }

    public int getGroupsNumber() {
        String strNumber = $x(MY_GROUPS_NUMBER_LOCATOR).shouldBe(Condition.visible).text();

        return Integer.parseInt(strNumber);
    }

    private ElementsCollection getMyGroups() {
        $x(MY_LIST_GROUPS_LOCATOR).shouldBe(Condition.visible);

        return $$x(MY_GROUPS_LOCATOR);
    }
}
