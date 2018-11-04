package enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII"),
    ALEX_ZHDANOV("epam", "1234", "ALEX ZHDANOV");

    public String  login;
    public String password;
    public String name;

    Users(String login, String password, String name){
        this.login = login;
        this.password = password;
        this.name = name;

    }

}
