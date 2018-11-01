package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.hw4.CheckBoxes;
import enums.hw4.DropdownElements;
import enums.hw4.RadioButtons;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class DifferentElements {

    private ElementsCollection checkBoxes = $$(By.cssSelector(".label-checkbox > input"));

    private ElementsCollection radioButtons = $$(By.cssSelector(".label-radio > input"));

    private ElementsCollection dropdownElements = $$(By.cssSelector(".colors .uui-form-element > option"));

    private SelenideElement dropdown = $(By.cssSelector(".main-content-hg .colors"));

    private ElementsCollection buttons = $$(By.cssSelector(".main-content-hg .uui-button"));

    private SelenideElement leftSection = $(By.cssSelector(".sidebar-menu"));

    private SelenideElement rightSection = $(By.cssSelector(".right-fix-panel"));

    private ElementsCollection logs = $$(By.cssSelector(".panel-body-list.logs > li"));

    //==============================methods==================================

    public void selectOneOfCheckBoxes(CheckBoxes checkBox) {
        checkBoxes.shouldBe(sizeGreaterThan(Integer.parseInt(checkBox.displayName)));
        checkBoxes.get(Integer.parseInt(checkBox.displayName)).click();
    }

    public void selectOneOfRadioButtons(RadioButtons radioButton) {
        radioButtons.shouldBe(sizeGreaterThan(Integer.valueOf(radioButton.displayName)));
        radioButtons.get(Integer.valueOf(radioButton.displayName)).click();
        checkLog(radioButtons.get(Integer.valueOf(radioButton.displayName)));
    }

    public void selectOneOfDropdownElements(DropdownElements dropdownElement) {
        dropdownElements.shouldBe(sizeGreaterThan(Integer.valueOf(dropdownElement.displayName)));
        dropdownElements.get(Integer.valueOf(dropdownElement.displayName)).click();
    }

    //==============================checks===================================

    public void checkDifferentElementsPageExists() {
        this.checkCheckBoxes();
        this.checkCheckRadios();
        this.checkDropdown();
        this.checkButtons();
    }

    private void checkCheckBoxes() {
        for (SelenideElement element : checkBoxes) {
            element.shouldBe(visible);
        }
    }

    private void checkCheckRadios() {
        for (SelenideElement item : radioButtons) {
            item.shouldBe(visible);
        }
    }

    private void checkDropdown() {
        dropdown.shouldBe(visible);
    }

    private void checkButtons() {
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkLog(SelenideElement element) {
        assertTrue(logs.first().getText().contains(element.getText()));
        logs.first().shouldBe(visible);
    }

    public void checkLogsDropdowns(DropdownElements radioButton) {
        SelenideElement element = dropdownElements.get(Integer.valueOf(radioButton.displayName));
        assertTrue(logs.first().getText().contains(element.getText()));
        logs.first().shouldBe(visible);
    }

    public void checkLogsRadioButton(RadioButtons radioButton) {
        SelenideElement element = radioButtons.get(Integer.valueOf(radioButton.displayName));
        assertTrue(logs.first().getText().contains(element.getText()));
        logs.first().shouldBe(visible);
    }

    public void checkLogOfCheckBox(CheckBoxes checkBox) {
        SelenideElement element = checkBoxes.get(Integer.valueOf(checkBox.displayName));
        logs.findBy(text(element.getText())).shouldHave(text(element.getText() + String.valueOf(element.is(selected))));
    }
}
