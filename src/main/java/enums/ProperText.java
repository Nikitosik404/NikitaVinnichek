package enums;


public enum ProperText {
    PRACTICE("To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM("To be flexible and\ncustomizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026"),
    TITLE("Home Page"),
    USER("PITER CHAILOVSKII"),
    MAIN_TITLE ("EPAM FRAMEWORK WISHES…"),
    MAIN_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    HEADER_SECTION1("HOME"),
    HEADER_SECTION2("CONTACT FORM"),
    HEADER_SECTION3("SERVICE"),
    HEADER_SECTION4("METALS & COLORS"),
    SUB_HEADER("JDI GITHUB"),
    SUB_HEADER_URL("https://github.com/epam/JDI");


    public String text;

    ProperText(String text) {
        this.text = text;
    }


}
