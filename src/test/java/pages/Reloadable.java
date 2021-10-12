package pages;

import com.codeborne.selenide.Selenide;

public interface Reloadable {
    default void reloadPage() {
        Selenide.refresh();
    }
}
