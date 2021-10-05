import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

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
