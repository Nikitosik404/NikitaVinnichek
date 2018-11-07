package hw8;

import base.JDITestBaseClass;
import dataProviders.HomeworkDataProviders;
import json.MetalAndColorsData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static entities.User.PITER_CHALOVSKII;
import static enums.jdi.NavigateMenu.METALS_AND_COLORS;
import static site.JdiSite.*;

public class MetalsAndColorsPageTests extends JDITestBaseClass {

    @AfterMethod()
    public void tearDown() {
        homePage.clearCache();
    }

    @Test(dataProvider = "metalsAndColorsDataProvider", dataProviderClass = HomeworkDataProviders.class)
    public void metalsColorsTest(MetalAndColorsData data) {

        //1 Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        login(PITER_CHALOVSKII);

        //5 Open Metals And Colors Page by the Header menu
        navigate(METALS_AND_COLORS);

        //6 Fill Metals And Colors Form using data provided
        metalAndColorsPage.metalsAndColorsForm.fill(data);

        //7 Submit Metals And Colors Form
        metalAndColorsPage.metalsAndColorsForm.submit();

        //8 Assert the results list displayed is corresponding to the previously selected values
        metalAndColorsPage.checkFilled(data);
    }
}
