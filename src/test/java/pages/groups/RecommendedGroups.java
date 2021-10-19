package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class RecommendedGroups {
    private static final String RECOMMENDED_GROUPS_LOCATOR = "//*[contains(@class, 'recommended-group')]";
    private static final String RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR = ".//*[contains(@class, 'group-join_btn') and @data-l='t,join' or text()='Вступить']";
    private static final String RECOMMENDED_GROUP_NAME_LOCATOR = ".//*[contains(@class, 'group-name-link')]";

    private final ElementsCollection groups;

    public RecommendedGroups() {
        this.groups = $$x(RECOMMENDED_GROUPS_LOCATOR).shouldBe();
    }

    public Group clickJoinFirstGroup() {
        SelenideElement firstGroup = groups.get(0);

        SelenideElement joinButton = firstGroup.$x(RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR).shouldBe(Condition.visible);
        SelenideElement nameBlock = firstGroup.$x(RECOMMENDED_GROUP_NAME_LOCATOR).shouldBe(Condition.visible);

        joinButton.click();

        return new Group(nameBlock.text());
    }
}
