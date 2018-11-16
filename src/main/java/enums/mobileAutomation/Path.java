package enums.mobileAutomation;

public enum Path {
    PATH_TO_RESOURCES("./src/main/resources/"),
    HTTPS_PREFIX("https://");

    public String value;

    Path(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
