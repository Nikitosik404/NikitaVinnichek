package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.HomePageSelenide;
import pageObjects.hw4.ServiceDatesPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.ProperTextHomePage.USER;
import static enums.Users.PITER_CHALOVSKII;

public class ServiceDatesPageInterfaceTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private ServiceDatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        datesPageSelenide = page(ServiceDatesPageSelenide.class);
    }

    @Test
    public void datesPageTest() {
        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkLoginTitle(USER.text);

        //5 Open through the header menu Service -> Dates Page
        homePageSelenide.clickHeadServiceButton();
        homePageSelenide.clickHeadServiceDates();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position


    }
}
