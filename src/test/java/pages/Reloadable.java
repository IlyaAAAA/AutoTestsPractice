package pages;

import com.codeborne.selenide.Selenide;

public interface Reloadable<T> {
    default T reloadPage() {
        Selenide.refresh();

        return null;
    }
}
