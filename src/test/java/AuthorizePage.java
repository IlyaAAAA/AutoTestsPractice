import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizePage {
    public SelenideElement loginText = $x("//*[@id=\"field_email\"]");
    public SelenideElement passwordText = $x("//*[@id=\"field_password\"]");
    public SelenideElement loginButton = $x("//*[@id=\"anonymPageContent\"]/div[2]/div/div[3]/form/div[5]/div[1]/input");

    public MainPage login() {
        loginText.sendKeys("89966976233");
        passwordText.sendKeys("veryhardpassword");
        loginButton.click();

//        Selenide.open("ok.ru");
        return new MainPage();
    }
}
