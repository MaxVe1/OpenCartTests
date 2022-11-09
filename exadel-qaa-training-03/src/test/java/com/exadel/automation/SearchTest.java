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




    @Feature("OPENCART_1")
    @Story("Categories List")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Categories List is correct")
    public void testCategoriesList() {


        LoginPage loginPage = new LoginPage(driver).
        navigateToCamera();
        //navigateToSelf2();


        //assertThat(homePage.getCategoryNames());
        	//.contains("Amazon Music", "Electronics")
        	//.doesNotContain("bb");

        //MV added TimeOUt

    }

    @Feature("OPENCART_3")
    @Story("Categories List")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Categories List is correct")
    public void testCategoriesList2() {


        LoginPage loginPage1 = new LoginPage(driver).
                navigateToIphone();


    }


    @Feature("OPENCART_3")
    @Story("Categories List")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Categories List is correct")
    public void testCategoriesList3() {


        LoginPage loginPage1 = new LoginPage(driver).
                navigateToAccount().
                navigateToLogin()
                 .enterEmail(propertiesLoader.getUserEmail())
                 //.navigateToPSW()
                 .enterPSW(propertiesLoader.getUserPassword())
                 .navigateToComponents()
                 .navigateToMonitor()
                 .clickAdd1()
                 .clickAdd2();
                 //.chooseDevice1()
                 //.chooseDevice2();
                 //.enterEmail(propertiesLoader.getUserEmail())
                 //.enterPSW(propertiesLoader.getUserPassword());
                //.submitLogin();
                //.clickContinueButton()
                //.submitLogin();
    }
  
}
