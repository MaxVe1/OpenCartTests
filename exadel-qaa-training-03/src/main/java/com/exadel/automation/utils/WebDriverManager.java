package com.exadel.automation.utils;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.exadel.automation.config.SuiteConfiguration;

public class WebDriverManager {

	private static Optional<String> gridURL;
	
    public static void setupWebDriver(SuiteConfiguration suiteConfiguration) throws IOException {
    	WebDriverManager.gridURL = Optional.of(suiteConfiguration.getProperty("grid.url"));
 
    	switch (suiteConfiguration.getCapabilities().getBrowserName()) {
            case "firefox":
                FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX)
                    .version(suiteConfiguration.getProperty("firefox-driver.version")).setup();
                break;
            case "MicrosoftEdge":
                EdgeDriverManager.getInstance(DriverManagerType.EDGE)
                    .version(suiteConfiguration.getProperty("edge-driver.version")).setup();
                break;
            case "internet explorer":
                InternetExplorerDriverManager.getInstance(DriverManagerType.IEXPLORER)
                    .version(suiteConfiguration.getProperty("ie-driver.version")).setup();
                break;
            case "chrome":
            default:
                ChromeDriverManager.getInstance(DriverManagerType.CHROME)
                    .version(suiteConfiguration.getProperty("chrome-driver.version")).setup();
        }
    }
    
    public static WebDriver getDriver(Capabilities capabilities) {
    	try {
			return WebDriverPool.DEFAULT.getDriver(new URL(gridURL.orElse("")), capabilities);
		} catch (MalformedURLException | UnreachableBrowserException e) {
			return WebDriverPool.DEFAULT.getDriver(capabilities);
		}
    }

    public static void dismissDriver(WebDriver driver) {
    	WebDriverPool.DEFAULT.dismissDriver(driver);
    }    
    
    public static void dismissAll() {
    	WebDriverPool.DEFAULT.dismissAll();
    }
}
