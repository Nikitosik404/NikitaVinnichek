package enums.mobileAutomation;

public enum Capabilities {
    APPLICATION_PACKAGE("appPackage"),
    APPLICATION_ACTIVITY("appActivity");

    public String capName;

    Capabilities(String capability){
        this.capName = capability;
    }
}
