package com.verizon.appiumtests.controls;

import com.verizon.appiumtests.driver.BaseDriver;
import io.appium.java_client.AppiumDriver;


public class WebView {
    AppiumDriver driver = BaseDriver.getDriver();
    public WebView(AppiumDriver driver) {
        this.driver = driver;
    }
}
