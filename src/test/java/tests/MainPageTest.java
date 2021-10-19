package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class MainPageTest extends BasicTest {

    @Test
    public void openMainPage() {
        Assertions.assertTrue(new MainPage().isLoaded());
    }
}
