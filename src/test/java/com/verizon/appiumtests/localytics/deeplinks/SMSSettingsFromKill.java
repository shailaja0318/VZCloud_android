//https://jira.synchronoss.net:8443/jira/browse/VZNFT-426
package com.verizon.appiumtests.localytics.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class SMSSettingsFromKill extends BaseTestClass {

    @Test
    public void testSMSSettingsFromKill() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        BaseDriver.terminateApp(vz_strings.BundleIds.VZ_ID);
        nativeIosAppsView.generateSMS(vz_strings.Deeplinks.HOME);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.HOME);
        baseControlsHelper.clickOnLabelContainsAndType(vz_strings.Deeplinks.HOME, "XCUIElementTypeOther");
        baseControlsHelper.waitForShow(vz_strings.verizon_cloud);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_appLaunch);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_networkType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\"" + " = " + "\"" + vz_strings.logs_networkTypeWifi + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + "\"" + vz_strings.logs_deeplink + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_sourceApplication + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\"" + " = " + "\"" + vz_strings.BundleIds.APL_SMS + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_target + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_target + " = " + vz_strings.logs_home));
    }
}
