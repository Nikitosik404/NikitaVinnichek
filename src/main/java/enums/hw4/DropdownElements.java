package enums.hw4;

public enum DropdownElements {
    RED("0"),
    GREEN("1"),
    BLUE("2"),
    YELLOW("3");

    public String displayName;

    DropdownElements(String name) {
        this.displayName = name;
    }
}
