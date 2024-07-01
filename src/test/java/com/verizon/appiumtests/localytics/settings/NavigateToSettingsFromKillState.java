//https://jira.synchronoss.net:8443/jira/browse/VZNFT-419
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 06/08/18. 
 */
public class NavigateToSettingsFromKillState extends BaseTestClass {
  //  @Test
    public void testNavigateToSettingsFromKillState() throws Exception {
        BaseDriver.terminateApp(vz_strings.BundleIds.VZ_ID);
        nativeIosAppsView.generateSMS(vz_strings.Deeplinks.SETTINGS);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.SETTINGS);
        baseControlsHelper.clickOnLabelContainsAndType(vz_strings.Deeplinks.SETTINGS, "XCUIElementTypeOther");
        baseControlsHelper.waitForShow(vz_strings.settings_whatToBackUp);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_appLaunch);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_networkType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\"" + " = " + "\"" + vz_strings.logs_networkTypeWifi + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + "\"" + vz_strings.logs_deeplink + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_sourceApplication + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\"" + " = " + "\"" + vz_strings.BundleIds.APL_SMS + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_target + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_target + " = " + vz_strings.logs_settings));
    }
}
