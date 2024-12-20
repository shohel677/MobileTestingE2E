package utils;

import elements.GenericObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static abstractComponents.GenericApp.logger;


public class Input extends GenericObject {

    public Input(By locator, String name){
        super(locator, name);
    }
    public Input(WebElement element){
        super(element);
    }

    public void clearAndType(String text) {
        logger.info("clear and type %s, set value: %s", getName(), text);
        getWrappedElement().clear();
        getWrappedElement().sendKeys(text);
    }
}

