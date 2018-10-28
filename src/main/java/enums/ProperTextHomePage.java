package enums;


public enum ProperTextHomePage {
    PRACTICE("To include good practices\nand ideas from successful\nEPAM project"),
    CUSTOM("To be flexible and\ncustomizable"),
    MULTI("To be multiplatform"),
    BASE("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026"),
    TITLE("Home Page"),
    USER("PITER CHAILOVSKII"),
    MAIN_TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    HEADER_SECTION1("HOME"),
    HEADER_SECTION2("CONTACT FORM"),
    HEADER_SECTION3("SERVICE"),
    HEADER_SECTION4("METALS & COLORS"),
    SUB_HEADER("JDI GITHUB"),
    SUB_HEADER_URL("https://github.com/epam/JDI"),
    SERVICE_DROPDOWN1("SUPPORT"),
    SERVICE_DROPDOWN2("DATES"),
    SERVICE_DROPDOWN3("COMPLEX TABLE"),
    SERVICE_DROPDOWN4("SIMPLE TABLE"),
    SERVICE_DROPDOWN5("USER TABLE"),
    SERVICE_DROPDOWN6("TABLE WITH PAGES"),
    SERVICE_DROPDOWN7("DIFFERENT ELEMENTS"),
    SERVICE_DROPDOWN8("PERFORMANCE"),
    SERVICE_LEFTSECTION1("Support"),
    SERVICE_LEFTSECTION2("Dates"),
    SERVICE_LEFTSECTION3("Complex Table"),
    SERVICE_LEFTSECTION4("Simple Table"),
    SERVICE_LEFTSECTION5("User Table"),
    SERVICE_LEFTSECTION6("Table with pages"),
    SERVICE_LEFTSECTION7("Different elements"),
    SERVICE_LEFTSECTION8("Performance");


    public String text;

    ProperTextHomePage(String text) {
        this.text = text;
    }


}