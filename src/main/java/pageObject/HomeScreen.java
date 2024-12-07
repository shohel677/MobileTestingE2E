package pageObject;

import Utils.Label;
import org.openqa.selenium.By;

import static abstractComponents.GenericApp.logger;
import static abstractComponents.WaitUtill.waitUntilElementToVisible;

public class HomeScreen {

    private static final Label homeScreenTitle = new Label(By.xpath("//android.widget.TextView[@text='WEBDRIVER']"), "Home screen title");
    public boolean isHomePageOpened(){
        try{
            waitUntilElementToVisible(homeScreenTitle.getWrappedElement(), homeScreenTitle.getName(), 15);
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            return false;

        }

    }

}
