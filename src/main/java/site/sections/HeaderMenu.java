package site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;

public class HeaderMenu extends Section {

    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    @Css(".profile-photo [ui='label']")
    private Text loggedUserName;

    @Css(".m-l8") public Menu navigation;
}
