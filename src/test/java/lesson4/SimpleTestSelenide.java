package lesson4;

import base.SelenideTestBase;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenide extends SelenideTestBase {

    @BeforeClass
    public void beforeClass() {
        HomePage homePageSelenide = page(HomePage.class);
    }


    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //1 Open BR
       // WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        open("https://epam.github.io/JDI/index.html");

        //3 Assert Title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4 Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $("[type = 'submit']").click();

        //Chek main title
       SelenideElement mainTitle = $(By.cssSelector("h3.main-title"));
       mainTitle.shouldBe(visible);
       mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
       //assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        //6.Check
        $$(By.xpath("//")).shouldHaveSize(4);

    }
}