package enums.mobile;

public enum ContactForm {
    ADD_CONTACT("Add Contact"),
    TARGET_ACCOUNT("Target Account"),
    CONTACT_NAME("Contact Name"),
    CONTACT_PHONE("Contact Phone"),
    CONTACT_EMAIL("Contact Email"),
    SELECT_LABEL("Select label"),
    BUTTON_SAVE("Save");

    public String value;

    ContactForm(String value) {
        this.value = value;
    }
}