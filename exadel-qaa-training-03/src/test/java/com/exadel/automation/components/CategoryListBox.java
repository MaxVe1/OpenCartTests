package com.exadel.automation.components;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryListBox extends BaseComponent {
    public static final String DEFAULT_SELECTOR = "ul.hmenu.hmenu-visible";

    //Added by MV
    private static String ACCMAIN_SELECTOR = "#top > div.container > div.nav.float-end > ul > li:nth-child(2)";
    
    private static String ITEMS_SELECTOR = "a.hmenu-item";
    private static String ITEMS_SELECTOR_BY_NAME = "//a[@class='hmenu-item' and contains(., '%s')]";

    public CategoryListBox(WebElement holder) {
    	super(holder);
    }

    public List<String> getCategoryNames(){
    	return holder.findElements(By.cssSelector(ITEMS_SELECTOR))
    			.stream().map(WebElement::getText).collect(Collectors.toList());
    }
   
    public void selectCategoryByName(String...categoryNames) {
        Arrays.asList(categoryNames).stream()
            .forEachOrdered(name -> {
                holder.findElement(By.xpath(String.format(ITEMS_SELECTOR_BY_NAME , name)))
                .click();                
                }
            );
    }
}
