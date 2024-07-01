//VZNFT-12
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;


public class LocalyticsTools extends BaseTestClass {

    @Test
    public void testLocalyticsTools() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.clickOn(vz_strings.navi_tools);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagScreen);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tools + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagScreen + ": " + vz_strings.logs_tools));
    }
}
