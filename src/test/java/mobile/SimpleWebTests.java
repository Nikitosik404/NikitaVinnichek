package mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import setup.Hooks;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertTrue;


public class SimpleWebTests extends Hooks {

    @Test
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));

        WebElement header_logo = driver().findElement(cssSelector("h1"));

        assertTrue(header_logo.isDisplayed());

        List<WebElement> sections = driver().findElements(cssSelector(".home-panel"));

        assertEquals(sections.size(),3);
        for(WebElement section : sections){
            assertTrue(section.isDisplayed());
        }
        System.out.println("Site opening done");
    }
}
