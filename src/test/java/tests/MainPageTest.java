package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPageTest extends BasicTest {

    @Test
    public void login() {
        MainPage mainPage = new MainPage();
        mainPage.isLoaded();
    }
}
