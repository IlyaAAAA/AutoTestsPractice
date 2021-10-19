package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import pages.groups.GroupsPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasicPage {
    private static final String NAME_LOCATOR = "//*[@data-l='t,userPage']";
    private static final String GROUP_LOCATOR = "//*[@data-l='t,userAltGroup']";
    private static final String GROUP_TEXT_LOCATOR = "child::*[@class='tico null']";
    private static final String LEFT_NAVIGATION_BAR_LOCATOR = "//*[@class='nav-side __navigation __user-main']";

    private final SelenideElement name = $x(LEFT_NAVIGATION_BAR_LOCATOR);

    public MainPage() {
        super();
    }

    @Override
    public boolean isLoaded() {
        name.shouldBe(Condition.visible);

        Assertions.assertTrue(name.exists(), "Main page was not loaded");
        return true;
    }

    public GroupsPage openGroups() {
        name.shouldBe(Condition.visible);
        $x(NAME_LOCATOR).shouldBe(Condition.visible);
        SelenideElement group = $x(GROUP_LOCATOR).shouldBe(Condition.visible);

        String groupText = group.$x(GROUP_TEXT_LOCATOR).text();
        Assertions.assertEquals(groupText, "Группы");

        group.click();

        return new GroupsPage();
    }
}
