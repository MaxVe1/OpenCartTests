package com.exadel.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewUserPopup extends BaseComponent {
    public static final String DEFAULT_SELECTOR = "div.ui-newuser-layer-dialog";
    
    private static String CLOSE_ICON = "a.close-layer";
    
    public NewUserPopup(WebElement holder) {
    	super(holder);
    }

    public void close() {
    	holder.findElement(By.cssSelector(CLOSE_ICON)).click();
    }
}
