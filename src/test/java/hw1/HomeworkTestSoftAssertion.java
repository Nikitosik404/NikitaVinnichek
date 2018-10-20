package hw1;

import enums.PropperText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHALOVSKII;
import static java.lang.System.setProperty;

public class HomeworkTestSoftAssertion {

    @Test
    public void EpamPageTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        SoftAssert softAssert = new SoftAssert();

        //1 Open BR and navigate
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys(PITER_CHALOVSKII.login);
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys(PITER_CHALOVSKII.password);
        driver.findElement(By.cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo > span"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals("HOME", driver.findElement(By.cssSelector(".uui-navigation a[href*='index']")).getText());
        softAssert.assertEquals("CONTACT FORM", driver.findElement(By.cssSelector(".uui-navigation a[href*='contacts']")).getText());
        softAssert.assertEquals("SERVICE", driver.findElement(By.cssSelector(".uui-navigation .dropdown-toggle")).getText());
        softAssert.assertEquals("METALS & COLORS", driver.findElement(By.cssSelector(".uui-navigation a[href*='metals-colors']")).getText());

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imagesItems = driver.findElements(By.cssSelector(".benefit-icon"));
        softAssert.assertEquals(4, imagesItems.size());
        for (WebElement item : imagesItems) {
            softAssert.assertTrue(item.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        softAssert.assertEquals(4, textItems.size());
        softAssert.assertEquals(PropperText.PRACTICE.text, textItems.get(0).getText());
        softAssert.assertEquals(PropperText.CUSTOM.text, textItems.get(1).getText());
        softAssert.assertEquals(PropperText.MULTI.text, textItems.get(2).getText());
        softAssert.assertEquals(PropperText.BASE.text, textItems.get(3).getText());

        //9 Assert a text of the main header
        softAssert.assertEquals("EPAM FRAMEWORK WISHES…", driver.findElement(By.cssSelector(".main-title")).getText());
        String mainTxt = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        softAssert.assertEquals( driver.findElement(By.cssSelector(".main-txt")).getText(), mainTxt);


        //10 Assert that there is the iframe in the center of page
        softAssert.assertTrue(driver.findElement(By.cssSelector("iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        String mainHandler = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe")));
        softAssert.assertTrue(driver.findElement(By.cssSelector(".epam-logo")).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().window(mainHandler);

        //13 Assert a text of the sub header
        softAssert.assertEquals("JDI GITHUB", driver.findElement(By.cssSelector("a[href*='github.com/']")).getText());

        //15 Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.cssSelector("[name='navigation-sidebar']")).isDisplayed());

        //16 Assert that there is Footer
        softAssert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17 Close Browser
        driver.close();

        softAssert.assertAll();

    }
}
