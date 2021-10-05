import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.LoadableComponent;

public class GroupPage extends LoadableComponent<GroupPage> {
    public GroupPage() {
    }

    public GroupPage(String href) {
        Selenide.open(href);
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
