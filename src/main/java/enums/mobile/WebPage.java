package enums.mobile;

public enum  WebPage {
    INTRO("The global coordination of the DNS Root, IP addressing, and other Internet protocol resources is performed as" +
                  " the Internet Assigned Numbers Authority (IANA) functions. Learn more."),
    DOMAIN_PANEL_TITLE("Domain Names"),
    NUMBERS_PANEL_TITLE("Number Resources"),
    PROTOCOLS_PANEL_TITLE("Protocol Assignments");


    public String value;

    WebPage(String value) {
        this.value = value;
    }
}
