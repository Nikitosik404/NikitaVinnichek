package base;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import static enums.ProperTextHomePage.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class TestBaseClass {

    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        time = currentTimeMillis();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked: " + (currentTimeMillis() - time));
    }

    @BeforeTest(alwaysRun = true)
    public void create() {
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add(HEADER_SECTION1.text);
        expectedTitles.add(HEADER_SECTION2.text);
        expectedTitles.add(HEADER_SECTION3.text);
        expectedTitles.add(HEADER_SECTION4.text);
    }
}