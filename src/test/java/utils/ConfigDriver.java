package utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ConfigDriver {
    public static AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService appiumDriverLocalService;

    File iOSAppPath;
    File AndroidAppPath;

    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info").usingAnyFreePort();
        appiumDriverLocalService = builder.build();
        appiumDriverLocalService.start();
    }


    public void startiOSDriver(){
        File[] app = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "app"+File.separator + "iOS").listFiles();
        for (File item : app) {
            if (!(item.isHidden())) {
                iOSAppPath = item.getAbsoluteFile();
            }
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", "auto");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "auto");
        capabilities.setCapability("bundleId", "com.tesco.TescoClubcard");
        capabilities.setCapability("app", iOSAppPath.getAbsolutePath());
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole/deviceconsole");
        capabilities.setCapability("automationName", "xcuitest");
        capabilities.setCapability("showXcodeLog", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("xcodeOrgId","FEY6Z943BR");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        driver = new IOSDriver<MobileElement>(appiumDriverLocalService.getUrl(), capabilities);
    }


    public void startAndroidDriver(){
        File[] app = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "app"+File.separator + "Android").listFiles();
        for (File item : app) {
            if (!(item.isHidden())) {
                AndroidAppPath = item.getAbsoluteFile();
            }
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel");
        capabilities.setCapability(MobileCapabilityType.APP, AndroidAppPath.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("appPackage", "com.tesco.clubcardmobile");
        capabilities.setCapability("automationName", "uiautomator2");
        //capabilities.setCapability("app-wait-activity", "com.tesco.digitalclubcard.activity.WelcomeActivity");
        driver = new AndroidDriver<MobileElement>(appiumDriverLocalService.getUrl(), capabilities);
    }

    public void stopDriver() {
            driver.quit();
    }

    public static void stopServer() {
        appiumDriverLocalService.stop();
    }
}
