package com.verizon.appiumtests.OLDlisteners;

import com.verizon.appiumtests.driver.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class OldTestListener implements ITestListener {
    
	@Override
	public void onFinish(ITestContext context) {
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
	}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }
  
    public void onTestFailure(ITestResult result) {  
    	
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName= result.getName().trim();
    	
    	try {
			takeScreenShot(methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
    
    public void takeScreenShot(String methodName) throws Exception {
    	//get the driver
		TakesScreenshot screenCapture = BaseDriver.getDriver();
		File srcFile = screenCapture.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy-hh-mm");
    	String destDir = "surefire-reports/html/screenshots/";
    	new File(destDir).mkdirs();
    	File destFile = new File(destDir + "/" + methodName + "-" + dateFormat.format(new Date()) + ".jpg");
    	//The below method will copy the screen shot 
    	try {
    		FileUtils.copyFile(srcFile, destFile);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	reportLogScreenshot(destFile);
    }
    
    protected void reportLogScreenshot(File file) throws IOException {
    	System.setProperty("org.uncommons.reportng.escape-output", "false");
	    Reporter.log("<p align=\"left\"> " + new Date() + "</p>");
	    Reporter.log("<p><img width=\"256\" src=\"" + "./screenshots/" +file.getName()  + "\" alt=\"screenshot at " + new Date()+ "\"/></p><br />"); 
  }
    
}
