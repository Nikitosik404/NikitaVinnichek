package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static org.testng.AssertJUnit.assertTrue;

public class ServiceDatesPageSelenide {


    private ElementsCollection difElLogs = $$(By.cssSelector(".panel-body-list.logs > li"));

    //==============================methods==================================



    //==============================checks===================================

    private void checkLeftSliderInLog(int position) {
        assertTrue(difElLogs.first().getText().contains("From" + String.valueOf(position)));
    }

    private void checkRightSliderInLog(int position) {
        assertTrue(difElLogs.first().getText().contains("To" + String.valueOf(position)));
    }
}
