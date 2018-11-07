package enums.jdi;

public enum NavigateMenu {
    HOME_PAGE("Home Page"),
    METALS_AND_COLORS("Metals & Colors");

    private String title;

    NavigateMenu(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}