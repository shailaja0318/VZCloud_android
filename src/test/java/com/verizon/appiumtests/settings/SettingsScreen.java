//https://jira.synchronoss.net:8443/jira/browse/IV-94/Step-1
package com.verizon.appiumtests.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class SettingsScreen extends BaseTestClass {
    @Test
    public void settingScreen() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        TestCase.assertTrue( "Settings page items are not available", settingsView.elementVisibleSettings(vz_strings.navi_settings));
    }
}
