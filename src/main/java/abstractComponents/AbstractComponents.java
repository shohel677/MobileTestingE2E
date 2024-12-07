package abstractComponents;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import static abstractComponents.GenericApp.mobileDriver;

public class AbstractComponents {

    public static void scrollMobileScreen(WebElement scrollableArea, WebElement scrollFor, String scrollDirection){
        boolean isFound = false;

        while (!isFound) {
            try {
                if (scrollFor.isDisplayed()) {
                    isFound = true;
                }
                else{
                    scroll(scrollableArea, scrollDirection);
                }
            } catch (Exception e) {
                scroll(scrollableArea, scrollDirection);
            }
        }
    }
    private static void scroll(WebElement scrollableArea, String scrollDirection){
        mobileDriver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) scrollableArea).getId(),
                "direction", scrollDirection,
                "percent", 0.75
        ));
    }
}
