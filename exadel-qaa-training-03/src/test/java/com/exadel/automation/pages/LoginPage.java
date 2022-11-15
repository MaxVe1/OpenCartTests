package com.exadel.automation.pages;

import com.exadel.automation.components.CategoryListBox;
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

    private static final String DEFAULT_SELECTOR = "#column-left > div.list-group.mb-3";
    private static final String CURRENCY_SELECTOR = "#form-currency > div > a";
    private static final String EMAIL_SELECTOR_MV = "#input-email";

    private static final String PSW_SELECTOR_MV = "#input-password";
    private static final String CONTINUE_BUTTON_SELECTOR = "input#continue";

    private static final String ITEM_SELECTOR = "#content > div.row.mb-3 > div:nth-child(2)";
    private static final String CAM_SELECTOR = "#product-list > div:nth-child(1)";
    private static final String CAM2_SELECTOR = "#product-list > div:nth-child(2)";
    private static final String SIGNIN_BUTTON_SELECTOR = "input#signInSubmit";
    private static final String LOGIN_ERROR_SELECTOR = "div.a-alert-container div.a-alert-content";
    private static final String NEED_HELP_SELECTOR = "div.a-expander-container";
    private static final String NEED_HELP_LINK_SELECTOR = "a.a-expander-header";
    private static final String ADD1_BUTTON_SELECTOR = "#product-list > div:nth-child(1) > form > div > div.content > div.button-group > button:nth-child(2)";
    private static final String ADD2_BUTTON_SELECTOR = "#product-list > div:nth-child(2) > form > div > div.content > div.button-group > button:nth-child(2) > i";
    private static final String CATEGORIES_CLOSER_LINK_SELECTOR = "div.nav-sprite.hmenu-close-icon";//MV NEW
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
    
    @Step("Navigate to Camera")
    public LoginPage navigateToCamera() {

        List<WebElement> selfLink = driver.findElements(By.cssSelector("#narbar-menu > ul > li:nth-child(7) > a"));
        if (selfLink.size() > 0) {
            selfLink.get(0).click();
        }
        return this;
    }

    @Step("Navigate to iPhone")
    public LoginPage navigateToIphone() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#content > div.row > div:nth-child(2) > form > div > div.image > a > img"));//.click();//LOGIN_PAGE_LINK_SELECTOR1));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        return this;
    }
    @Step("Navigate to Euro")
    public LoginPage navigateToEuro() {
        List<WebElement> currLink = driver.findElements(By.cssSelector("#form-currency > div > a"));
        if (currLink.size() > 0) {
            currLink.get(0).click();
        }
        List<WebElement> selfLink1 = driver.findElements(By.xpath("//a[contains(@href, 'EUR')]"));
        if(selfLink1.size()==1){
            selfLink1.get(0).click();
        }
        return this;
    }

    @Step("Navigate to Pound")
    public LoginPage navigateToPound() {
        List<WebElement> currLink = driver.findElements(By.cssSelector("#form-currency > div > a"));
        if (currLink.size() > 0) {
            currLink.get(0).click();
        }
        List<WebElement> selfLink1 = driver.findElements(By.xpath("//a[contains(@href, 'GBP')]"));
        if(selfLink1.size()==1){
            selfLink1.get(0).click();
        }
        return this;
    }
    @Step("Navigate to Account")
    public LoginPage navigateToAccount() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > a > span"));//.click();//LOGIN_PAGE_LINK_SELECTOR1));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
            return this;
    }
    @Step("Navigate to Components")
    public LoginPage navigateToComponents() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#narbar-menu > ul > li:nth-child(3) > a"));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }
        return this;
    }
    @Step("Navigate to Components")
    public LoginPage navigateToMonitor() {
        List<WebElement> selfLink1 = driver.findElements(By.cssSelector("#narbar-menu > ul > li:nth-child(3) > div > div > ul > li:nth-child(2) > a"));
        if (selfLink1.size() > 0) {
            selfLink1.get(0).click();
        }

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

        return this;
    }
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
    @FindBy(css = CATEGORIES_CLOSER_LINK_SELECTOR)
    private WebElement categoriesCloser;

    @Step("Click next button")
    public LoginPage clickContinueButton() {
        logger.info("Click \"Next\" button");
        continueButton.click();
        return this;
    }
    public LoginPage clickAdd1() {
        logger.info("Click \"Next\" button");
        add1Button.submit();
        return this;
    }

    public LoginPage clickAdd2() {
        logger.info("Click \"Next\" button");
        add2Button.submit();
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
    @FindBy(css = DEFAULT_SELECTOR)
    private WebElement categoriesListBoxHolder;
    @FindBy(css = ITEM_SELECTOR)
    private WebElement ItemHolder;

    @FindBy(css = CAM_SELECTOR)
    private WebElement CamHolder;

    @FindBy(css = CAM2_SELECTOR)
    private WebElement CamHolder2;
    @FindBy(css = CURRENCY_SELECTOR)
    private WebElement CurrencyHolder;
    @Step("Get Categories List")
    public List<String> getCategoryNames() {
        List<String> names =  getCategoriesListBox().getCategoryNames();
        logger.info("List categories: " + names);
        return names;
    }
    private CategoryListBox getCurrencyList() {
        return new CategoryListBox(CurrencyHolder);
    }
    private CategoryListBox getCategoriesListBox() {
        return new CategoryListBox(categoriesListBoxHolder);
    }

    private CategoryListBox getItem() {
        return new CategoryListBox(ItemHolder);
    }
    private CategoryListBox camItem1() {
        return new CategoryListBox(CamHolder);
    }
    private CategoryListBox camItem2() {
        return new CategoryListBox(CamHolder2);
    }
    @Step("Get Categories List")
    public List<String> getCurrency() {
        List<String> names =  getCurrencyList().getCurrencyNames();
        logger.info("List categories: " + names);
        return names;
    }

    @Step("Get iPhone Price")
    public List<String> getIPhonePrice() {
        List<String> price =  getItem().getIPhonePriceNames();
        return price;
    }
    @Step("Get Cam1 Price Old")
    public List<String> getCam1priceOld() {
        List<String> price =  camItem1().getCam1_PriceOld();
        System.out.println(price);
        return price;
    }
    @Step("Get Cam1 Price New")
    public List<String> getCam1priceNew() {
        List<String> price =  camItem1().getCam1_PriceNew();
        System.out.println(price);
        return price;
    }
    @Step("Get Cam2 Price with Tax")
    public List<String> getCam2priceTax() {
         List<String> price =  camItem2().getCam2_PriceTax();
         return price;
    }
    public WebElement getLoginError() { return loginError; }
    
    public WebElement getNeedHelpHolder() {return needHelp; }
    
    //public WebElement getHeader() { return header; }

}
