import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends LoadableComponent<MainPage> {
    private final SelenideElement name = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]/div");

    public MainPage() {
    }

    @Override
    protected void load() {
        Selenide.open("https://ok.ru/");
    }

    @Override
    protected void isLoaded() throws Error {
        name.should(Condition.exist);
        name.should(Condition.visible);

        Assertions.assertTrue(name.exists(), "Main page was not loaded");
    }

    public GroupPage openGroups() {
        SelenideElement selenideElement = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/a[3]");
        selenideElement.click();

        return new GroupPage();
    }
}
