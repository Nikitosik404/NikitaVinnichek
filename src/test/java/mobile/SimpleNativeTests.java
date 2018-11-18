package mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import setup.Hooks;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.id;
import static org.testng.Assert.assertTrue;


public class SimpleNativeTests extends Hooks {

    @Test
    public void simplestAddContactScreenTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        By add_contact_title = id("android:id/title");

        assertTrue(driver().findElement(add_contact_title).isDisplayed());

        boolean isKeyboardVisible;
        try {
            driver().hideKeyboard();
            isKeyboardVisible = true;
        } catch (Exception e) {
            System.out.println("No keyboard!");
            isKeyboardVisible= false;
        }
        assertTrue(isKeyboardVisible);

        WebElement target_account_title = driver().findElement(id("Target Account"));
        WebElement contact_name_title = driver().findElement(id("Contact Name"));
        WebElement contact_phone_title = driver().findElement(id("Contact Phone"));
        WebElement contact_email_title = driver().findElement(id("Contact Email"));

        List<WebElement> desiredTitles = Arrays.asList(target_account_title, contact_name_title,
                contact_phone_title, contact_email_title);
        List<String> expectedTitles = Arrays.asList("Target Account", "Contact Name",
                "Contact Phone", "Contact Email");

        for (WebElement title : desiredTitles) {
            assertTrue(title.isDisplayed());
        }

        for (int i = 0 ; i < expectedTitles.size(); i++){
            assertEquals(desiredTitles.get(i).getText(),expectedTitles.get(i));
        }

        System.out.println("Simplest Appium test done");
    }
}
