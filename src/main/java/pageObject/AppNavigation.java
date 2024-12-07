package pageObject;

import Utils.Label;
import org.openqa.selenium.By;

import java.time.Duration;

public class AppNavigation {

    private static final Label dragAndDropMenu = new Label(By.xpath("//android.widget.TextView[@text='Drag']"), "Drag and drop menu");

    public void navigateToDragAndDropScreen(){
        dragAndDropMenu.isDisplayed(Duration.ofSeconds(5));
        dragAndDropMenu.click();
    }
}
