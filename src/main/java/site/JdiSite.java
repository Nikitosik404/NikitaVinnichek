package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import entities.User;
import enums.jdi.NavigateMenu;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import site.pages.HomePageJdi;
import site.pages.MetalAndColorsPageJdi;
import site.sections.Header;
import site.sections.LoginForm;

@JSite("https://epam.github.io/JDI/")
public class JdiSite extends WebSite {
    @FindBy(css = ".nav>li>a")
    public Menu<NavigateMenu> navigation;

    public static HomePageJdi homePage;
    public static MetalAndColorsPageJdi metalAndColorsPage;

    //=======================================WEB-ELEMENTS=================================================
    public static LoginForm loginForm;
    public static Header headerMenu;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    //=======================================METHODS=================================================
    @Step
    public static void navigate(NavigateMenu title) {
        headerMenu.navigation.clickOn(title.toString());
    }
}

