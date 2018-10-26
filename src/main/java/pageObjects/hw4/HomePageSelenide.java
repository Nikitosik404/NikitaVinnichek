package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ProperTextHomePage.*;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

    private SelenideElement profileButton = $(By.cssSelector(".profile-photo"));

    private SelenideElement login = $(By.cssSelector("[id = 'Name']"));

    private SelenideElement password = $(By.cssSelector("[id = 'Password']"));

    private SelenideElement submit = $(By.cssSelector("[type = 'submit']"));

    private SelenideElement loginTitle = $(By.cssSelector("div.profile-photo > span"));

    private SelenideElement serviceHeadButton = $(By.cssSelector(".m-l8 .dropdown-toggle"));

    private SelenideElement serviceLeftButton = $(By.cssSelector(".sidebar-menu .menu-title"));

    private ElementsCollection serviceHeadListItems = $$(By.cssSelector(".dropdown-menu > li"));

    private ElementsCollection serviceLeftListItems = $$(By.cssSelector("[class = 'sub'] li"));

    private SelenideElement differentElementsButton  = $(By.cssSelector(".dropdown-menu [href = 'different-elements.html']"));

    private SelenideElement datesButton = $(By.cssSelector(".dropdown-menu [href = 'dates.html']"));

    //==============================methods==================================

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void clickHeadServiceButton() {
        serviceHeadButton.click();
    }

    public void clickLeftServiceButton() {
        serviceLeftButton.click();
    }

    public void clickHeadServiceDifferentElements(){
        differentElementsButton.click();
    }

    public void clickHeadServiceDates() {
        datesButton.click();
    }

    //==============================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), TITLE.text);
    }

    public void checkLoginTitle(String title) {
        loginTitle.shouldHave(text(title));
    }

    public void checkHeadServiceDropdownContains(){
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add(SERVICE_DROPDOWN1.text);
        expectedTitles.add(SERVICE_DROPDOWN2.text);
        expectedTitles.add(SERVICE_DROPDOWN3.text);
        expectedTitles.add(SERVICE_DROPDOWN4.text);
        expectedTitles.add(SERVICE_DROPDOWN5.text);
        expectedTitles.add(SERVICE_DROPDOWN6.text);
        expectedTitles.add(SERVICE_DROPDOWN7.text);
        expectedTitles.add(SERVICE_DROPDOWN8.text);

        for (int i = 0; i < serviceHeadListItems.size(); i++){
            assertEquals(serviceHeadListItems.get(i).getText(), expectedTitles.get(i));
        }
    }

    public void checkLeftServiceDropdownContains() {
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add(SERVICE_LEFTSECTION1.text);
        expectedTitles.add(SERVICE_LEFTSECTION2.text);
        expectedTitles.add(SERVICE_LEFTSECTION3.text);
        expectedTitles.add(SERVICE_LEFTSECTION4.text);
        expectedTitles.add(SERVICE_LEFTSECTION5.text);
        expectedTitles.add(SERVICE_LEFTSECTION6.text);
        expectedTitles.add(SERVICE_LEFTSECTION7.text);
        expectedTitles.add(SERVICE_LEFTSECTION8.text);

        for (int i = 0; i < serviceLeftListItems.size(); i++){
            assertEquals(serviceLeftListItems.get(i).getText(), expectedTitles.get(i));
        }
    }
}