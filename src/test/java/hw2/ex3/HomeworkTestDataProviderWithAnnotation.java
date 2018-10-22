package hw2.ex3;

import dataProviders.HomeworkDataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class HomeworkTestDataProviderWithAnnotation {

    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.close();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }

    @Test(dataProvider = "HomeworkDataProvider", dataProviderClass = HomeworkDataProviders.class)
    public void simpleTest(String propperText, int numberText) {

        //1 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(4, textItems.size());
        assertEquals(propperText, textItems.get(numberText).getText());
    }
}
