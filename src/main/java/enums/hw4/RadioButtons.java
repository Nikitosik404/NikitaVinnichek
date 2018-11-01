package enums.hw4;

public enum  RadioButtons {
    GOLD("0"),
    SILVER("1"),
    BRONZE("2"),
    SELEN("3");

    public final String displayName;

    RadioButtons(String name){
        this.displayName = name;
    }
}
