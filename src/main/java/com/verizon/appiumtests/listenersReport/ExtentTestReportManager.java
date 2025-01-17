package com.verizon.appiumtests.listenersReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.model.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ExtentTestReportManager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getReporter();
	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) Thread.currentThread().getId());
		}
	public static synchronized void endTest() {
		extent.endTest(extentTestMap.get((int) Thread.currentThread().getId()));
		}
	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.startTest(testName, desc);
		extentTestMap.put((int) Thread.currentThread().getId(), test);
		return test;
		}

	private static final Logger log = Logger.getLogger(Log.class.getName());
}