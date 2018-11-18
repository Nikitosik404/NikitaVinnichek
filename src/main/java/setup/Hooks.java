package setup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static enums.mobile.PropertiesFile.*;
import static setup.ManageMobileCloud.*;

public class Hooks extends Driver {

    @BeforeSuite(groups = "web.android")
    public void setUpWeb() throws Exception {
        setPropertyFileName(WEB_ANDROID);
        bookDevice(getProp("udid"), getProp("token"));
        prepareDriver();
    }

    @BeforeSuite(groups = "native.android")
    public void setUpNative() throws Exception {
        setPropertyFileName(NATIVE_ANDROID);
        bookDevice(getProp("udid"), getProp("token"));
        installApplication(getProp("udid"), getProp("token"), getProp("aut"));
        prepareDriver();
    }

    @BeforeSuite(groups = "web.ios")
    public void setUpWebIOS() throws Exception {
        setPropertyFileName(WEB_IOS);
        bookDevice(getProp("udid"), getProp("token"));
        prepareDriver();
    }

    @AfterSuite(groups = {"native.android", "web.ios", "web.android"}, alwaysRun = true)
    public void tearDown() throws Exception {
        cancelBooking(getProp("token"));
        driver().quit();
    }
}