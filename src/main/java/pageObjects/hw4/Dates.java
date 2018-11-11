package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Dates extends PageObjectBase {

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    @FindBy(css = "a.ui-corner-all")
    private ElementsCollection sliderItems;

    @FindBy(css = "div.ui-corner-all")
    private SelenideElement slider;

    //==============================methods==================================
    @Step
    public void moveLeftSlider(int position) {
        Actions newAction = new Actions(getWebDriver());
        double width = slider.getSize().getWidth();
        double xOffset = (position - 1) * width / 100 -
                Double.parseDouble(sliderItems.first().getCssValue("left")
                        .replaceAll("px", ""));
        newAction.dragAndDropBy(sliderItems.first(),(int) Math.ceil(xOffset), 0).build().perform();
    }

    @Step
    public void moveRightSlider(int position) {
        Actions newAction = new Actions(getWebDriver());
        double width = slider.getSize().getWidth();
        double xOffset = (position - 1) * width / 100
                - Double.parseDouble(sliderItems.last().getCssValue("left")
                        .replaceAll("px", ""));

        newAction.dragAndDropBy(sliderItems.last(),(int) Math.ceil(xOffset), 0).build().perform();
    }

    //==============================checks===================================
    @Step
    public void checkInfoInLogAboutSliders(int from, int to) {
        logs.findBy(text("(From):")).shouldHave(text("Range 2(From):" + String.valueOf(from) + " link clicked")).shouldBe(visible);
        logs.findBy(text("(To):")).shouldHave(text("Range 2(To):" + String.valueOf(to) + " link clicked")).shouldBe(visible);
    }
}
