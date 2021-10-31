package pages.groups;

import com.codeborne.selenide.Condition;
import org.hamcrest.Matchers;

import static com.codeborne.selenide.Selenide.$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class GroupPage {

    private static final String GROUP_NAME_LOCATOR = "//*[contains(@class, 'group-name_t')]";
    private static final String GROUP_AVATAR_LOCATOR = "//*[contains(@class, 'group-avatar_img')]";
    private static final String SRC_ATTRIBUTE = "src";


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
}
