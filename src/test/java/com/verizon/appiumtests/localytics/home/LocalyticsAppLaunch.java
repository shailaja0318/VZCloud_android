package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;
/**
 *  VZNFT - 243 Step 2
 */
public class LocalyticsAppLaunch extends BaseTestClass {

    @Test
    public void testLocalyticsAppLaunch() throws Exception {

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_appLaunch + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_networkType + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\" = \"" + vz_strings.logs_networkTypeWifi + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exist", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + vz_strings.logs_sourceDirect));
    }
}