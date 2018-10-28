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

    private ElementsCollection checkBoxes = $$(By.cssSelector(".label-checkbox > input"));

    private ElementsCollection radioButtons = $$(By.cssSelector(".label-radio > input"));

    private ElementsCollection dropdownElements = $$(By.cssSelector(".colors .uui-form-element > option"));

    private SelenideElement dropdown = $(By.cssSelector(".main-content-hg .colors"));

    private ElementsCollection buttons = $$(By.cssSelector(".main-content-hg .uui-button"));

    private SelenideElement leftSection = $(By.cssSelector(".sidebar-menu"));

    private SelenideElement rightSection = $(By.cssSelector(".right-fix-panel"));

    private ElementsCollection logs = $$(By.cssSelector(".panel-body-list.logs > li"));

    //==============================methods==================================

    public void selectOneOfCheckBoxes(int number) {
        checkBoxes.shouldBe(sizeGreaterThan(number));
        checkBoxes.get(number).click();
        checkLogOfCheckBox(checkBoxes.get(number));
    }

    public void selectOneOfRadioButtons(int number) {
        radioButtons.shouldBe(sizeGreaterThan(number));
        radioButtons.get(number).click();
        checkLog(radioButtons.get(number));
    }

    public void selectOneOfDropdownElements(int number) {
        dropdownElements.shouldBe(sizeGreaterThan(number));
        dropdownElements.get(number).click();
        checkLog(dropdownElements.get(number));
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
        for (SelenideElement item: radioButtons) {
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

    public void checkLogOfCheckBox(SelenideElement element) {
        assertTrue(logs.first().getText().contains(element.getText() + String.valueOf(element.is(selected))));
        logs.first().shouldBe(visible);
    }
}
