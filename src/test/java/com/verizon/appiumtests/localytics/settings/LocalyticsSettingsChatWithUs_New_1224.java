package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class LocalyticsSettingsChatWithUs extends BaseTestClass {
    @Test
    public void testLocalyticsSettingsChatWithUs() throws Exception {

        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.scrollUtillAnElement(vz_strings.navi_Settings_ChatWithUs, "up");
        baseControlsHelper.clickOn(vz_strings.navi_Settings_ChatWithUs);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.navi_Settings_ChatWithUs);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_settings_ChatWithUs_Open));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exits", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + vz_strings.logs_settings_ChatWithUs_HelpandFeedback+ ""));

    }
}
