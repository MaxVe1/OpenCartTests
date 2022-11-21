package com.exadel.automation;

import com.exadel.automation.pages.HomePage;
import com.exadel.automation.pages.LoginPage;
import com.exadel.automation.pages.SearchResultPage;
import java.lang.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    private static final String EURO = "//a[contains(@href, 'EUR')]";
    private static final String POUND = "//a[contains(@href, 'GBP')]";

    private static final String IPHONE = "#content > div.row > div:nth-child(2) > form > div > div.image > a > img";
    //Ok
//    @Feature("OPENCART_3")
//    @Story("Check Cameras")
//    @Severity(SeverityLevel.NORMAL)
//    @Test(description = "Verify Cameras is correct")
//    public void testCamerasList() {
//
//        LoginPage loginPage = new LoginPage(driver).
//                navigateToCamera();
//
//        assertThat(loginPage.getCategoryNames())
//                .contains("Cameras (2)");
//        assertThat(loginPage.getCam1priceOld())
//                .contains("$122.00");
//        assertThat(loginPage.getCam1priceNew())
//                .contains("$98.00");
//        assertThat(loginPage.getCam2priceTax())
//                .contains("Ex Tax: $80.00");
//    }

    @Feature("OPENCART_2")
    @Story("Check iPhone")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify iPhone is correct")
    public void testIPhoneAndCurrencyList() {
        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getCurrency())
                .contains("$");
        loginPage.navigateToIphone();
        assertThat(loginPage.getIPhonePrice())
                .contains("$123.20");
        loginPage.navigateToEuro();
        assertThat(loginPage.getIPhonePrice())
                .contains("123.29€");
        loginPage.navigateToPound();
        assertThat(loginPage.getIPhonePrice())
                .contains("£106.62");

    }


//    @Feature("OPENCART_1")
//    @Story("Check Monitors")
//    @Severity(SeverityLevel.NORMAL)
//    @Test(description = "Verify Monitors is correct")
//    public void testMonitorsList() {
//
//        LoginPage loginPage1 = new LoginPage(driver).
//                navigateToAccount().
//                navigateToLogin()
//                .enterEmail(propertiesLoader.getUserEmail())
//                .enterPSW(propertiesLoader.getUserPassword())
//                .navigateToComponents()
//                .navigateToMonitor()
//                .clickAdd1()
//                .clickAdd2();
//    }


    @Feature("OPENCART_2")
    @Story("Check iPhone")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify iPhone is correct")
    public void testIPhoneAndCurrencyUpd() {
        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getCurrency())
                .contains("$");

        loginPage.navigateToItem(IPHONE);
        assertThat(loginPage.getIPhonePrice())
                .contains("$123.20");
        loginPage.navigateToCurrency(EURO);//"//a[contains(@href, 'EUR')]");
        assertThat(loginPage.getIPhonePrice())
                .contains("123.29€");
        loginPage.navigateToCurrency(POUND);//"//a[contains(@href, 'GBP')]");
        assertThat(loginPage.getIPhonePrice())
                .contains("£106.62");

    }
}
