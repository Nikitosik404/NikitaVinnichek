package hw2.ex2;

import base.TestBaseClass;
import enums.PropperText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SmokeAndRegressionHomeworkTest extends TestBaseClass {

    @Test(groups = {"Regression","Smoke"})
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
        assertEquals(PropperText.PRACTICE.text, textItems.get(0).getText());
        assertEquals(PropperText.CUSTOM.text, textItems.get(1).getText());
        assertEquals(PropperText.MULTI.text, textItems.get(2).getText());
        assertEquals(PropperText.BASE.text, textItems.get(3).getText());

        //4 Close BR
        driver.close();
    }

    @Test(groups = {"Regression","Smoke"})
    public void secondSimpleTest() {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(4, textItems.size());
        assertEquals(PropperText.PRACTICE.text, textItems.get(0).getText());
        assertEquals(PropperText.CUSTOM.text, textItems.get(1).getText());
        assertEquals(PropperText.MULTI.text, textItems.get(2).getText());
        assertEquals(PropperText.BASE.text, textItems.get(3).getText());

        //4 Close BR
        driver.close();
    }

    @Test(groups = {"Regression","Smoke"})
    public void thirdSimpleTest() {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textItems = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(4, textItems.size());
        assertEquals(PropperText.PRACTICE.text, textItems.get(0).getText());
        assertEquals(PropperText.CUSTOM.text, textItems.get(1).getText());
        assertEquals(PropperText.MULTI.text, textItems.get(2).getText());
        assertEquals(PropperText.BASE.text, textItems.get(3).getText());

        //4 Close BR
        driver.close();
    }
}
