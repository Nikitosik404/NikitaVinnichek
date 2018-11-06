package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertTrue;

public class DifferentElementsCucumber {

    private ElementsCollection checkBoxes = $$(cssSelector(".label-checkbox"));

    private ElementsCollection radioButtons = $$(cssSelector(".label-radio"));

    private ElementsCollection dropdownElements = $$(cssSelector(".colors .uui-form-element > option"));

    private SelenideElement dropdown = $(cssSelector(".main-content-hg .colors"));

    private ElementsCollection buttons = $$(cssSelector(".main-content-hg .uui-button"));

    private SelenideElement leftSection = $(cssSelector(".sidebar-menu"));

    private SelenideElement rightSection = $(cssSelector(".right-fix-panel"));

    private ElementsCollection logs = $$(".panel-body-list.logs > li");

    public DifferentElementsCucumber() {
        page(this);
    }

    //==============================methods==================================

    @Step
    @When("I select checkboxes:")
    @Then("I un-select checkboxes:")
    public void selectOneOfCheckBoxes(List<String> checkoxes) {
        for (String checkbox : checkoxes) {
            checkBoxes.find(text(checkbox)).click();
        }
    }

    @Step
    @When("I select (.+) radio-button")
    public void selectOneOfRadioButtons(String radioButton) {
        radioButtons.find(text(radioButton)).click();
    }

    @Step
    @When("I select (.+) item from the Colors Drop Down menu")
    public void selectFromDropdownElements(String dropdownElement) {
        dropdownElements.find(text(dropdownElement)).click();
    }

    //==============================checks===================================
    @Step
    @Then("Interface on Different Elements Page contains all needed elements")
    public void checkDifferentElementsPageExists() {
        this.checkCheckBoxes();
        this.checkCheckRadios();
        this.checkDropdown();
        this.checkButtons();
    }

    @Step
    private void checkCheckBoxes() {
        for (SelenideElement element : checkBoxes) {
            element.shouldBe(visible);
        }
    }

    @Step
    private void checkCheckRadios() {
        for (SelenideElement item : radioButtons) {
            item.shouldBe(visible);
        }
    }

    @Step
    private void checkDropdown() {
        dropdown.shouldBe(visible);
    }

    @Step
    private void checkButtons() {
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    @Step
    @Then("The right section of the page is displayed")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step
    @Then("The left section of the page is displayed")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    @Then("Selecting of (.+) drop down menu item will be properly logged")
    public void checkLogsDropdowns(String radioButton) {
        SelenideElement element = dropdownElements.find(text(radioButton));
        assertTrue(logs.first().getText().contains(element.getText()));
    }

    @Step
    @Then("Selecting of (.+) radio-button will be properly logged")
    public void checkLogsRadioButton(String radioButton) {
        SelenideElement element = radioButtons.find(text(radioButton));
        assertTrue(logs.first().getText().contains(element.getText()));
    }

    @Step
    @Then("Checking of following checkboxes will be properly logged:")
    public void checkLogOfCheckBoxIsSelected(List<String> checkoxes) {
        for (String checkbox: checkoxes) {
            SelenideElement element = checkBoxes.find(text(checkbox));
            if (logs.findBy(text(element.getText())) != null) {
                logs.findBy(text(element.getText())).shouldHave(text(element.getText()
                        + ": condition changed to " + String.valueOf(true)));
            }
        }

    }

    @And("Un-selecting of following checboxes will be properly logged:")
    public void checkLogOfCheckBoxDontSelected(List<String> checkoxes) {
        for (String checkbox: checkoxes) {
            SelenideElement element = checkBoxes.find(text(checkbox));
            if (logs.findBy(text(element.getText())) != null) {
                logs.findBy(text(element.getText())).shouldHave(text(element.getText()
                        + ": condition changed to " + String.valueOf(false)));
            }
        }

    }

}
