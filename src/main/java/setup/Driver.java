package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static enums.mobile.MobileCapabiltyType.APP_ACTIVITY;

public class Driver extends TestProperties {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;

    private static String AUT;
    protected static String SUT;
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE_NAME;
    private String appActivity;
    protected String udid;
    private String autoLaunch;

    protected void prepareUdid() throws IOException {
        udid = getProp("udid");
    }

    protected void prepareDriver() throws Exception {
        String resourcePath = "./src/main/resources/appiumHW/";
        String mobileAppName = getProp("aut");
        AUT = mobileAppName == null ? null : resourcePath + mobileAppName;
        System.out.println("aut=" + AUT); //Write Current AUT to console

        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "http://" + t_sut;
        System.out.println("sut=" + SUT); //Write Current SUT to console

        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("devicename");
        appActivity = getProp("appActivity");
        udid = getProp("udid");
        autoLaunch = getProp("autoLaunch");

        capabilities = new DesiredCapabilities();
        String browserName;

        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);

        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability(APP_ACTIVITY.value, appActivity);
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        switch (TEST_PLATFORM) {
            case "Android":
                if (driverSingle == null) {
                    driverSingle = new AndroidDriver(new URL(DRIVER), capabilities);
                }
                break;
            case "iOS":
                if (driverSingle == null) {
                    driverSingle = new IOSDriver(new URL(DRIVER), capabilities);
                }
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }


        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);

        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    //Singleton
    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }

}
