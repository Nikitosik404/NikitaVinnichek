package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.HomePageSelenide;
import pageObjects.hw4.ServiceDifferentElementsPageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.ProperTextHomePage.USER;
import static enums.Users.PITER_CHALOVSKII;

public class ServiceDifferentElementsPageInterfaceTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private ServiceDifferentElementsPageSelenide servicePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        servicePageSelenide = page(ServiceDifferentElementsPageSelenide.class);
    }

    @Test
    public void differentElementsPageTest() {

        //1 Open test site by URL
        homePageSelenide.openPage();

        //2 Assert Browser title
        homePageSelenide.checkTitle();

        //3 Perform login
        homePageSelenide.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkLoginTitle(USER.text);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.clickHeadServiceButton();
        homePageSelenide.checkHeadServiceDropdownContains();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.clickLeftServiceButton();
        homePageSelenide.checkLeftServiceDropdownContains();

        //7 Open through the header menu Service -> Different Elements Page
        homePageSelenide.clickHeadServiceButton();
        homePageSelenide.clickHeadServiceDifferentElements();

        //8 Check interface on Different elements page, it contains all needed elements
        servicePageSelenide.checkDifferentElementsPageExists();

        //9 Assert that there is Right Section
        servicePageSelenide.checkRightSection();

        //10 Assert that there is Left Section
        servicePageSelenide.checkLeftSection();

        //11-12 Select checkboxes (Water(0), Wind(2))
        //Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        servicePageSelenide.selectOneOfCheckBoxes(0);
        servicePageSelenide.selectOneOfCheckBoxes(2);


        //13-14 Select radio (Selen(3))
        //Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        servicePageSelenide.selectOneOfRadioButtons(3);

        //15-16 Select in dropdown (Yellow(3))
        //Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        servicePageSelenide.selectOneOfDropdownElements(3);

        //17-18 Unselect and assert checkboxes
        //Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePageSelenide.selectOneOfCheckBoxes(0);
        servicePageSelenide.selectOneOfCheckBoxes(2);
    }

}
