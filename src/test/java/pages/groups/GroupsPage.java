package pages.groups;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import pages.BasicPage;
import pages.Reloadable;

import static com.codeborne.selenide.Selenide.$x;

public class GroupsPage extends BasicPage implements Reloadable<GroupsPage> {
    private RecommendedGroups recommendedGroups;
    private MyGroups myGroups;

    public GroupsPage() {
        Assertions.assertTrue(isLoaded());
    }

    private boolean isLoaded() {
        $x("//*[@id=\"hook_Block_PopularGroupsListBlock\"]/div/div/div[1]/div").shouldBe(Condition.visible);

        recommendedGroups = new RecommendedGroups();
        myGroups = new MyGroups();

        return true;
    }

    @Override
    public GroupsPage reloadPage() {
        Reloadable.super.reloadPage();

        recommendedGroups = new RecommendedGroups();
        myGroups = new MyGroups();

        return this;
    }

    public RecommendedGroups getRecommendedGroups() {
        return recommendedGroups;
    }

    public MyGroups getMyGroups() {
        return myGroups;
    }
}
