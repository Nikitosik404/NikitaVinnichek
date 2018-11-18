package enums.mobile;

public enum PropertiesFile {

    NATIVE_ANDROID("androidNative"),
    WEB_ANDROID("androidWeb"),
    WEB_IOS("iOSWeb");

    private String name;

    PropertiesFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name + ".properties";
    }
}