package elements;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static abstractComponents.GenericApp.mobileDriver;

public class ElementUtils {


    private static Point getPoint(WebElement element){
        return element.getLocation();
    }
    private static Dimension getDimension(WebElement element){
        return element.getSize();
    }
    private static int elementWidth(WebElement element){
        return getDimension(element).getWidth();
    }
    private static int elementHeight(WebElement element){
        return getDimension(element).getHeight();
    }
    private static int getMidX(WebElement element){

        return (int)(getPoint(element).x +  (elementWidth(element) * .5));
    }
    private static int getMidY(WebElement element){

        return (int)(getPoint(element).y +  (elementHeight(element) * .5));
    }

    public static void dragAndDrop(WebElement source, WebElement target){

        int startX = getMidX(source);
        int startY = getMidY(source);

        int endX =  getMidX(target);
        int endY = getMidY(target);

        mobileDriver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX,
                "startY", startY,
                "endX", endX,
                "endY", endY,
                "speed", 1300
        ));
    }
    public static void swipe(WebElement elementToSwipe, String direction, double swipePercentage){

        int left = getMidX(elementToSwipe);
        int top = getMidY(elementToSwipe);
        int width = elementWidth(elementToSwipe) - 100;
        int height = elementHeight(elementToSwipe) -100;
        System.out.println(left);
        System.out.println(top);
        System.out.println(width);
        System.out.println(height);

        ((JavascriptExecutor) mobileDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", left,
                "top", top,
                "width", width,
                "height", height,
                "direction", direction,
                "percent", swipePercentage
        ));
    }

    public static void scroll(){
        Dimension size = mobileDriver.manage().window().getSize();
        Point point = mobileDriver.manage().window().getPosition();
        int width = size.getWidth()-50;
        int height = size.getHeight() - 50;
        int left =(int)( point.x +  (width *.5));
        int top = (int)( point.y +  (height *.5));
        System.out.println(left);
        System.out.println(top);
        System.out.println(width);
        System.out.println(height);
      ((JavascriptExecutor) mobileDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(

                "left", left,
                "top", top,
                "width", width,
                "height", height,
                "direction", "up",
                "percent", .5
        ));
    }

}
