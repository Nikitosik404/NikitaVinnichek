package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.Dates;
import pageObjects.hw4.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

public class ServiceDatesPageInterfaceTest extends SelenideTestBase {

    private HomePage homePage;
    private Dates datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        datesPageSelenide = page(Dates.class);
    }

    @Test
    public void datesPageTest() {
        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkLoginTitle(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        homePage.clickHeadServiceButton();
        homePage.clickHeadServiceDates();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position (From = 0, To = 100)
        datesPageSelenide.moveLeftSlider(0);
        datesPageSelenide.moveRightSlider(100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(0, 100);

        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPageSelenide.moveLeftSlider(0);
        datesPageSelenide.moveRightSlider(0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(0, 0);

        //10. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPageSelenide.moveRightSlider(100);
        datesPageSelenide.moveLeftSlider(100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(100, 100);

        //12. Using drag-and-drop set Range sliders.
        datesPageSelenide.moveLeftSlider(30);
        datesPageSelenide.moveRightSlider(70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkInfoInLogAboutSliders(30, 70);


        //Found a bug: after moving both sliders to the same position,
        // moving the left slider is logged as moving the right slider.
    }
}
