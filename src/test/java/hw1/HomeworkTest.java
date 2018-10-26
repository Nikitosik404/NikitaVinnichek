package hw1;

import base.TestBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static enums.ProperTextHomePage.*;
import static enums.Users.PITER_CHALOVSKII;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeworkTest extends TestBaseClass {

    @Test
    public void epamPageTest() {

        //1 Open BR and navigate
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(cssSelector(".profile-photo")).click();
        driver.findElement(cssSelector("[id = 'Name']")).sendKeys(PITER_CHALOVSKII.login);
        driver.findElement(cssSelector("[id = 'Password']")).sendKeys(PITER_CHALOVSKII.password);
        driver.findElement(cssSelector("[type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(cssSelector(".profile-photo > span"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerItems = driver.findElements(cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li"));
        assertEquals(headerItems.size(), 4);
        
        for (WebElement item: headerItems){
            assertTrue(item.isDisplayed());
        }
        
        assertEquals(headerItems.get(0).getText(), "HOME");
        assertEquals(headerItems.get(1).getText(), "CONTACT FORM");
        assertEquals(headerItems.get(2).getText(), "SERVICE");
        assertEquals(headerItems.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imagesItems = driver.findElements(cssSelector(".benefit-icon"));
        assertEquals(imagesItems.size(), 4);
        for (WebElement item : imagesItems) {
            assertTrue(item.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(cssSelector(".benefit-txt"));
        assertEquals(textItems.size(), 4);
        assertEquals(textItems.get(0).getText(), PRACTICE.text);
        assertEquals(textItems.get(1).getText(), CUSTOM.text);
        assertEquals(textItems.get(2).getText(), MULTI.text);
        assertEquals(textItems.get(3).getText(), BASE.text);

        //9 Assert a text of the main header
        assertEquals(driver.findElement(cssSelector(".main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        String mainTxt = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(driver.findElement(cssSelector(".main-txt")).getText(), mainTxt);


        //10 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(cssSelector("iframe")).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        assertTrue(driver.findElement( id("epam_logo") ).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        assertEquals(driver.findElement(cssSelector("[class='text-center']")).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(cssSelector("[class='text-center']>a")).getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        assertTrue(driver.findElement(cssSelector("[name='navigation-sidebar']")).isDisplayed());

        //16 Assert that there is Footer
        assertTrue(driver.findElement(cssSelector("footer")).isDisplayed());

        //17 Close Browser
        driver.close();

    }
}
