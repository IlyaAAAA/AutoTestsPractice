package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Bot;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizePage extends BasicPage {

    private static final String LOGIN_INPUT_LOCATOR = "//*[@id='field_email']";
    private static final String PASSWORD_INPUT_LOCATOR = "//*[@id='field_password']";
    private static final String LOGIN_BUTTON_LOCATOR = "//*[@id='anonymPageContent']/div[2]/div/div[3]/form/div[5]/div[1]/input";

    private final SelenideElement loginText = $x(LOGIN_INPUT_LOCATOR);
    private final SelenideElement passwordText = $x(PASSWORD_INPUT_LOCATOR);
    private final SelenideElement loginButton = $x(LOGIN_BUTTON_LOCATOR);

    private final Bot bot;

    public AuthorizePage(Bot bot) {
        this.bot = bot;
    }

    public MainPage login() {
        loginText.shouldBe(visible).sendKeys(bot.phone);
        passwordText.shouldBe(visible).sendKeys(bot.password);
        loginButton.shouldBe(visible).click();

        return new MainPage();
    }
}
