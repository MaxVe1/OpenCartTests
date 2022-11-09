package com.exadel.automation.pages;

import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exadel.automation.components.*;

//import static com.exadel.automation.utils.ElementsUtil.waitForVisible;

public class HomePage extends BasePage {
	
    private static final String CATEGORIES_OPENER_LINK_SELECTOR = "div.nav-left a#nav-hamburger-menu";
    private static final String CATEGORIES_CLOSER_LINK_SELECTOR = "div.nav-sprite.hmenu-close-icon"; 
    
    @FindBy(css = CATEGORIES_OPENER_LINK_SELECTOR)
    private WebElement categoriesOpener;

    @FindBy(css = CATEGORIES_CLOSER_LINK_SELECTOR)
    private WebElement categoriesCloser;    
    
    @FindBy(css = CategoryListBox.DEFAULT_SELECTOR)
	private WebElement categoriesListBoxHolder;

    @FindBy(css = SearchBar.DEFAULT_SELECTOR)
    private WebElement searchBarHolder;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private CategoryListBox getCategoriesListBox() {
        categoriesOpener.click();
    	return new CategoryListBox(categoriesListBoxHolder);
    }

    private SearchBar getSearchBar() {
    	return new SearchBar(searchBarHolder);
    }
    //MV Edition
//    @Step("Navigate to Login page1")
//    public LoginPage navigateToSelf1() {
//        List<WebElement> selfLink = driver.findElements(By.cssSelector("#top > div.container > div.nav.float-end > ul > li:nth-child(2)"));//LOGIN_PAGE_LINK_SELECTOR1));
//        if (selfLink.size() > 0) { selfLink.get(0).click(); }
//
//        return this;
//    }



    @Step("Get Categories List")
    public List<String> getCategoryNames() {
    	List<String> names =  getCategoriesListBox().getCategoryNames();
        logger.info("List categories: " + names);
        categoriesCloser.click();
        return names;
    }   
    
    @Step("Select Category")
    public SearchResultPage selectCategory(String...categoryNames) {
        logger.info("Select category: " + Arrays.toString(categoryNames));
        getCategoriesListBox().selectCategoryByName(categoryNames);
        return new SearchResultPage(driver);
    }

    @Step("Search By Text")
    public SearchResultPage searchByText(String searchText) {
        logger.info("Search By Text: " + searchText);
        getSearchBar().setSearchText(searchText).startSearch();
        return new SearchResultPage(driver);
    }    
    
    @Step("Search By Category and Text")
    public SearchResultPage searchByCategoryAndText(String categoryName, String searchText) {
        logger.info("Search By Category + Text: " + categoryName + " + " + searchText);
        getSearchBar().setCategory(categoryName).setSearchText(searchText).startSearch();
        return new SearchResultPage(driver);
    }
    
}
