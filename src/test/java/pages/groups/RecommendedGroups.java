package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$$x;

public class RecommendedGroups {
    Logger logger = LoggerFactory.getLogger(RecommendedGroups.class);
    private static final String RECOMMENDED_GROUPS_LOCATOR = "//*[contains(@class, 'recommended-group')]";
    private static final String RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR = ".//*[contains(@class, 'group-join_btn') and @data-l='t,join' or text()='Вступить']";
    private static final String RECOMMENDED_GROUP_NAME_LOCATOR = ".//*[contains(@class, 'group-name-link')]";
    private static final String RECOMMENDED_GROUP_MEMBERS_LOCATOR = ".//*[contains(@class, 'friends-in-group_label')]";
    private static final String RECOMMENDED_GROUP_IMAGE_LOCATOR = ".//*[contains(@class, 'photo_img')]";
    private static final String ATTRIBUTE_SRC_IMAGE = "src";

    private final ElementsCollection groups;

    public RecommendedGroups() {
        this.groups = $$x(RECOMMENDED_GROUPS_LOCATOR).shouldBe();
    }

    public Group clickJoinFirstGroup() {
        SelenideElement firstGroup = groups.get(0);

        SelenideElement joinButton = firstGroup.$x(RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR).shouldBe(Condition.visible);
        SelenideElement nameBlock = firstGroup.$x(RECOMMENDED_GROUP_NAME_LOCATOR).shouldBe(Condition.visible);
        SelenideElement image = firstGroup.$x(RECOMMENDED_GROUP_IMAGE_LOCATOR).shouldBe(Condition.visible);

        String members = firstGroup.$x(RECOMMENDED_GROUP_MEMBERS_LOCATOR).shouldBe(Condition.visible).text();
        logger.info(members);

        joinButton.click();

        return new Group(nameBlock.text(), members, image.getAttribute(ATTRIBUTE_SRC_IMAGE));
    }
}
