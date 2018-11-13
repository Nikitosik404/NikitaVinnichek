package setup;

public enum PropertyFile {

    NATIVE("nativetests"),
    WEB("webtests");

    private String currentAppType;

    PropertyFile(String current) {
        this.currentAppType = current;
    }

    public String getFileName() {
        return "src\\main\\resources\\" + currentAppType + ".properties";
    }
}