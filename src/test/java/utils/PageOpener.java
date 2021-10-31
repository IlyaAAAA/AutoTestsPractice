package utils;

import com.codeborne.selenide.Selenide;
import pages.groups.GroupsPage;

public class PageOpener {
    private PageOpener() {

    }

    public static GroupsPage openGroups(Bot bot) {
        Selenide.open("https://ok.ru/profile/" + bot.id + "/groups");

        return new GroupsPage();
    }
}
