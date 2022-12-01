package com.exadel.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchBar extends BaseComponent {
    public static final String DEFAULT_SELECTOR = "form.nav-searchbar";
    
    private static String CATEGORIES_SELECTOR = "select#searchDropdownBox"; 
    private static String SEARCH_BOX_SELECTOR = "input.nav-input[type='text']";
    private static String SUBMIT_BUTTON_SELECTOR = "input.nav-input[type='submit']";
    
    private Select categories;
    private WebElement searchBox;
    private WebElement submitButton;
    
    public SearchBar(WebElement holder) {
    	super(holder);
    	this.categories = new Select(holder.findElement(By.cssSelector(CATEGORIES_SELECTOR)));
    	this.searchBox = holder.findElement(By.cssSelector(SEARCH_BOX_SELECTOR));
    	this.submitButton = holder.findElement(By.cssSelector(SUBMIT_BUTTON_SELECTOR));
    }

    public SearchBar setCategory(String categoryName){
        categories.selectByVisibleText(categoryName);
        return this;
    }    
    
    public SearchBar setSearchText(String searchText){
    	searchBox.sendKeys(searchText);
    	return this;
    }
   
    public void startSearch() {
    	submitButton.click();
    }
}
