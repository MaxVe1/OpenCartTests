package com.exadel.automation;

import com.exadel.automation.pages.HomePage;
import com.exadel.automation.pages.LoginPage;
import com.exadel.automation.pages.SearchResultPage;
import java.lang.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchShorts extends BaseShorts {
    //Ok
    @Feature("OPENCART_3")
    @Story("Check Cameras")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Cameras is correct")
    public void testCamerasList() {

        LoginPage loginPage = new LoginPage(driver).
        navigateToCamera();

//        assertThat(loginPage.getDataFrom())
//                .contains("Cameras (2)");

        assertThat(loginPage.getCategoryNames())
                .contains("Cameras (2)");
        assertThat(loginPage.getCam1priceOld())
               .contains("$122.00");
        assertThat(loginPage.getCam1priceNew())
                .contains("$98.00");
        assertThat(loginPage.getCam2priceTax())
                 .contains("Ex Tax: $80.00");
    }

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


    @Feature("OPENCART_1")
    @Story("Check Monitors")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Monitors is correct")
    public void testMonitorsList() {

        LoginPage loginPage = new LoginPage(driver).
                navigateToAccount().
                navigateToLogin()
                 .enterEmail(propertiesLoader.getUserEmail())
                 .enterPSW(propertiesLoader.getUserPassword())
                 .navigateToComponents()
                 .navigateToMonitor()
                 .clickAdd1();

                  //assertThat(loginPage.getAlert())
                  //.contains("You must login or create an account to save Apple Cinema 30 "to your wish list!");
                  //loginPage.clickAdd2();
                  //assertThat(loginPage.getAlert());
                                //.contains("You must login or create an account to save Samsung SyncMaster 941BW to your wish list!");

    }
  
}
