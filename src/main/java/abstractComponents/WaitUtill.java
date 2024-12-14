package abstractComponents;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static abstractComponents.GenericApp.mobileDriver;
import static abstractComponents.GenericApp.logger;

public class WaitUtill {
    static WebDriverWait wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(10));

    public static void waitUntilElementToVisible(String stringXpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(stringXpath)));
        logger.info("Waiting until element visible");
    }
    public static void waitUntilElementToVisible(WebElement element, String name, int waitInSeconds){
        WebDriverWait waitWithTime = new WebDriverWait(mobileDriver, Duration.ofSeconds(waitInSeconds));
        waitWithTime.until(ExpectedConditions.visibilityOf(element));
        logger.info("Waiting until element visible: {}", name);
    }
    public static void waitUntilElementToVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Waiting until element visible");
    }

    public static void waitFor(int seconds){

        int millis = seconds*3000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
