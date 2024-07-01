package com.verizon.appiumtests.localytics.home;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * VZNFT - 243 Step 6
 */
public class LocalyticsAppLaunchBackground extends BaseTestClass {

	@Test
	public void testLocalyticsAppLaunchBackground() throws Exception {

		//BaseDriver.getDriver().runAppInBackground(Duration.ofSeconds(5));
		
		BaseDriver.runAppInBackground(5);

		String logs = localyticsHelper.getLogs();
		localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_appLaunch + " is not 1 in logs", 1, localyticsHelper
                .getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_networkType + " does not exist", 1, localyticsHelper.getPatternMatch(logs,
                "\"" + vz_strings.logs_networkType + "\" = \"" + vz_strings.logs_networkTypeWifi + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " does not exist", 1, localyticsHelper
                .getPatternMatch(logs, vz_strings.logs_source + " = " + vz_strings.logs_sourceDirect));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_sourceApplication + " does not exist", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\" = \""
                + vz_strings.logs_NotApplicable + "\""));
        TestCase.assertEquals("Localytics of " + vz_strings.logs_target + " does not exits", 1, localyticsHelper
                .getPatternMatch(logs, vz_strings.logs_target + " = \"" + vz_strings.logs_NotApplicable + "\""));
	
	}
}