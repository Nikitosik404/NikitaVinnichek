package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import enums.jdi.Even;
import enums.jdi.Odds;
import org.openqa.selenium.support.FindBy;

public class Summary extends Section {
    //=======================================WEB-ELEMENTS=================================================


    @FindBy(css = "#even-selector p")
    Selector<Even> even;

    @FindBy(css = "#odds-selector p")
    Selector<Odds> odds;

    //=======================================METHODS=================================================

    public void select(int number) {
        if (number % 2 == 0) {
            even.select(String.valueOf(number));
        } else {
            odds.select(String.valueOf(number));
        }
    }
}
