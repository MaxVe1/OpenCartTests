package com.exadel.automation.Ui_tests;

import com.exadel.automation.BaseTest;
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

public class MonitorTest extends BaseTest {

    private static final String ACCOUNT = "#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > a > span";
    private static final String LOGIN = "#top > div.container > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a";
    private static final String COMPONENTS = "#narbar-menu > ul > li:nth-child(3) > a";
    private static final String MONITOR = "#narbar-menu > ul > li:nth-child(3) > div > div > ul > li:nth-child(2) > a";
    @Feature("OPENCART_1")
    @Story("Check Monitors")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify Monitors is correct")
    public void testMonitorsList() {

        LoginPage loginPage = new LoginPage(driver).
                navigateToItem(ACCOUNT).
                navigateToItem(LOGIN).
                enterEmail(propertiesLoader.getUserEmail())
                .enterPSW(propertiesLoader.getUserPassword()).
                navigateToItem(COMPONENTS).
                navigateToItem(MONITOR)
                .clickAdd1()
                .clickAdd2();
    }
}
