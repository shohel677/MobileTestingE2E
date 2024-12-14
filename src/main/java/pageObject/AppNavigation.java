package pageObject;

import utils.Label;
import org.openqa.selenium.By;

import java.time.Duration;

public class AppNavigation {

    private static final Label dragAndDropMenu = new Label(By.xpath("//android.widget.TextView[@text='Drag']"), "Drag and drop menu");
    private static final Label swipeMenu = new Label(By.xpath("//android.widget.TextView[@text='Swipe']"), "Swipe menu");

    public static void navigateToDragAndDropScreen(){
        dragAndDropMenu.isDisplayed(Duration.ofSeconds(5));
        dragAndDropMenu.click();
    }
    public static void navigateToSwipeScreen(){
        swipeMenu.isDisplayed(Duration.ofSeconds(5));
        swipeMenu.click();
    }
}
