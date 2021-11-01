package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.mainPage.MainPage;

public class MainPageTest extends BasicTest {

    @Test
    public void openMainPageTest() {
        Assertions.assertTrue(new MainPage()
                .getLeftNavigationBar()
                .isLoaded()
        );
    }
}
