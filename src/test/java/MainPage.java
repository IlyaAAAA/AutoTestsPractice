import com.codeborne.selenide.SelenideElement;
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
public class MainPage extends BasePage {
    public SelenideElement openGroups() {
        SelenideElement selenideElement = $x("//*[@id=\"hook_Block_Navigation\"]/div/div/a[3]");
        String href = selenideElement.getAttribute("href");

        return GroupPage(href);
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public void open() {

    }
}
