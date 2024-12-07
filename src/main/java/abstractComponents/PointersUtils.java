package abstractComponents;

import org.openqa.selenium.Dimension;

import static abstractComponents.GenericApp.mobileDriver;

public class PointersUtils {
    public static Dimension getSize(){
        return mobileDriver.manage().window().getSize();
    }
    public static int getWidth(){
        return getSize().getWidth();
    }
    public static int getHeight(){
        return getSize().getHeight();
    }
    public static int getTop(Double topPointInPercent){
        return (int)(getHeight() * topPointInPercent);
    }
    public static int getLeft(Double leftPointInPercent){
        return (int)(getWidth() * leftPointInPercent);
    }
}
