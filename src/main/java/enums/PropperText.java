package enums;

public enum PropperText {
    PRACTICE("To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM("To be flexible and\ncustomizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026");

    public String text;

    PropperText(String text) {
        this.text = text;
    }
}
