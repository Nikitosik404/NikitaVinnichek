package hw2.ex2;

import base.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static enums.ProperText.ProperText;
import static org.testng.Assert.assertEquals;

public class RegressionHomeworkTest extends TestBaseClass {

    @Test(groups = "Regression")
    public void firstSimpleTest() {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(4, textItems.size());
        assertEquals(textItems.size(), 4);
        assertEquals(textItems.get(0).getText(), ProperText.PRACTICE);
        assertEquals(textItems.get(1).getText(), ProperText.CUSTOM);
        assertEquals(textItems.get(2).getText(), ProperText.MULTI);
        assertEquals(textItems.get(3).getText(), ProperText.BASE);

        //4 Close BR
        driver.close();
    }

    @Test(groups = "Regression")
    public void secondSimpleTest() {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textItems.get(0).getText(), ProperText.PRACTICE);
        assertEquals(textItems.get(1).getText(), ProperText.CUSTOM);
        assertEquals(textItems.get(2).getText(), ProperText.MULTI);
        assertEquals(textItems.get(3).getText(), ProperText.BASE);

        //4 Close BR
        driver.close();
    }

    @Test(groups = "Regression")
    public void thirdSimpleTest() {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textItems.size(), 4);
        assertEquals(textItems.get(0).getText(), ProperText.PRACTICE);
        assertEquals(textItems.get(1).getText(), ProperText.CUSTOM);
        assertEquals(textItems.get(2).getText(), ProperText.MULTI);
        assertEquals(textItems.get(3).getText(), ProperText.BASE);

        //4 Close BR
        driver.close();
    }
}
