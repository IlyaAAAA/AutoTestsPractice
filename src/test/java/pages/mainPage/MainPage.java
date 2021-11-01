package pages.mainPage;

public class MainPage {
    private final LeftNavigationBar leftNavigationBar = new LeftNavigationBar();

    public MainPage() {
        leftNavigationBar.isLoaded();
    }

    public LeftNavigationBar getLeftNavigationBar() {
        return leftNavigationBar;
    }
}
