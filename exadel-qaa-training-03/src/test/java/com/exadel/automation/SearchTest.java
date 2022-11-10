package com.exadel.automation;

import com.exadel.automation.pages.HomePage;
import com.exadel.automation.pages.LoginPage;
import com.exadel.automation.pages.SearchResultPage;
import java.lang.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {
    //Ok

    @Feature("OPENCART_3")
    @Story("Check Cameras")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Cameras is correct")
    public void testCategoriesList() {

        LoginPage loginPage = new LoginPage(driver).
        navigateToCamera();

    }

    @Feature("OPENCART_2")
    @Story("Check iPhone")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify iPhone is correct")
    public void testCategoriesList2() {


        LoginPage loginPage1 = new LoginPage(driver).
                navigateToIphone();

    }


    @Feature("OPENCART_1")
    @Story("Check Monitors")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Monitors is correct")
    public void testCategoriesList3() {

        LoginPage loginPage1 = new LoginPage(driver).
                navigateToAccount().
                navigateToLogin()
                 .enterEmail(propertiesLoader.getUserEmail())
                 .enterPSW(propertiesLoader.getUserPassword())
                 .navigateToComponents()
                 .navigateToMonitor()
                 .clickAdd1()
                 .clickAdd2();
    }
  
}
