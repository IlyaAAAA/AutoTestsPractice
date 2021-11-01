package pages.groupsPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.groupPage.GroupPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RecommendedGroups {
    private final Logger logger = LoggerFactory.getLogger(RecommendedGroups.class);

    private static class ModalWindow {
        private static final String RECOMMENDED_GROUPS_MODAL_WINDOW_OPEN_BUTTON_LOCATOR =
                "//*[contains(@class, 'button-pro __sec __small mr-2x')]";


        public static void openGroup() {
            $x(RECOMMENDED_GROUPS_MODAL_WINDOW_OPEN_BUTTON_LOCATOR).shouldBe(Condition.visible).click();
        }

    }

    private static final String RECOMMENDED_GROUPS_LOCATOR = "//*[contains(@class, 'recommended-group')]";
    private static final String RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR = ".//*[contains(@class, 'group-join_btn') and @data-l='t,join' or text()='Вступить']";
    private static final String RECOMMENDED_GROUP_NAME_LOCATOR = ".//*[contains(@class, 'group-name-link')]";
    private static final String RECOMMENDED_GROUP_MEMBERS_LOCATOR = ".//*[contains(@class, 'friends-in-group_label')]";
    private static final String RECOMMENDED_GROUP_VISIT_LOCATOR = ".//*[contains(@data-l, 't,visit')]";

    private final ElementsCollection groups;

    public RecommendedGroups() {
        this.groups = $$x(RECOMMENDED_GROUPS_LOCATOR);
    }

    public Group clickJoinFirstGroup() {
        SelenideElement firstGroup = groups.get(0);

        SelenideElement joinButton = firstGroup.$x(RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR).shouldBe(Condition.visible);
        SelenideElement nameBlock = firstGroup.$x(RECOMMENDED_GROUP_NAME_LOCATOR).shouldBe(Condition.visible);

        String members = firstGroup.$x(RECOMMENDED_GROUP_MEMBERS_LOCATOR).shouldBe(Condition.visible).text();
        logger.info(members);

        joinButton.click();

        return new Group(nameBlock.text(), members);
    }

    public GroupPage openFirstGroup() {
        SelenideElement firstGroup = groups.get(0);

        firstGroup.$x(RECOMMENDED_GROUP_VISIT_LOCATOR).shouldBe(Condition.visible).click();
        ModalWindow.openGroup();

        return new GroupPage();
    }
}
