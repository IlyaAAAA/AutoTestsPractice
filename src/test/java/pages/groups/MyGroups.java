package pages.groups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class MyGroups {
    private static final String MY_GROUPS_LOCATOR = "//*[@class='scroll-slider_list']";
    private static final String IMAGE_GROUP_LOCATOR = ".//*[@class='photo_img']";
    private static final String ATTRIBUTE_WITH_NAME = "alt";

    private final ElementsCollection myGroups;

    public MyGroups() {
        this.myGroups = $$x(MY_GROUPS_LOCATOR).shouldBe();
    }


    public boolean isGroupExist(Group group) {
        for (SelenideElement myGroup : myGroups) {
            SelenideElement image = myGroup.$x(IMAGE_GROUP_LOCATOR);
            String name = image.attr(ATTRIBUTE_WITH_NAME);

            if (name.compareTo(group.name) == 0) {
                return true;
            }
        }

        return false;
    }
}
