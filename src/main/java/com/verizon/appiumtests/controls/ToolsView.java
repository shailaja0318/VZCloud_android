package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;

public class ToolsView {
    AppiumDriver driver = BaseDriver.getDriver();
    public ToolsView(AppiumDriver driver) {
        this.driver = driver;
    }
}
