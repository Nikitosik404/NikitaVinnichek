package appiumHW3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Hooks;

import java.util.Arrays;
import java.util.List;

@Test(groups = "native")
public class NativeTest extends Hooks {

    @Test(description = "Check contact manager application", groups = "native.android")
    public void simplestAddContactScreenTest() throws Exception {

        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        //Check that "Add contact" title is displayed
        By add_contact_title = By.id("android:id/title");
        List<String> expectedTitles = Arrays.asList( "Contact Name", "Contact Phone");
        Assert.assertTrue(driver().findElement(add_contact_title).isDisplayed());


        //Check titles is displayed
        WebElement contact_name_title = driver().findElement(By.id(expectedTitles.get(0)));
        WebElement contact_phone_title = driver().findElement(By.id(expectedTitles.get(1)));
        Assert.assertTrue(contact_name_title .isDisplayed());
        Assert.assertTrue(contact_phone_title .isDisplayed());

        //Assert titles
        Assert.assertEquals(contact_phone_title.getText(), expectedTitles.get(1));
        Assert.assertEquals(contact_name_title.getText(), expectedTitles.get(0));


        //Assert all expected fields are displayed
        WebElement contact_name_field = driver().findElement(By.id(app_package_name + "contactNameEditText"));
        WebElement contact_phone_field = driver().findElement(By.id(app_package_name + "contactPhoneEditText"));
        Assert.assertTrue(contact_name_field.isDisplayed());
        Assert.assertTrue(contact_phone_field.isDisplayed());

        //Keyboard presence check
        boolean keyboardIsVisible;
        try {
            driver().hideKeyboard();
            keyboardIsVisible = true;
        } catch (Exception e) {
            System.out.println("NO KEYBOARD!");
            keyboardIsVisible = false;
        }
        Assert.assertTrue(keyboardIsVisible);

        System.out.println("Simplest Appium test done");
    }
}