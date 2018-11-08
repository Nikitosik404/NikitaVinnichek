package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static enums.ProperTextHomePage.HOME_PAGE_URL;
import static enums.hw4.LeftSectionService.getServiceMenu;
import static org.testng.Assert.assertTrue;

public class HomePage extends PageObjectBase {
    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".profile-photo span")
    private SelenideElement loginTitle;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement serviceHeadButton;

    @FindBy(css = ".sidebar-menu .menu-title")
    private SelenideElement serviceLeftButton;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection serviceHeadListItems;

    @FindBy(css = "[class = 'sub'] li")
    private ElementsCollection serviceLeftListItems;

    @FindBy(css = ".dropdown-menu [href = 'different-elements.html']")
    private SelenideElement differentElementsButton;

    @FindBy(css = ".dropdown-menu [href = 'dates.html']")
    private SelenideElement datesButton;

    //==============================methods==================================
    @Step
    public void openPage() {
        open(HOME_PAGE_URL.text);
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