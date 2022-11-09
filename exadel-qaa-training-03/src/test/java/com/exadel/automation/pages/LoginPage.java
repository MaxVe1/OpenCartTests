package com.exadel.automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import java.lang.*;
import static com.exadel.automation.utils.ElementsUtil.waitForVisible;

import java.util.List;

public class LoginPage extends BasePage {

    private static final String LOGIN_PAGE_LINK_SELECTOR = "div#nav-tools a#nav-link-accountList";

    //MV Edition
    private static final String LOGIN_PAGE_LINK_SELECTOR1 = "#top > div.container > div.nav.float-end > ul > li:nth-child(2)";
    private static final String EMAIL_SELECTOR_MV = "#input-email";

    private static final String PSW_SELECTOR_MV = "#input-password";
    private static final String CONTINUE_BUTTON_SELECTOR = "input#continue";

    private static final String CONTINUE_BUTTON_SELECTOR_MV = "#form-login > button";
    private static final String PASSWORD_SELECTOR = "input#ap_password";
    private static final String SIGNIN_BUTTON_SELECTOR = "input#signInSubmit"; 
    private static final String LOGIN_ERROR_SELECTOR = "div.a-alert-container div.a-alert-content";
    private static final String NEED_HELP_SELECTOR = "div.a-expander-container";
    private static final String NEED_HELP_LINK_SELECTOR = "a.a-expander-header";
    
    private static final String HEADER_SELECTOR = "#headingText";

    private static final String ADD1_BUTTON_SELECTOR = "#product-list > div:nth-child(1) > form > div > div.content > div.button-group > button:nth-child(2)";
    private static final String ADD2_BUTTON_SELECTOR = "#product-list > div:nth-child(2) > form > div > div.content > div.button-group > button:nth-child(2) > i";

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
    @FindBy(css = EMAIL_SELECTOR_MV)
    private WebElement email;

    @FindBy(css = CONTINUE_BUTTON_SELECTOR)
    private WebElement continueButton;

    //@FindBy(css = PASSWORD_SELECTOR)
    //private WebElement password;

    @FindBy(css = PSW_SELECTOR_MV)
    private WebElement password;
    @FindBy(css = SIGNIN_BUTTON_SELECTOR)
    private WebElement signinButton;


    @FindBy(css = ADD1_BUTTON_SELECTOR)
    private WebElement add1Button;

    @FindBy(css = ADD2_BUTTON_SELECTOR)
    private WebElement add2Button;
    @FindBy(css = LOGIN_ERROR_SELECTOR)
    private WebElement loginError;

    @FindBy(css = NEED_HELP_SELECTOR)
    private WebElement needHelp;     
    
    @FindBys({@FindBy(css = NEED_HELP_SELECTOR), @FindBy(css = NEED_HELP_LINK_SELECTOR)})
    private WebElement needHelpLink;    
    
    @FindBy(css = HEADER_SELECTOR)
    private WebElement header;

    @Step("Navigate to Login page")
    public LoginPage navigateToSelf() {




        List<WebElement> selfLink = driver.findElements(By.cssSelector(LOGIN_PAGE_LINK_SELECTOR));
        if (selfLink.size() > 0) { selfLink.get(0).click(); }

        return this;
    }

    @Step("Navigate to Camera")
    public LoginPage navigateToCamera() {

        List<WebElement> selfLink = driver.findElements(By.cssSelector("#narbar-menu > ul > li:nth-child(7) > a"));//.click();//LOGIN_PAGE_LINK_SELECTOR1));
        if (selfLink.size() > 0) {
            selfLink.get(0).click();
        }


        //selfLink.click();
       // setTimeout(() -> System.out.println("test"), 7000);
//        List<WebElement> selfLink2 = driver.findElements(By.cssSelector("#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a"));//.click();//LOGIN_PAGE_LINK_SELECTOR1));
//        if (selfLink2.size() > 0) {
//            selfLink2.get(0).click();
//        }
        return this;
    }

    @Step("Navigate to iPhone")
    public LoginPage navigateToIphone() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#content > div.row > div:nth-child(2) > form > div > div.image > a > img"));//.click();//LOGIN_PAGE_LINK_SELECTOR1));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        //selfLink.click();
        // setTimeout(() -> System.out.println("test"), 7000);

        return this;
    }

    @Step("Navigate to Account")
    public LoginPage navigateToAccount() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > a > span"));//.click();//LOGIN_PAGE_LINK_SELECTOR1));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        //selfLink.click();
        // setTimeout(() -> System.out.println("test"), 7000);

        return this;
    }



    @Step("Navigate to Components")
    public LoginPage navigateToComponents() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#narbar-menu > ul > li:nth-child(3) > a"));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        //selfLink.click();
        // setTimeout(() -> System.out.println("test"), 7000);

        return this;
    }
    @Step("Navigate to Components")
    public LoginPage navigateToMonitor() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#narbar-menu > ul > li:nth-child(3) > div > div > ul > li:nth-child(2) > a"));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        //selfLink.click();
        // setTimeout(() -> System.out.println("test"), 7000);

        return this;
    }
    @Step("Navigate to Components")
    public LoginPage chooseDevice1() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#product-list > div:nth-child(1) > form > div > div.content > div.button-group > button:nth-child(2) > i"));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        return this;
    }

    @Step("Navigate to Components")
    public LoginPage chooseDevice2() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#product-list > div:nth-child(2) > form > div > div.content > div.button-group > button:nth-child(2) > i"));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        return this;
    }
    @Step("Navigate to Account")
    public LoginPage navigateToLogin() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a"));//.click();//LOGIN_PAGE_LINK_SELECTOR1));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        //selfLink.click();
        // setTimeout(() -> System.out.println("test"), 7000);

        return this;
    }
    //
    @Step("Enter email")
    public LoginPage enterEmail(String emailAddress) {
        waitForVisible(driver, By.cssSelector(EMAIL_SELECTOR_MV));
        logger.info("Enter email: " + emailAddress);
        email.sendKeys(emailAddress);
        return this;
    }


    @Step("Enter PSW")
    public LoginPage enterPSW(String pass) {
        waitForVisible(driver, By.cssSelector(PSW_SELECTOR_MV));
        logger.info("Enter psw: " + pass);
        password.sendKeys(pass);
        return this;
    }



//    @Step("Enter Password")
//    public LoginPage enterPassword(String pass) {
//        logger.info("Enter password: " + pass);
//        password.sendKeys(pass);
//        return this;
//    }

    @Step("Click next button")
    public LoginPage clickContinueButton() {
        logger.info("Click \"Next\" button");
        continueButton.click();
        return this;
    }
    public LoginPage clickAdd1() {
        logger.info("Click \"Next\" button");
        add1Button.submit();

        //add1Button.click();
        return this;
    }

    public LoginPage clickAdd2() {
        logger.info("Click \"Next\" button");
        add2Button.click();
        return this;
    }
    @Step("Submit Login")
    public HomePage submitLogin() {
        logger.info("Submit login forms");
        signinButton.click();
        return new HomePage(driver);
    }

    @Step("Click Need help link")
    public LoginPage clickNeedHelp() {
        logger.info("Click \"Need help\" link");
        needHelpLink.click();
        return this;
    }    
    
    public WebElement getLoginError() { return loginError; }
    
    public WebElement getNeedHelpHolder() {return needHelp; }
    
    public WebElement getHeader() { return header; }

}
