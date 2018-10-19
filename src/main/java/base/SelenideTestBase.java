package base;

import org.testng.annotations.BeforeSuite;
import  com.codeborne.selenide.Configuration;

public class SelenideTestBase {

    @BeforeSuite
    public void beforeSuite() {

        Configuration.browser = "chrome";
    }
}
