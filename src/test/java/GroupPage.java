import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Selenide.$x;

public class GroupPage extends LoadableComponent<GroupPage> {
    public GroupPage() {
        super();

//        Selenide.open("https://ok.ru/profile/" + UserInfo.phone + "/groups");
    }

    public GroupPage(String href) {
        Selenide.open(href);
    }


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        SelenideElement myGroupText = $x("//*[@id=\"hook_Block_PopularGroupsListBlock\"]/div/div/div[1]/div");

        myGroupText.shouldBe(Condition.exist);
        myGroupText.shouldBe(Condition.visible);
//        String text = myGroupText.shouldBe(Condition.visible).text();
        Assertions.assertTrue(myGroupText.exists());
//        Assertions.assertEquals("Актуально", text);
    }
}
