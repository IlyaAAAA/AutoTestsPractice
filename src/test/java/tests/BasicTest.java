package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.AuthorizePage;
import utils.Bot;

import static com.codeborne.selenide.Selenide.open;

public class BasicTest {

    private static final String MAIN_URL = "https://www.ok.ru/";

    @BeforeEach
    public void setUp() {
        open(MAIN_URL);

        AuthorizePage authorizePage = new AuthorizePage(new Bot());
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
