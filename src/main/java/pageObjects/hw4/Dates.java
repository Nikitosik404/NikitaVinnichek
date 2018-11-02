package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Dates {

    private ElementsCollection logs = $$(By.cssSelector(".panel-body-list.logs > li"));

    private ElementsCollection sliderItems = $$(By.cssSelector("a.ui-corner-all"));

    private SelenideElement slider = $(By.cssSelector("div.ui-corner-all"));

    //==============================methods==================================
    @Step
    public void moveLeftSlider(int position) {
        Actions newAction = new Actions(getWebDriver());
        int xOffset = (int) ((position - 1) * slider.getSize().getWidth() / 100 -
                Double.parseDouble(sliderItems.first().getCssValue("left")
                        .replaceAll("px", "")));
        newAction.dragAndDropBy(sliderItems.first(), xOffset, 0).build().perform();
    }

    @Step
    public void moveRightSlider(int position) {
        Actions newAction = new Actions(getWebDriver());
        int xOffset = (int) ((position - 1) * slider.getSize().getWidth() / 100 -
                Double.parseDouble(sliderItems.last().getCssValue("left")
                        .replaceAll("px", "")));
        newAction.dragAndDropBy(sliderItems.last(), xOffset, 0).build().perform();
    }

    //==============================checks===================================
    @Step
    public void checkInfoInLogAboutSliders(int from, int to) {
        $$(logs).findBy(text("(From):")).shouldHave(text("Range 2(From):" + String.valueOf(from) + " link clicked")).shouldBe(visible);
        $$(logs).findBy(text("(To):")).shouldHave(text("Range 2(To):" + String.valueOf(to) + " link clicked")).shouldBe(visible);
    }
}
