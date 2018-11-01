package enums.hw4;

public enum CheckBoxes {
    WATER("0"),
    EARTH("1"),
    WIND("2"),
    FIRE("2");

    public final String displayName;

    CheckBoxes(String name) {
        this.displayName = name;
    }
}
