package pageObject;

import Utils.Button;
import Utils.Input;
import Utils.Label;
import abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static abstractComponents.GenericApp.mobileDriver;
import static abstractComponents.GenericApp.logger;
import static abstractComponents.WaitUtill.waitUntilElementToVisible;

public class LoginScreen extends AbstractComponents {

    private static final Label applicationTitle = new Label(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/toolbar_title']"), "Application title");
    private static final Button countryButton = new Button(By.xpath("//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']"), "Country dropdown");
    private static final Label countrySelect = new Label(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Bangladesh']"), "Select country");
    private static final Input nameField = new Input(By.className("android.widget.EditText"), "Name Field");
    private static final Button letsShopButton = new Button(By.className("android.widget.Button"), "Let's shop");

    public boolean isLoginScreen(){

        try {
            waitUntilElementToVisible(applicationTitle.getWrappedElement(), applicationTitle.getName(), 15);
            return true;
        }catch (Exception e){
            logger.info(e.getMessage());
            return false;
        }
    }

    public void openCountryDropdown() {
        WebElement scrollableArea = mobileDriver.findElement(By.className("android.widget.ListView"));
        WebElement scrollFor = countrySelect.getWrappedElement();

        countryButton.click();
        scrollMobileScreen(scrollableArea, scrollFor, "down");

        countrySelect.click();
    }


    public void enterName(){
        nameField.clearAndType("Shohel");
    }
    public void clickLetsShopButton(){
        letsShopButton.click();
    }

}
