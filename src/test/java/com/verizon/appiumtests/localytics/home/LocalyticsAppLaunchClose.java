package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * VZNFT - 243 Step 4
 */
public class LocalyticsAppLaunchClose extends BaseTestClass {

    @Test
    public void testLocalyticsAppLaunchClose() throws Exception {

        BaseDriver.getDriver().close();
        
       
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_appLaunch + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch) == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_networkType + " does not exist",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\" = \"" + vz_strings.logs_networkTypeWifi + "\"") == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_source + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + vz_strings.logs_sourceDirect) == 1);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_sourceApplication + " does not exist",
				localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\" = \""
						+ vz_strings.logs_NotApplicable + "\"") == 1);
		TestCase.assertTrue("Localytics of " + vz_strings.logs_target + " does not exits", localyticsHelper
				.getPatternMatch(logs, vz_strings.logs_target + " = \"" + vz_strings.logs_NotApplicable + "\"") == 1);

    
    }
}