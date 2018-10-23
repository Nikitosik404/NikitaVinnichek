package enums;

public enum ProperText {
    ProperText("To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable",
                        "To be multiplatform",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026");
    public String PRACTICE;
    public String CUSTOM;
    public String MULTI;
    public String BASE;

    ProperText(String PRACTICE, String CUSTOM, String MULTI, String BASE) {
        this.PRACTICE = PRACTICE;
        this.CUSTOM = CUSTOM;
        this.MULTI = MULTI;
        this.BASE = BASE;
    }
}
