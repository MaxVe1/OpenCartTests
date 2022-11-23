package com.exadel.automation;

import com.exadel.automation.pages.LoginPage;
import java.lang.*;
import io.qameta.allure.*;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IphoneCurrencyTest extends BaseTest {

    private static final String EURO = "//a[contains(@href, 'EUR')]";
    private static final String POUND = "//a[contains(@href, 'GBP')]";
    private static final String IPHONEPRICE = "#content > div.row.mb-3 > div:nth-child(2) > ul:nth-child(3) > li:nth-child(1) > h2 > span";
    private static final String IPHONE = "#content > div.row > div:nth-child(2) > form > div > div.image > a > img";


    @Feature("OPENCART_2")
    @Story("Check iPhone And Currency")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify iPhone is correct")
    public void testIPhoneAndCurrencyUpd() {
        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getCurrency())
                .contains("$");

        loginPage.navigateToItem(IPHONE);
        assertThat(loginPage.getValueIPhonePrice(IPHONEPRICE))
                .contains("$123.20");
        loginPage.navigateToCurrency(EURO);
        assertThat(loginPage.getValueIPhonePrice(IPHONEPRICE))
                .contains("123.29€");
        loginPage.navigateToCurrency(POUND);
        assertThat(loginPage.getValueIPhonePrice(IPHONEPRICE))
                .contains("£106.62");
    }

}
