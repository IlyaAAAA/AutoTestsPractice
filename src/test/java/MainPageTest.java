import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void login() {
        authorizePage.loginText.sendKeys(UserInfo.phone);
        authorizePage.passwordText.sendKeys(UserInfo.password);
        authorizePage.loginButton.click();

        MainPage mainPage = new MainPage();
        mainPage.isLoaded();
    }
}
