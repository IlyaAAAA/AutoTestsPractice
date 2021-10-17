package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasicPage;

import static com.codeborne.selenide.Selenide.$$;

public class RecommendedGroups extends BasicPage {

    private static final String RECOMMENDED_GROUPS_LOCATOR = "recommended-group";
    private static final String RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR = "group-join_btn";
    private static final String RECOMMENDED_GROUP_NAME_LOCATOR = "group-name-link";
    private static final String RECOMMENDED_GROUPS_MEMBERS_LOCATOR = "lp-t";

    private ElementsCollection groups;

    public RecommendedGroups() {
        this.groups = $$(By.className(RECOMMENDED_GROUPS_LOCATOR)).shouldBe();
    }

    public Group clickJoinFirstGroup() {

        SelenideElement firstGroup = groups.get(0);

        SelenideElement joinButton = firstGroup.$(By.className(RECOMMENDED_GROUP_JOIN_BUTTON_LOCATOR)).shouldBe(Condition.visible);
        SelenideElement nameBlock = firstGroup.$(By.className(RECOMMENDED_GROUP_NAME_LOCATOR)).shouldBe(Condition.visible);
        SelenideElement members = firstGroup.$(By.className(RECOMMENDED_GROUPS_MEMBERS_LOCATOR)).shouldBe(Condition.visible);

        joinButton.click();

        return new Group(nameBlock.text());
    }
}
