package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthorizePage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    AuthorizePage authorizePage = new AuthorizePage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
        authorizePage.login();
    }

    @AfterEach
    public void close() {
        Selenide.closeWindow();
    }

    @Test
    public void login() {
        MainPage mainPage = new MainPage();
        mainPage.isLoaded();
    }
}
