package com.exadel.automation.listeners;

import com.exadel.automation.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getGroups().length == 0) {
            Object currentClass = result.getInstance();
            WebDriver driver = ((BaseTest) currentClass).getDriver();
            byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(srcFile);
        }
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
