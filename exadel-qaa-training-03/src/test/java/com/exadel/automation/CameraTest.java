package com.exadel.automation;

import com.exadel.automation.components.BaseComponent;
import com.exadel.automation.components.CategoryListBox;
import com.exadel.automation.pages.HomePage;
import com.exadel.automation.pages.LoginPage;
import com.exadel.automation.pages.SearchResultPage;
import java.lang.*;
import io.qameta.allure.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CameraTest extends BaseTest {

    //@FindBy(css = CAM_SELECTOR)
   // private WebElement CamHolder;
    //private static final String ACCOUNT = "#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > a > span";
    //private static final String LOGIN = "#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a";
    private static final String CAMERA = "#narbar-menu > ul > li:nth-child(7) > a";
//    private static final String COMPONENTS = "#narbar-menu > ul > li:nth-child(3) > a";
//    private static final String MONITOR = "#narbar-menu > ul > li:nth-child(3) > div > div > ul > li:nth-child(2) > a";
//    private static final String EURO = "//a[contains(@href, 'EUR')]";
//    private static final String POUND = "//a[contains(@href, 'GBP')]";
//
//    private static final String IPHONEPRICE = "#content > div.row.mb-3 > div:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > h2 > span";
//
//    private static final String IPHONE = "#content > div.row > div:nth-child(2) > form > div > div.image > a > img";

    private static final String CAM_SELECTOR = "#product-list > div:nth-child(1)";

    private static final String CAM1_PRICE_OLD = "#product-list > div:nth-child(1) > form > div > div.content > div.description > div > span.price-old";
    private static final String CAM1_PRICE_NEW = "#product-list > div:nth-child(1) > form > div > div.content > div.description > div > span.price-new";

    private static final String CAM2_PRICE_TAX = "#product-list > div:nth-child(2) > form > div > div.content > div.description > div > span.price-tax";

    @Feature("OPENCART_3")
    @Story("Check Cameras")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Cameras is correct")
    public void testCamerasList() {

        LoginPage loginPage = new LoginPage(driver).
        navigateToItem(CAMERA);

        assertThat(loginPage.getCategoryNames())
                .contains("Cameras (2)");
        assertThat(loginPage.getCam1price(/*CamHolder , */CAM1_PRICE_OLD))
                .contains("$122.00");
        assertThat(loginPage.getCam1price(/*CamHolder , */CAM1_PRICE_NEW))
                .contains("$98.00");
        assertThat(loginPage.getCam2price(CAM2_PRICE_TAX))
                .contains("Ex Tax: $80.00");
    }
//
//    @Feature("OPENCART_2")
//    @Story("Check iPhone")
//    @Severity(SeverityLevel.NORMAL)
//    @Test(description = "Verify iPhone is correct")
//    public void testIPhoneAndCurrencyUpd() {
//        LoginPage loginPage = new LoginPage(driver);
//        assertThat(loginPage.getCurrency())
//                .contains("$");
//
//        loginPage.navigateToItem(IPHONE);
//        assertThat(loginPage.getValueIPhonePrice(IPHONEPRICE))
//                .contains("$123.20");
//        loginPage.navigateToCurrency(EURO);
//        assertThat(loginPage.getValueIPhonePrice(IPHONEPRICE))
//                .contains("123.29€");
//        loginPage.navigateToCurrency(POUND);
//        assertThat(loginPage.getValueIPhonePrice(IPHONEPRICE))
//                .contains("£106.62");
//
//    }
//
//
//    @Feature("OPENCART_1")
//    @Story("Check Monitors")
//    @Severity(SeverityLevel.NORMAL)
//    @Test(description = "Verify Monitors is correct")
//    public void testMonitorsList() {
//
//        LoginPage loginPage = new LoginPage(driver).
//                navigateToItem(ACCOUNT).
//                navigateToItem(LOGIN).
//                enterEmail(propertiesLoader.getUserEmail())
//                .enterPSW(propertiesLoader.getUserPassword()).
//                navigateToItem(COMPONENTS).
//                navigateToItem(MONITOR)
//                .clickAdd1()
//                .clickAdd2();
//    }
}
