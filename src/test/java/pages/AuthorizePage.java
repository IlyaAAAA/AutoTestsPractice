package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.Bot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class AuthorizePage extends LoadableComponent<AuthorizePage> {
    private SelenideElement loginText = $x("//*[@id=\"field_email\"]");
    private SelenideElement passwordText = $x("//*[@id=\"field_password\"]");
    private SelenideElement loginButton = $x("//*[@id=\"anonymPageContent\"]/div[2]/div/div[3]/form/div[5]/div[1]/input");

    public MainPage login() {
        loginText.sendKeys(Bot.phone);
        passwordText.sendKeys(Bot.password);
        loginButton.click();

        return new MainPage();
    }

    @Override
    protected void load() {
        Selenide.open("https://ok.ru/");
    }

    @Override
    public void isLoaded() throws Error {
        loginText.should(exist);
        passwordText.should(exist);
        loginButton.should(exist);
    }
}
