import com.codeborne.selenide.SelenideElement;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends LoadableComponent<MainPage> {
    public SelenideElement name = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/a[1]/div");

    public MainPage() {
        super();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertTrue(name.exists(), "Main page was not loaded");
    }

    public GroupPage openGroups() {
        SelenideElement selenideElement = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/a[3]");
        selenideElement.click();

        return new GroupPage();
    }
}
