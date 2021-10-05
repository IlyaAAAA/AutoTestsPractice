import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class GroupTest {

    private GroupPage groupPage = new GroupPage();

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
    }

    @Test
    public void testPage() {
        AuthorizePage authorizePage = new AuthorizePage();
        authorizePage.isLoaded();

        MainPage mainPage = authorizePage.login();
        mainPage.isLoaded();

        GroupPage groupPage = mainPage.openGroups();
        groupPage.isLoaded();
    }
}
