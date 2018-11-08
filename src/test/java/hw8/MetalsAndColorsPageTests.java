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

    @Test(dataProvider = "metalsAndColorsDataProviderWithTypeToken", dataProviderClass = HomeworkDataProviders.class)
    public void metalsColorsTest(MetalAndColorsData data) {
        // TODO I can't execute this test because of the error below:
        //  [Utils] [ERROR] [Error] java.io.FileNotFoundException: src\test\resources\JDI_ex8_metalsColorsDataSet.json (The system cannot find the file specified)
        //  at java.io.FileInputStream.open0(Native Method)
        //  at java.io.FileInputStream.open(FileInputStream.java:195)
        //  at java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:138)
        //  at java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:93)
        //  at java.io.FileReader.&lt;init&gt;(FileReader.java:58)


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
