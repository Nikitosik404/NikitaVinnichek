package hw5;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttacmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElements;
import pageObjects.hw4.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.hw4.CheckBoxes.WATER;
import static enums.hw4.CheckBoxes.WIND;
import static enums.hw4.DropdownElements.YELLOW;
import static enums.hw4.RadioButtons.SELEN;
import static enums.hw4.Titles.HOME_PAGE;

@Feature("UI Tests")
@Story("Service And Dates Pages Testing")
@Listeners(AllureAttacmentListener.class)
public class FailedDifferentElementsPageTest extends SelenideTestBase {

    private HomePage homePage;
    private DifferentElements servicePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        servicePageSelenide = page(DifferentElements.class);
    }

    @Test
    public void differentElementsFailedPageTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkLoginTitle(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.clickHeadServiceButton();
        homePage.checkHeadServiceDropdownContains();

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.clickLeftServiceButton();
        homePage.checkLeftServiceDropdownContains();

        //7 Open through the header menu Service -> Different Elements Page
        homePage.clickHeadServiceButton();
        homePage.clickHeadServiceDifferentElements();

        //8 Check interface on Different elements page, it contains all needed elements
        servicePageSelenide.checkDifferentElementsPageExists();

        //9 Assert that there is Right Section
        servicePageSelenide.checkRightSection();

        //10 Assert that there is Left Section
        servicePageSelenide.checkLeftSection();

        //11 Select checkboxes (Water(0), Wind(2))
        servicePageSelenide.selectOneOfCheckBoxes(WATER);
        servicePageSelenide.selectOneOfCheckBoxes(WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePageSelenide.checkLogOfCheckBox(WATER, true);
        servicePageSelenide.checkLogOfCheckBox(WIND, true);


        //13 Select radio (Selen(3))
        servicePageSelenide.selectOneOfRadioButtons(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        servicePageSelenide.checkLogsRadioButton(SELEN);

        //15 Select in dropdown (Yellow(3))
        servicePageSelenide.selectOneOfDropdownElements(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value.
        servicePageSelenide.checkLogsDropdowns(YELLOW);


        //17 Unselect and assert checkboxes
        servicePageSelenide.selectOneOfCheckBoxes(WATER);
        servicePageSelenide.selectOneOfCheckBoxes(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        servicePageSelenide.checkLogOfCheckBox(WATER, false);
        servicePageSelenide.checkLogOfCheckBox(WIND, true);
    }
}
