package appiumHW3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import setup.Hooks;

import java.util.List;

import static enums.mobile.WebPage.*;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "web")
public class WebTest extends Hooks {

    @Test(description = "Open website and check elements", groups = {"web.ios", "web.android"})
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));

        // Check main title
        assertEquals(driver().getTitle(), "Internet Assigned Numbers Authority");

        // Check that logo is displayed
        WebElement logo = driver().findElement(By.cssSelector("header h1"));
        assertTrue(logo.isDisplayed());

        // Check intro (text and display)
        WebElement intro = driver().findElement(By.cssSelector("#intro p"));
        assertTrue(intro.isDisplayed());
        assertEquals(intro.getText(), INTRO.value);

        // Check link in intro
        WebElement introLink = driver().findElement(By.cssSelector("#intro a"));
        assertTrue(introLink.isDisplayed());
        assertEquals(introLink.getAttribute("href"), "https://www.iana.org/about/");

        // Check there are three panels
        List<WebElement> homePanels = driver().findElements(By.cssSelector("#home-panels div"));
        assertEquals(homePanels.size(), 3);

        // Check titles in three panels:
        // domain names
        WebElement domainsPanel = driver().findElement(By.cssSelector("#home-panel-domains h2"));
        assertTrue(domainsPanel.isDisplayed());
        assertEquals(domainsPanel.getText(), DOMAIN_PANEL_TITLE.value);

        // number resources
        WebElement numbersPanel = driver().findElement(By.cssSelector("#home-panel-numbers h2"));
        assertTrue(numbersPanel.isDisplayed());
        assertEquals(numbersPanel.getText(), NUMBERS_PANEL_TITLE.value);

        // protocol assignments
        WebElement protocolsPanel = driver().findElement(By.cssSelector("#home-panel-protocols h2"));
        assertTrue(protocolsPanel.isDisplayed());
        assertEquals(protocolsPanel.getText(), PROTOCOLS_PANEL_TITLE.value);

        // Check panel search
        WebElement searchPanel = driver().findElement(By.cssSelector("#home-panel-search"));
        assertTrue(searchPanel.isDisplayed());

        // Check footer is displayed
        WebElement footer = driver().findElement(By.cssSelector("footer"));
        assertTrue(footer.isDisplayed());
    }
}
