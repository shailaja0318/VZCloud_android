package com.verizon.appiumtests.listenersReport;

import com.relevantcodes.extentreports.LogStatus;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//import io.appium.java_client.MobileElement;


public class Retry implements IRetryAnalyzer {
	private int count = 0;
	private static final int maxTry = 1; //Run the failed test 2 times
	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) {//Check if test not succeed
			if (count < maxTry) {       //Check if maxtry count is reached
				count++; //Increase the maxTry count by 1
				iTestResult.setStatus(ITestResult.FAILURE); //Mark test as failed
				extendReportsFailOperations(iTestResult); //ExtentReports fail operations
				return true; //Tells TestNG to re-run the test
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); //If test passes, TestNG marks it as passed
		}
		return false;
	}

	public void extendReportsFailOperations (ITestResult iTestResult) {
			System.out.println("EXTENT REPORTS FAILS OPERATION......." +iTestResult.getMethod().getMethodName());
			AppiumDriver driver = BaseDriver.getDriver();
			String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			ExtentTestReportManager.getTest().log(LogStatus.FAIL, "Test Failed", ExtentTestReportManager.getTest().addBase64ScreenShot(base64Screenshot));		
	}
}