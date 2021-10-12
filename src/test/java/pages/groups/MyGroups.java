package pages.groups;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

class MyGroups {
    private ElementsCollection myGroups;

    public MyGroups() {
        this.myGroups = $$(By.className("scroll-slider_list"));
    }


    public boolean isExist(Group group) {
        for (SelenideElement myGroup : myGroups) {
            SelenideElement image = myGroup.$(By.className("photo_img"));
            String name = image.attr("alt");

            if (name.compareTo(group.name) == 0) {
                return true;
            }
        }

        return false;
    }
}
