package com.exadel.automation.components;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class YCategoryListBox extends TypifiedElement {
    public static final String DEFAULT_SELECTOR = "div.categories-list-box";
    
    private static String ITEMS_SELECTOR = "dt.cate-name";
    private static String ITEMS_SELECTOR_BY_NAME = "//dt[@class='cate-name' and contains(., '%s')]";

    public YCategoryListBox(WebElement wrappedElement) {
    	super(wrappedElement);
    }

    public List<String> getCategoryNames(){
    	return getWrappedElement().findElements(By.cssSelector(ITEMS_SELECTOR))
    			.stream().map(WebElement::getText).collect(Collectors.toList());
    }
   
    public void selectCategoryByName(String categoryName) {
    	getWrappedElement().findElement(By.xpath(String.format(ITEMS_SELECTOR_BY_NAME , categoryName)))
    		.click();
    }
}
