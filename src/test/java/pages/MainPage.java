package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.groups.GroupsPage;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasicPage {
    private static final String NAME_LOCATOR = "//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]/div";
    private static final String GROUP_LOCATOR = "//*[@data-l='t,userAltGroup']";

    private final SelenideElement name = $x(NAME_LOCATOR);

    public MainPage() {
        super();
    }

//    @Override
//    protected boolean isLoaded() {
//        name.shouldBe(Condition.visible);
//
//        Assertions.assertTrue(name.exists(), "Main page was not loaded");
//        return true;
//    }

    public GroupsPage openGroups() {
        $x(GROUP_LOCATOR).shouldBe(Condition.visible).click();

        return new GroupsPage();
    }
}
