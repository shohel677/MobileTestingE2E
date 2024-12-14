package abstractComponents;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class GenericApp {
    public static Logger logger = LogManager.getLogger();

    public static AppiumDriverLocalService appiumService;
    public static AppiumDriver mobileDriver;
    private static final String PLATFORM_NAME = "Android";
    private static final String DEVICE_NAME = "Shohel Device";

    public static AppiumDriver instanceMobileDriver(){

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        logger.info("Appium server started successfully.");

        if(mobileDriver == null){
            if(PLATFORM_NAME.equals("Android")){

                String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator +"applications"+ File.separator+ "android.wdio.native.app.v1.0.8.apk";

                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName(DEVICE_NAME);
                options.setApp(appPath);
                options.setNewCommandTimeout(Duration.ofSeconds(300));

                URL mobileServerURL = appiumService.getUrl();

                mobileDriver = new AndroidDriver(mobileServerURL, options);
                logger.info("Android driver initialized successfully!");
            }
            else if(PLATFORM_NAME.equals("IOS")){
                logger.info("IOS driver initialized successfully!");
            }
        }
        return mobileDriver;
    }
    public static void mobileTearDown() {

        if (mobileDriver != null) {
            mobileDriver.quit();
            mobileDriver = null;
            logger.info("Driver quit successfully.");
        }

        if (appiumService != null) {
            appiumService.stop();
            logger.info("Appium server stopped successfully.");
        }
    }
}
