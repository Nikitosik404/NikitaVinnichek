package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ProperTextHomePage.HOME_PAGE_URL;
import static enums.ProperTextHomePage.TITLE;
import static enums.hw4.LeftSectionService.getServiceMenu;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    private SelenideElement profileButton = $(By.cssSelector(".profile-photo"));

    private SelenideElement login = $(By.cssSelector("[id = 'Name']"));

    private SelenideElement password = $(By.cssSelector("[id = 'Password']"));

    private SelenideElement submit = $(By.cssSelector("[type = 'submit']"));

    private SelenideElement loginTitle = $(By.cssSelector(".profile-photo span"));

    private SelenideElement serviceHeadButton = $(By.cssSelector(".m-l8 .dropdown-toggle"));

    private SelenideElement serviceLeftButton = $(By.cssSelector(".sidebar-menu .menu-title"));

    private ElementsCollection serviceHeadListItems = $$(By.cssSelector(".dropdown-menu > li"));

    private ElementsCollection serviceLeftListItems = $$(By.cssSelector("[class = 'sub'] li"));

    private SelenideElement differentElementsButton = $(By.cssSelector(".dropdown-menu [href = 'different-elements.html']"));

    private SelenideElement datesButton = $(By.cssSelector(".dropdown-menu [href = 'dates.html']"));

    //==============================methods==================================
    @Step
    public void openPage() {
        open(HOME_PAGE_URL.text);
    }

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    public void clickHeadServiceButton() {
        serviceHeadButton.click();
    }

    @Step
    public void clickLeftServiceButton() {
        serviceLeftButton.click();
    }

    @Step
    public void clickHeadServiceDifferentElements() {
        differentElementsButton.click();
    }

    @Step
    public void clickHeadServiceDates() {
        datesButton.click();
    }

    //==============================checks===================================
    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), TITLE.text);
    }

    @Step
    public void checkLoginTitle(Users user) {
        loginTitle.shouldBe(visible);
        loginTitle.shouldHave(text(user.name));
    }

    @Step
    public void checkHeadServiceDropdownContains() {
        for (String serviceElement : getServiceMenu()) {
            assertTrue(serviceHeadListItems.texts().contains(serviceElement.toUpperCase()));
        }
    }

    @Step
    public void checkLeftServiceDropdownContains() {
        for (String serviceElement : getServiceMenu()) {
            assertTrue(serviceLeftListItems.texts().contains(serviceElement));
        }
    }
}