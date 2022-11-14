//package com.exadel.automation;

import com.exadel.automation.pages.HomePage;
import com.exadel.automation.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.SeverityLevel.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

//public class LoginTest extends BaseTest {
    //Ok
//    @Feature("AMAZONA")
//    @Story("Successfull login")
//    @Severity(BLOCKER)
//    @Description("Verify login with correct username and password")
//    @Test(description = "Verify login with correct username and password, TC-1")
//    @TmsLink("1")
//    public void testSuccessfulLogin() {
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homePage = loginPage
//                .navigateToSelf()
//                .enterEmail(propertiesLoader.getUserEmail())
//                .clickContinueButton()
//                //.enterPassword(propertiesLoader.getUserPassword())
//                .submitLogin();
//
//        //Assert.assertTrue(homePage.getCategoryNames().size() > 0, "Categories list is empty");
//    }

    //Ok
//    @Feature("AMAZON")
//    @Story("Login with nonexistent username")
//    @Severity(CRITICAL)
//    @Description("Verify login with nonexistent username")
//    @TmsLink("2")
//    @Test(description = "Verify login with nonexistent username, TC-2")
//    public void testNonexistentUsernameLogin() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.navigateToSelf()
//                .enterEmail("sdgffwgfsgfd@gmail.com")
//                .clickContinueButton();
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(loginPage.getLoginError().getText(), "We cannot find an account with that email address");
//        //softAssert.assertEquals(loginPage.getLoginError().getText(), "... find an account with that email address");
//        softAssert.assertEquals(loginPage.getLoginError().getText(), "We cannot find an account with that email address");
//        softAssert.assertAll();
//    }

//    //Ok
//    @Feature("AMAZON")
//    @Story("Login with incorrect password")
//    @Severity(MINOR)
//    @Description("Verify login with incorrect password")
//    @TmsLink("3")
//    @Test(description = "Verify login with incorrect password, TC-3")
//    public void testIncorrectPasswordLogin() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.navigateToSelf()
//                .enterEmail(propertiesLoader.getUserEmail())
//                .clickContinueButton()
//                //.enterPassword("Password1")
//                .submitLogin();
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(loginPage.getLoginError().getText().length(), 129);
//        softAssert.assertEquals(loginPage.getLoginError().getText(), "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.");
//        softAssert.assertAll();
//    }

//    //Ok
//    @Feature("AMAZON")
//    @Story("Need help button")
//    @Severity(TRIVIAL)
//    @Description("Verify 'Need help' link")
////    @Link(name = "TC-4", value = "4", type = "mylink")
//    @TmsLink("4")
//    @Issue("AD-12")
//    @Test(description = "Verify 'Need help' link, TC-4")
//    public void testNeedHelp() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.navigateToSelf()
//                .clickNeedHelp();
//
//        assertSoftly(softly -> {
//            softly.assertThat(loginPage.getNeedHelpHolder().getText()).hasLineCount(3);
//            softly.assertThat(loginPage.getNeedHelpHolder().getText()).contains(
//                    "Need help?",
//                    "Forgot your password?",
//                    "Other issues with Sign-In");
//        });
//    }
//}


