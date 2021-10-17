package pages.groups;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.Reloadable;
import utils.Bot;

import static com.codeborne.selenide.Selenide.$x;

public class GroupsPage extends LoadableComponent<GroupsPage> implements Reloadable {
    private RecommendedGroups recommendedGroups;
    private MyGroups myGroups;

    public GroupsPage() {
    }

    @Override
    protected void load() {
        Selenide.open("https://ok.ru/profile/" + Bot.id + "/groups");
    }

    @Override
    public void isLoaded() throws Error {
        SelenideElement myGroupText = $x("//*[@id=\"hook_Block_PopularGroupsListBlock\"]/div/div/div[1]/div");

        myGroupText.shouldBe(Condition.visible);

        //проверять isLoaded
        recommendedGroups = new RecommendedGroups();
        myGroups = new MyGroups();
    }

    @Override
    public void reloadPage() {
        Reloadable.super.reloadPage();

        recommendedGroups = new RecommendedGroups();
        myGroups = new MyGroups();
    }

    //
    public Group joinFirstGroupFromActual() {
        Group group = recommendedGroups.clickJoinFirstGroup();

        return group;
    }
//не работаем сдругими пейдждами в рамках одного пейджа
    public void checkGroupInMyGroups(Group group) {
        boolean isExist = myGroups.isExist(group);

        Assertions.assertTrue(isExist);
    }
}
