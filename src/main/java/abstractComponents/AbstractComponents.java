package abstractComponents;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static abstractComponents.GenericApp.driver;
import static abstractComponents.GenericApp.logger;


public class AbstractComponents {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void waitUntilElementToVisible(String stringXpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(stringXpath)));
        logger.info("Waiting until element visible");
    }
    public void waitUntilElementToVisible(WebElement element, String name, int seconds){
        WebDriverWait waitWithTime = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        waitWithTime.until(ExpectedConditions.visibilityOf(element));
        logger.info("Waiting until element visible: {}", name);
    }
    public void waitUntilElementToVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Waiting until element visible");
    }
}
