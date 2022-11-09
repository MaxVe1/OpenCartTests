package com.exadel.automation;

import com.exadel.automation.config.SuiteConfiguration;
import com.exadel.automation.listeners.AllureListener;
import com.exadel.automation.utils.PropertiesLoader;
import com.exadel.automation.utils.WebDriverManager;
import com.rmn.testrail.entity.TestResult;
import com.rmn.testrail.entity.TestRun;

import io.qameta.allure.Step;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Base class for TestNG-based test classes
 */
@Listeners({AllureListener.class})
public class BaseTest {

    public final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    protected static URL gridHubUrl = null;
    protected static String baseUrl;
    protected static Capabilities capabilities;
    protected static PropertiesLoader propertiesLoader;
    protected static TestRun testRun;
    protected static String testCaseId;
    protected static int testRunId;
    protected static String msg;
    protected static TestResult testResult;
    protected Properties env;
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void initTestSuite() throws IOException {
        SuiteConfiguration config = new SuiteConfiguration();
        WebDriverManager.setupWebDriver(config);
        
       baseUrl = config.getProperty("site.url");
        //baseUrl = config.getProperty("https://demo.opencart.com/");
        //baseUrl = "https://demo.opencart.com/";   //OK Works Directly
        capabilities = config.getCapabilities();
        propertiesLoader = new PropertiesLoader();

        env = new Properties();
        env.setProperty("Base URL", baseUrl);
    }

    @BeforeMethod
    @Step("Browser initialization")
    public void initWebDriver(Method method) {
        driver = WebDriverManager.getDriver(capabilities);
//        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterSuite(alwaysRun = true)
    @Step("Browser cleanup")
    public void tearDown() {
        WebDriverManager.dismissAll();

        File file = Paths.get(System.getProperty("user.dir"), "/target/allure-results").toAbsolutePath().toFile();
        if (!file.exists()) {
            logger.info("Created dirs: " + file.mkdirs());
        }
        try (FileWriter out = new FileWriter("./target/allure-results/environment.properties")) {
            env.store(out, "Environment variables for report");
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
