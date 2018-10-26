package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class ServiceDifferentElementsPageSelenide {

    private ElementsCollection CheckBoxes = $$(By.cssSelector(".label-checkbox > input"));

    private ElementsCollection RadioButtons = $$(By.cssSelector(".label-radio > input"));

    private ElementsCollection DropdownElements = $$(By.cssSelector(".colors .uui-form-element > option"));

    private SelenideElement Dropdown = $(By.cssSelector(".main-content-hg .colors"));

    private ElementsCollection Buttons = $$(By.cssSelector(".main-content-hg .uui-button"));

    private SelenideElement LeftSection = $(By.cssSelector(".sidebar-menu"));

    private SelenideElement RightSection = $(By.cssSelector(".right-fix-panel"));

    private ElementsCollection Logs = $$(By.cssSelector(".panel-body-list.logs > li"));

    //==============================methods==================================

    public void selectOneOfCheckBoxes(int number) {
        CheckBoxes.shouldBe(sizeGreaterThan(number));
        CheckBoxes.get(number).click();
        checkLogOfCheckBox(CheckBoxes.get(number));
    }

    public void selectOneOfRadioButtons(int number) {
        RadioButtons.shouldBe(sizeGreaterThan(number));
        RadioButtons.get(number).click();
        checkLog(RadioButtons.get(number));
    }

    public void selectOneOfDropdownElements(int number) {
        DropdownElements.shouldBe(sizeGreaterThan(number));
        DropdownElements.get(number).click();
        checkLog(DropdownElements.get(number));
    }

    //==============================checks===================================

    public void checkDifferentElementsPageExists() {
        this.checkCheckBoxes();
        this.checkCheckRadios();
        this.checkDropdown();
        this.checkButtons();
    }

    private void checkCheckBoxes() {
        for (SelenideElement element : CheckBoxes) {
            element.shouldBe(visible);
        }
    }

    private void checkCheckRadios() {
        for (SelenideElement item: RadioButtons) {
            item.shouldBe(visible);
        }
    }

    private void checkDropdown() {
        Dropdown.shouldBe(visible);
    }

    private void checkButtons() {
        for (SelenideElement element : Buttons) {
            element.shouldBe(visible);
        }
    }

    public void checkRightSection() {
        RightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        LeftSection.shouldBe(visible);
    }

    public void checkLog(SelenideElement element) {
        assertTrue(Logs.first().getText().contains(element.getText()));
        Logs.first().shouldBe(visible);
    }

    public void checkLogOfCheckBox(SelenideElement element) {
        assertTrue(Logs.first().getText().contains(element.getText() + String.valueOf(element.is(selected))));
        Logs.first().shouldBe(visible);
    }
}
