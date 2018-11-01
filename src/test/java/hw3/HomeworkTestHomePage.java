package hw3;

import base.TestBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomeworkHomePage;

import java.util.concurrent.TimeUnit;

import static enums.ProperTextHomePage.*;
import static enums.Users.PITER_CHAILOVSKII;

public class HomeworkTestHomePage extends TestBaseClass {

    private WebDriver driver;
    private HomeworkHomePage homePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomeworkHomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void epamPageTest() {

        //1 Navigate to "https://epam.github.io/JDI/index.html"
        homePage.open(driver);

        //2 Assert Browser title
        homePage.checkTitle(driver, TITLE.text);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkLogin(USER.text);

        //5 Assert Browser title
        homePage.checkTitle(driver, TITLE.text);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkHeaderItemText();

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkIndexPageImages();

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkImageTitles();

        //9 Assert a text of the main header
        homePage.checkMainHeader(MAIN_TITLE.text, MAIN_TEXT.text);


        //10 Assert that there is the iframe in the center of page
        homePage.checkFrameDisplaying();

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToNewFrame(driver);
        homePage.checkFrameLogo();

        //12 Switch to original window back
        homePage.switchToOldFrame(driver);

        //13 Assert a text of the sub header
        homePage.checkSubHeaderDisplaying(SUB_HEADER.text);

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkSubHeaderLink(SUB_HEADER_URL.text);

        //15 Assert that there is Left Section
        homePage.checkLeftSectionDisplaying();

        //16 Assert that there is Footer
        homePage.checkFooterDisplaying();
    }
}
