package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ProperTextHomePage.HOME_PAGE_URL;
import static enums.ProperTextHomePage.TITLE;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.hw4.LeftSectionService.getServiceMenu;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageCucumber {

    private SelenideElement profileButton = $(cssSelector(".profile-photo"));

    private SelenideElement login = $(cssSelector("[id = 'Name']"));

    private SelenideElement password = $(cssSelector("[id = 'Password']"));

    private SelenideElement submit = $(cssSelector("[type = 'submit']"));

    private SelenideElement loginTitle = $(cssSelector(".profile-photo span"));

    private SelenideElement serviceHeadButton = $(cssSelector(".m-l8 .dropdown-toggle"));

    private SelenideElement serviceLeftButton = $(cssSelector(".sidebar-menu .menu-title"));

    private ElementsCollection serviceHeadListItems = $$(cssSelector(".dropdown-menu > li"));

    private ElementsCollection serviceLeftListItems = $$(cssSelector("[class = 'sub'] li"));

    private SelenideElement differentElementsButton = $(cssSelector(".dropdown-menu [href = 'different-elements.html']"));

    private SelenideElement userTableButton = $(cssSelector(".dropdown-menu [href = 'user-table.html']"));

    private ElementsCollection benefitIcons = $$(cssSelector(".benefit-icon"));

    private ElementsCollection textsUnderIconsElements = $$(cssSelector(".benefit-txt"));

    private SelenideElement mainHeaderElement = $(cssSelector("h3.main-title.text-center"));

    private SelenideElement mainSubHeader = $(cssSelector(".main-txt.text-center"));

    //==============================methods==================================

    public HomePageCucumber() {
        page(this);
    }

    @Step
    @Then("I am on \"Home Page\"")
    public void openPage() {
        open(HOME_PAGE_URL.text);
    }

    @Step
    @And("I login as user (.+) with password (.+)")
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    @Step
    @And("I login as user \"Piter Chailovskii\"")
    public void loginPiter() {
        profileButton.click();
        login.sendKeys(PITER_CHAILOVSKII.login);
        password.sendKeys(PITER_CHAILOVSKII.password);
        submit.click();
    }

    @Step
    @When("I click on \"Service\" button in Header")
    public void clickHeadServiceButton() {
        serviceHeadButton.click();
    }

    @Step
    @When("I click on the left Service subcategory")
    public void clickLeftServiceButton() {
        serviceLeftButton.click();
    }


    @Step
    @And("I click on \"User Table\" button in Service dropdown")
    public void clickUserTableButton() {
        userTableButton.click();
    }


    @Step
    @Then("I navigate to the Different Elements page through the upper Service menu")
    public void clickHeadServiceDifferentElements() {
        differentElementsButton.click();
    }

    @Step
    @And("I click on \"Different Elements\" button in Service dropdown")
    public void openPageThroughTheHeaderMenu() {
        differentElementsButton.click();
    }

    //==============================checks===================================
    @Step
    @Then("The browser title is Home Page")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), TITLE.text);
    }

    @Step
    @Then("The user icon (.+) is displayed on the header")
    public void checkLoginTitle(String user) {
        loginTitle.shouldBe(visible);
        loginTitle.shouldHave(text(user));
    }

    @Step
    @Then("Upper Service drop down opens with all needed options")
    public void checkHeadServiceDropdownContains() {
        for (String serviceElement : getServiceMenu()) {
            assertTrue(serviceHeadListItems.texts().contains(serviceElement.toUpperCase()));
        }
    }

    @Step
    @Then("Left Service drop down opens with all needed options")
    public void checkLeftServiceDropdownContains() {
        for (String serviceElement : getServiceMenu()) {
            assertTrue(serviceLeftListItems.texts().contains(serviceElement));
        }
    }

    @Step
    @Then("Interface on Home Page contains all needed elements")
    public void checkInterfaceOfHomePage() {
        benefitIcons.shouldHave(size(4));
        for (SelenideElement icon : benefitIcons) {
            icon.shouldBe(visible);
        }
        textsUnderIconsElements.shouldHave(size(4));
        for (SelenideElement text : textsUnderIconsElements) {
            text.shouldBe(visible);
        }
        mainHeaderElement.shouldBe(visible);
        mainSubHeader.shouldBe(visible);
    }
}