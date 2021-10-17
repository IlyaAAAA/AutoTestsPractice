package tests;

import org.junit.jupiter.api.Test;
import pages.AuthorizePage;
import pages.MainPage;

public class AuthTest extends BasicTest {

    @Test
    public void login() {
        AuthorizePage authorizePage = new AuthorizePage();

        MainPage mainPage = authorizePage.login();
        mainPage.isLoaded();
    }
}
