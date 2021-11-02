package pages.groupsPage;

import com.codeborne.selenide.Condition;
import pages.Reloadable;

import static com.codeborne.selenide.Selenide.$x;

public class GroupsPage implements Reloadable<GroupsPage> {
    private final static String POPULAR_GROUPS_BLOCK_LOCATOR = "//*[@id='hook_Block_PopularGroupsListBlock']";
    private final static String MY_GROUPS_BLOCK_LOCATOR = "//*[@class='groups-catalog-header_my-groups']";

    private RecommendedGroups recommendedGroups;
    private MyGroups myGroups;

    public GroupsPage() {
        recommendedGroups = new RecommendedGroups();
        myGroups = new MyGroups();
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
