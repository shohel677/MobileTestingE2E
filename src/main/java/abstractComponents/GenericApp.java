package abstractComponents;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;

public class GenericApp {
    public static Logger logger = LogManager.getLogger();

    public static AppiumDriverLocalService appiumService;
    public static AppiumDriver driver;
    private static final String PLATFORM_NAME = "Android";
    private static final String DEVICE_NAME = "Shohel Device";

    public static AppiumDriver instanceApplication(){

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        logger.info("Appium server started successfully.");

        if(driver == null){
            if(PLATFORM_NAME.equals("Android")){

                String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator +"applications"+ File.separator+ "General-Store.apk";

                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName(DEVICE_NAME);
                options.setApp(appPath);

                URL mobileServerURL = appiumService.getUrl();

                driver = new AndroidDriver(mobileServerURL, options);
                logger.info("Android driver initialized successfully!");
            }
            else if(PLATFORM_NAME.equals("iOS")){
                logger.info("IOS driver initialized successfully!");
            }
        }
        return driver;
    }
    public static void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Driver quit successfully.");
        }

        if (appiumService != null) {
            appiumService.stop();
            System.out.println("Appium server stopped successfully.");
        }
    }
}
