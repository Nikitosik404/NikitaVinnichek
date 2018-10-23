package hw2.ex1;

import base.TestBaseClass;
import dataProviders.HomeworkDataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomeworkTestDataProvider extends TestBaseClass {

    @Test(dataProvider = "HomeworkDataProvider", dataProviderClass = HomeworkDataProviders.class)
    public void simpleTest(String propperText, int numberText) {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textItems.size(), 4);
        assertEquals(textItems.get(numberText).getText(), propperText);

        //4 Close BR
        driver.close();
    }
}
