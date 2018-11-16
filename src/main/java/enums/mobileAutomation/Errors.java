package enums.mobileAutomation;

public enum Errors {
    ERROR_IN_TYPE_OF_APP("The type of mobile app is unknown"),
    ERROR_IN_MOBILE_PLATFORM("The mobile platform is unknown");

    public String text;

    Errors(String text) {
        this.text = text;
    }
}
