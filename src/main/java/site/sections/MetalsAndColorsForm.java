package site.sections;

import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import enums.jdi.ColorsList;
import enums.jdi.MetalsList;
import enums.jdi.Nature;
import json.MetalAndColorsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalsAndColorsForm extends Form<MetalAndColorsData> {

    //=======================================WEB-ELEMENTS=================================================
    @FindBy(id = "summary-block")
    private Summary summary;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    private IDropDown<ColorsList> colors;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"),
            jexpand = @JFindBy(css = ".caret"))
    private IDropDown<MetalsList> metals;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private IDropDown vegetables;

    @FindBy(css = "#elements-checklist p")
    private ICheckList<Nature> nature = new CheckList<Nature>() {
        @Override
        protected boolean isSelectedAction(WebElement el) {
            return el.findElement(By.tagName("input")).getAttribute("checked") != null;
        }
    };

    @FindBy(id = "submit-button")
    private Button submitButton;

    private final String DEFAULT_VEGETABLE_ITEM = "Vegetables";

    @FindBy(css = ".panel-body-list.results> li")
    private TextList results;

    //==============================================================METHODS==============================================
    @Override
    public void fill(MetalAndColorsData data) {
        fillSummary(data.getSummary());
        fillElements(data.getElements());
        colors.select(data.getColor());
        metals.select(data.getMetal());
        fillVegetables(data.getVegetables());
    }

    private void fillSummary(int[] dataSummary) {
        for (int i : dataSummary) {
            summary.select(i);
        }
    }

    private void fillElements(String[] dataElements) {
        for (String element : dataElements) {
            nature.select(element);

        }
    }

    private void fillVegetables(List<String> dataVegetables) {
        if (!dataVegetables.contains(DEFAULT_VEGETABLE_ITEM)) {
            vegetables.select(DEFAULT_VEGETABLE_ITEM);
        }
        for (String vegetable : dataVegetables) {
            if (vegetable.equals(DEFAULT_VEGETABLE_ITEM)) continue;
            vegetables.select(vegetable);
        }
    }

    public void submit() {
        submitButton.click();
    }
}
