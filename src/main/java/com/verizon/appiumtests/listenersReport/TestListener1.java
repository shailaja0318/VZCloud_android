package com.verizon.appiumtests.listenersReport;

import com.relevantcodes.extentreports.LogStatus;
import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener1 extends BaseDriver implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	//Before starting all tests, below method runs.
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("AppiumDriver", BaseDriver.driver);
	}
	//After ending all tests, below method runs.
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
		//Do tier down operations for extentreports reporting!
		ExtentTestReportManager.endTest();
		ExtentManager.getReporter().flush();
	}
	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
		//Start operation for extentreports.
		ExtentTestReportManager.startTest(iTestResult.getMethod().getMethodName(),"");
	}
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		//Extentreports log operation for passed tests.
		ExtentTestReportManager.getTest().log(LogStatus.PASS, "Test passed");
	}
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		System.out.println("ON TEST FAILURE ......." +getTestMethodName(iTestResult));
		AppiumDriver driver = BaseDriver.getDriver();
	    //String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	   // ExtentTestReportManager.getTest().log(LogStatus.FAIL, "Test Failed", ExtentTestReportManager.getTest().addBase64ScreenShot(base64Screenshot));				
		ExtentTestReportManager.getTest().log(LogStatus.FAIL, "Test Failed");				

	}
	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method "+ getTestMethodName(iTestResult) + " skipped");
		//Extentreports log operation for skipped tests.
		ExtentTestReportManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}