package com.verizon.appiumtests.driver;



import io.appium.java_client.ios.IOSDriver;

public class AppiumBaseClass {
	protected IOSDriver driver() {
		return BaseDriver.getDriver();
	}

	public static void setDriver(IOSDriver driver) {
		BaseDriver.setDriver(driver);
	}
}