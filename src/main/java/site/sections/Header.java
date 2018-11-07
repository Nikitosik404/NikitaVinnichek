package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;

public class Header extends Section {

    //=======================================WEB-ELEMENTS=================================================
    @Css(".m-l8") public Menu navigation;
}
