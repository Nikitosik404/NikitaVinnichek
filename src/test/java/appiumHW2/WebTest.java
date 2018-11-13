package appiumHW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.PropertyFile;

import java.util.List;

@Test(groups = "web")
public class WebTest extends Hooks {

    protected WebTest() {
        super(PropertyFile.WEB);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));

        //Additional assert
        WebElement header_logo = driver().findElement(By.cssSelector("h1"));
        Assert.assertTrue(header_logo.isDisplayed());

        List<WebElement> sections = driver().findElements(By.cssSelector(".home-panel"));
        Assert.assertEquals(sections.size(),3);
        for(WebElement section : sections){
            Assert.assertTrue(section.isDisplayed());
        }
        System.out.println("Site opening done");
    }
}
