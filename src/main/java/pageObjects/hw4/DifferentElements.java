package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.hw4.CheckBoxes;
import enums.hw4.DropdownElements;
import enums.hw4.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class DifferentElements extends PageObjectBase  {

    @FindBy(css = ".label-checkbox > input")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio > input")
    private ElementsCollection radioButtons;

    @FindBy(css = ".colors .uui-form-element > option")
    private ElementsCollection dropdownElements;

    @FindBy(css = ".main-content-hg .colors")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content-hg .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    //==============================methods==================================
    @Step
    public void selectOneOfCheckBoxes(CheckBoxes checkBox) {
        checkBoxes.shouldBe(sizeGreaterThan(Integer.parseInt(checkBox.displayName)));
        checkBoxes.get(Integer.parseInt(checkBox.displayName)).click();
    }

    @Step
    public void selectOneOfRadioButtons(RadioButtons radioButton) {
        radioButtons.shouldBe(sizeGreaterThan(Integer.valueOf(radioButton.displayName)));
        radioButtons.get(Integer.valueOf(radioButton.displayName)).click();
    }

    @Step
    public void selectOneOfDropdownElements(DropdownElements dropdownElement) {
        dropdownElements.shouldBe(sizeGreaterThan(Integer.valueOf(dropdownElement.displayName)));
        dropdownElements.get(Integer.valueOf(dropdownElement.displayName)).click();
    }

    //==============================checks===================================
    @Step
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
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    public void checkLogsDropdowns(DropdownElements radioButton) {
        SelenideElement element = dropdownElements.get(Integer.valueOf(radioButton.displayName));
        assertTrue(logs.first().getText().contains(element.getText()));
    }

    @Step
    public void checkLogsRadioButton(RadioButtons radioButton) {
        SelenideElement element = radioButtons.get(Integer.valueOf(radioButton.displayName));
        assertTrue(logs.first().getText().contains(element.getText()));
    }

    @Step
    public void checkLogOfCheckBox(CheckBoxes checkBox, boolean value) {
        SelenideElement element = checkBoxes.get(Integer.valueOf(checkBox.displayName));
        if (logs.findBy(text(element.getText())) != null)
        logs.findBy(text(element.getText())).shouldHave(text(element.getText() + String.valueOf(value)));
    }
}
