import com.codeborne.selenide.Selenide;

public class GroupPage extends BasePage {

    public GroupPage(String href) {
        Selenide.open(href);
    }



    @Override
    public boolean isLoaded() {
        return false;
    }
}
