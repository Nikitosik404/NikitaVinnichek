package pageObjects.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertTrue;

public class DifferentElementsCucumber {

    private ElementsCollection checkBoxes = $$(cssSelector(".label-checkbox"));

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection checkBoxElements;

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
    @When("I set next checkboxes to (.+):")
    public void selectCheckBoxes(String value, List<String> checkoxes) {
        for (String checkbox : checkoxes) {
            selectCheckBox(Boolean.valueOf(value), checkbox);
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

    private void checkCheckBoxes() {
        checkBoxes.shouldHaveSize(4);
        for (SelenideElement element : checkBoxes) {
            element.shouldBe(visible);
        }
    }

    private void checkCheckRadios() {
        radioButtons.shouldHaveSize(4);
        for (SelenideElement item : radioButtons) {
            item.shouldBe(visible);
        }
    }

    private void checkDropdown() {
        dropdown.shouldBe(visible);
    }

    private void checkButtons() {
        buttons.shouldHaveSize(2);
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

    private void selectCheckBox(boolean value, String checkbox) {
        for (SelenideElement element : checkBoxElements) {
            if (element.parent().getText().equals(checkbox))
                element.setSelected(value);
        }
    }
}
