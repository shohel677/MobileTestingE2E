package pageObject;

import abstractComponents.AbstractComponents;
import Utils.Button;
import Utils.Label;
import org.openqa.selenium.By;

import java.time.Duration;

import static abstractComponents.GenericApp.logger;

public class HomeScreen extends AbstractComponents {

    private static final Label applicationTitle = new Label(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title']"), "Application title");
    private static final Button countryButton = new Button(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']"), "Country dropdown");

    public boolean isAppHomeScreen(){

        try {
            waitUntilElementToVisible(applicationTitle.getWrappedElement(), applicationTitle.getName(), 15);
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            return false;
        }
    }
    public void openCountryDropdown(){
        countryButton.automationClick();
    }
}
