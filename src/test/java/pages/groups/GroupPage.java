package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.hamcrest.Matchers;
import pages.Reloadable;

import static com.codeborne.selenide.Selenide.$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class GroupPage implements Reloadable<GroupsPage> {

    private static final String GROUP_NAME_LOCATOR = "//*[contains(@class, 'group-name_t')]";
    private static final String GROUP_DROPDOWN_BUTTON_LOCATOR = "//*[contains(@class, 'dropdown_ac button-pro __with-arrow __arrow-svg __sec __wide')]";
    private static final String GROUP_DROPDOWN_LEAVE_BUTTON_LOCATOR = "//*[contains(@class, 'dropdown_n')]";
    private static final String GROUP_ENTER_BUTTON_LOCATOR = "//*[contains(@class, 'button-pro __wide')]";
    private static final String GROUP_AVATAR_LOCATOR = "//*[contains(@class, 'group-avatar_img')]";
    private static final String SRC_ATTRIBUTE = "src";
    private static final String IN_GROUP_TEXT = "В группе";
    private static final String ENTER_IN_GROUP_TEXT = "Вступить";


    public boolean checkGroup(Group newGroup) {

        String name = $x(GROUP_NAME_LOCATOR).shouldBe(Condition.visible).text();
//        String members = $x(RECOMMENDED_GROUPS_LOCATOR).shouldBe(Condition.visible).text();
//        String avatarUrl = $x(GROUP_AVATAR_LOCATOR).shouldBe(Condition.visible).getAttribute(SRC_ATTRIBUTE);

        assertThat(newGroup.name, equalToIgnoringCase(name));
//        assertThat(newGroup.members, equalToIgnoringCase());
//        assertThat(avatarUrl, Matchers.notNullValue());
//        assertThat(newGroup.avatarUrl, equalToIgnoringCase(avatarUrl));

        return true;
    }

    public void leave() {
        SelenideElement dropdown = $x(GROUP_DROPDOWN_BUTTON_LOCATOR).shouldBe(Condition.visible);
        String textInGroup = dropdown.text();

        assertThat(textInGroup, Matchers.equalToIgnoringCase(IN_GROUP_TEXT));

        dropdown.click();

        $x(GROUP_DROPDOWN_LEAVE_BUTTON_LOCATOR).shouldBe(Condition.visible).click();

        reloadPage();

        String enterText = $x(GROUP_ENTER_BUTTON_LOCATOR).shouldBe(Condition.visible).text();

        assertThat(enterText, Matchers.equalToIgnoringCase(ENTER_IN_GROUP_TEXT));
    }
}
