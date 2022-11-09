package com.exadel.automation.pages;

import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.exadel.automation.components.*;

//import static com.exadel.automation.utils.ElementsUtil.waitForVisible;

public class SearchResultPage extends BasePage {
    private static final String SEARCH_INFO_SELECTOR = "h1 div.sg-row";
	
    private static final String SEARCH_INFO_TEXT_SELECTOR = SEARCH_INFO_SELECTOR + ">div:nth-child(1)";
    private static final String SEARCH_INFO_SORT_SELECTOR = SEARCH_INFO_SELECTOR + ">div:nth-child(2)";
	
    @FindBy(css=SEARCH_INFO_TEXT_SELECTOR)
	private WebElement searchResultText;

    @FindBy(css=SEARCH_INFO_SORT_SELECTOR)
    private WebElement searchResultSort;    
    
    @FindBy(css = SearchBar.DEFAULT_SELECTOR)
    private WebElement searchBarHolder;
 
    private SearchBar getSearchBar() {
    	return new SearchBar(searchBarHolder);
    }
    
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Categories Path")
    public String getCategoriesPath() {
    	String path =  searchResultText.getText()
    	        .replaceFirst(".* results for ", "");
        logger.info("Categories path: " + path);
        return path;
    }
    
    @Step("Get Results Count")
    public int getResultsCount() {
    	int count =  Integer.parseInt(searchResultText.getText()
    	            .replaceFirst("[\\d-]* of [^\\d]*", "")
    	            .replaceFirst(" results.*", "")
    	            .replace(",", "")
    	        );
        logger.info("Results count: " + count);
        return count;
    }   
    
    @Step("Search By Text")
    public SearchResultPage searchByText(String searchText) {
        logger.info("Search By Text: " + searchText);
        getSearchBar().setSearchText(searchText).startSearch();
        return this;
    }    
    
}
