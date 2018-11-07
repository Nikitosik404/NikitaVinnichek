package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import json.MetalAndColorsData;
import org.openqa.selenium.support.FindBy;
import site.sections.MetalsAndColorsForm;

import static org.testng.Assert.assertEquals;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPageJdi extends WebPage {

    //=======================================WEB-ELEMENTS=================================================
    @FindBy(css = ".panel-body-list.results> li")
    private TextList results;

    @FindBy(css=".form")
    public MetalsAndColorsForm metalsAndColorsForm;

    //==================================================METHODS=========================================================
    public void checkFilled(MetalAndColorsData data) {
        assertEquals(data.asResult(), results.getTextList());
    }
}


