package appiumHW.hw1;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest extends DriverSetup {

    @BeforeMethod
    public void setUp() throws Exception {
        //prepareNative();
        prepareAndroidWeb();
    }

    @Test
    public void simpleNativeTest() {
        By add_btn_by_id = By.id("com.example.android.contactmanager:id/addContactButton");

        //added alternative locators
        By add_btn_by_xpath = By.xpath("//android.widget.Button[@content-desc='Add Contact']");
        By add_btn__by_class_name = By.className("android.widget.Button");

        driver.findElement(add_btn_by_id).click();
        System.out.println("Simpltest Appium test done");
    }

    @Test
    public void simpleWebTest() {
        driver.get("http://iana.org");
        System.out.println("Site opening done");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}