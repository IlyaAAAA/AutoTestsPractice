package pages;

import org.junit.jupiter.api.Assertions;

public abstract class BasicPage {

    public BasicPage() {
//        Assertions.assertTrue(isLoaded());
    }

    public abstract boolean isLoaded();
}
