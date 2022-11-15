package com.exadel.automation.components;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryListBox extends BaseComponent {
    public static final String DEFAULT_SELECTOR = "a.list-group-item.active";

    //Added by MV
    private static String ACCMAIN_SELECTOR = "#top > div.container > div.nav.float-end > ul > li:nth-child(2)";
    
    private static String ITEMS_SELECTOR = "a.hmenu-item";
    private static String ITEMS_SELECTOR_MV = "a.list-group-item.active";
    private static String ITEMS_SELECTOR_BY_NAME = "//a[@class='hmenu-item' and contains(., '%s')]";

    private static final String CAM1_PRICE_OLD = "#product-list > div:nth-child(1) > form > div > div.content > div.description > div > span.price-old";
    private static final String CAM1_PRICE_NEW = "#product-list > div:nth-child(1) > form > div > div.content > div.description > div > span.price-new";
    private static final String CAM2_PRICE_TAX = "#product-list > div:nth-child(2) > form > div > div.content > div.description > div > span.price-tax";
    private static String CURR_SELECTOR_MV = "#form-currency > div > a > strong";
    public CategoryListBox(WebElement holder) {
    	super(holder);
    }

    public List<String> getCategoryNames(){
    	return holder.findElements(By.cssSelector(ITEMS_SELECTOR_MV))
    			.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<String> getCurrencyNames(){
        return holder.findElements(By.cssSelector(CURR_SELECTOR_MV))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<String> getIPhonePriceNames(){return holder.findElements(By.cssSelector("#content > div.row.mb-3 > div:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > h2 > span"))
               .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getCam1_PriceOld(){
             return holder.findElements(By.cssSelector(CAM1_PRICE_OLD))
            .stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<String> getCam1_PriceNew(){
        return holder.findElements(By.cssSelector(CAM1_PRICE_NEW))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<String> getCam2_PriceTax(){
        return holder.findElements(By.cssSelector(CAM2_PRICE_TAX))
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
