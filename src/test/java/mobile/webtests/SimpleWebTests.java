package mobile.webtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Hooks;

import java.util.List;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    @Test(description = "Open website")
    public void webTest() throws Exception {
        //Assert that page returns "200" status code
        //Assert.assertEquals(RestAssured.get(SUT).statusCode(),200);

        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));

        //Get header element
        WebElement header_logo = driver().findElement(By.cssSelector("h1"));

        //Assert header is displayed
        Assert.assertTrue(header_logo.isDisplayed());

        //Get list of page sections
        List<WebElement> sections = driver().findElements(By.cssSelector(".home-panel"));

        //Assert there are 3 home-panels
        Assert.assertEquals(sections.size(),3);
        //Assert each of the sections is displayed
        for(WebElement section : sections){
            Assert.assertTrue(section.isDisplayed());
        }
        System.out.println("Site opening done");
    }
}
