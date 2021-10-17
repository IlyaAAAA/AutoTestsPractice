package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;

class RecommendedGroups extends LoadableComponent<RecommendedGroups> {
    private ElementsCollection groups;

    public RecommendedGroups() {
        this.groups = Selenide.$$(By.className("recommended-group"));
    }

    @Override
    protected void load() {

    }

    @Override
    public void isLoaded() throws Error {
        groups.get(0).shouldBe(Condition.visible);
    }

    public Group clickJoinFirstGroup() {
        SelenideElement joinButton = groups.get(0).$(By.className("group-join_btn"));
        SelenideElement nameBlock = groups.get(0).$(By.className("group-name-link"));
        SelenideElement members = groups.get(0).$(By.className("lp-t"));

        joinButton.click();

        return new Group(nameBlock.text());
    }
}
