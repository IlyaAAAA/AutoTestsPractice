import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    AuthorizePage authorizePage = new AuthorizePage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        open("https://www.ok.ru/");
    }

    @Test
    public void login() {
        authorizePage.loginText.sendKeys("89966976233");
        authorizePage.passwordText.sendKeys("veryhardpassword");
        authorizePage.loginButton.click();

        MainPage mainPage = new MainPage();
        mainPage.isLoaded();
    }
}
