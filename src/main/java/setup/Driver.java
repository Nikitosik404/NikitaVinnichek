package setup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

import static enums.mobile.AdditionalCaps.APP_ACTIVITY_CAP;
import static enums.mobile.AdditionalCaps.APP_PACKAGE_CAP;
import static enums.mobile.Browsers.CHROME;
import static enums.mobile.Browsers.SAFARI;
import static enums.mobile.CommonConstants.HTTPS_PREFIX;
import static enums.mobile.CommonConstants.PATH_TO_RESOURCES;
import static enums.mobile.ErrorsTexts.UNCLEAR_TYPE_OF_MOBILE_APP;
import static enums.mobile.ErrorsTexts.UNKNOWN_MOBILE_PLATFORM;

public class Driver {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;
    private static Device device;

    private static String AUT;
    protected static String SUT;
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE_NAME;
    private static String UDID;
    private static String APP_PACKAGE;
    private static String APP_ACTIVITY;

    protected void getConfig(String pathToConfig) throws FileNotFoundException {
        JsonObject jDevice = new JsonParser().parse(new FileReader(pathToConfig)).getAsJsonObject();
        device = new Gson().fromJson(jDevice, Device.class);

        AUT = device.aut == null ? null :  PATH_TO_RESOURCES + device.aut;
        SUT = device.sut == null ? null : HTTPS_PREFIX + device.sut;
        TEST_PLATFORM = device.test_platform;
        DRIVER = device.driver;
        DEVICE_NAME = device.device_name;
        UDID = device.udid;
        APP_PACKAGE = device.app_package;
        APP_ACTIVITY = device.app_activity;
    }

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = CHROME.browser;
                break;
            case "iOS":
                capabilities.setCapability(MobileCapabilityType.UDID,UDID);
                browserName = SAFARI.browser;
                break;
            default:
                throw new Exception(UNKNOWN_MOBILE_PLATFORM.text);
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            if(device.isRemote) {
                capabilities.setCapability(APP_PACKAGE_CAP.capName, APP_PACKAGE);
                capabilities.setCapability(APP_ACTIVITY_CAP.capName, APP_ACTIVITY);
            } else {
                File app = new File(AUT);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            }
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception(UNCLEAR_TYPE_OF_MOBILE_APP.text);
        }
        System.out.println(capabilities);
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);

        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }

}