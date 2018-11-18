package enums.mobile;

public enum  MobileCapabiltyType {

    PLATFORM_NAME("platformName"),
    DEVICE_NAME("deviceName"),
    APP("app"),
    BROWSER_NAME("browserName"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    UDID("udid"),
    AUTO_LAUNCH("autoLaunch");

    public String value;

    MobileCapabiltyType(String value) {
        this.value = value;
    }
}
