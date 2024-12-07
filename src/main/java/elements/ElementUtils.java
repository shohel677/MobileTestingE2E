package elements;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static abstractComponents.GenericApp.mobileDriver;

public class ElementUtils {

    public static void dragAndDrop(WebElement source, WebElement target){

        Point sourceLocation = source.getLocation();
        Dimension sourceSize = source.getSize();

        int startX = (int)(sourceLocation.x +  (sourceSize.getWidth() * .05));
        int startY = (int)(sourceLocation.y +  (sourceSize.getWidth() * .05));

        Point targetLocation = source.getLocation();
        Dimension targetSize = source.getSize();

        int endX = (int)(targetLocation.x +  (targetSize.getHeight() * .05));
        int endY = (int)(targetLocation.y +  (targetSize.getHeight() * .05));

        ((JavascriptExecutor) mobileDriver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY
        ));
    }
}
