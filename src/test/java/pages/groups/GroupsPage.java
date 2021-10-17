package pages.groups;

import org.junit.jupiter.api.Assertions;
import pages.BasicPage;
import pages.Reloadable;

public class GroupsPage extends BasicPage implements Reloadable<GroupsPage> {
    private RecommendedGroups recommendedGroups;
    private MyGroups myGroups;

    public GroupsPage() {

    }

//    @Override
//    protected boolean isLoaded() {
//        SelenideElement myGroupText = $x("//*[@id=\"hook_Block_PopularGroupsListBlock\"]/div/div/div[1]/div");
//
//        myGroupText.shouldBe(Condition.visible);
//
//        //проверять isLoaded
//        recommendedGroups = new RecommendedGroups();
//        myGroups = new MyGroups();
//
//        return true;
//    }

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
