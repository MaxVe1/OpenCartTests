package com.exadel.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class BasePage {
	protected Logger logger;
	protected WebDriver driver;

	private static final String HOME_LINK_SELECTOR = "div.nav-left a.nav-logo-link";

	/**
	 * Constructor injecting the WebDriver interface
	 * @param webDriver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.logger = LoggerFactory.getLogger(this.getClass());
		
//		PageFactory.initElements(driver, this);
		 PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
	}

	public HomePage navigateToHomePage(){
	  List<WebElement> homeLink = driver.findElements(By.cssSelector(HOME_LINK_SELECTOR));
	  if (homeLink.size() > 0) { homeLink.get(0).click(); }
	  
	  return new HomePage(driver);
	}
}
