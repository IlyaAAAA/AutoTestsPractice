package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.AuthorizePage;

import static com.codeborne.selenide.Selenide.open;

public class BasicTest {
    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");

        AuthorizePage authorizePage = new AuthorizePage();
        authorizePage.login();
    }

    @AfterEach
    public void close() {
        Selenide.closeWindow();
    }

    @AfterAll
    public static void closeDriver() {
        Selenide.closeWebDriver();
    }
}
