package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthorizePage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    AuthorizePage authorizePage = new AuthorizePage();

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
    }

    @AfterEach
    public void close() {
        Selenide.closeWindow();
    }

    @Test
    public void login() {
        MainPage mainPage = authorizePage.login();
        mainPage.isLoaded();
    }
}
