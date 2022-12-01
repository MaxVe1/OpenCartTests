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

public class CameraTest extends BaseTest {

    private static final String CAMERA = "#narbar-menu > ul > li:nth-child(7) > a";

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
        assertThat(loginPage.getCam1price(CAM1_PRICE_OLD))
                .contains("$122.00");
        assertThat(loginPage.getCam1price(CAM1_PRICE_NEW))
                .contains("$98.00");
        assertThat(loginPage.getCam2price(CAM2_PRICE_TAX))
                .contains("Ex Tax: $80.00");
    }
}
