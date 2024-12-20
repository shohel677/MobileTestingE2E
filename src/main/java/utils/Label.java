package utils;

import elements.GenericObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends GenericObject {

    public Label(By locator, String name){
        super(locator, name);
    }
    public Label(WebElement element){
        super(element);
    }
}
