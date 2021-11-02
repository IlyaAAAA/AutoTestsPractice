package pages.groupsPage;

import pages.Reloadable;

public class GroupsPage implements Reloadable<GroupsPage> {
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
