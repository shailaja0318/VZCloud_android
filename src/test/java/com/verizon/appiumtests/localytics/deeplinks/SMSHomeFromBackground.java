//https://jira.synchronoss.net:8443/jira/browse/VZNFT-429
package com.verizon.appiumtests.localytics.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class SMSHomeFromBackground extends BaseTestClass {

    @Test
    public void testSMSHomeFromBackground() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        BaseDriver.runAppInBackground(-1);
        System.out.println(BaseDriver.queryAppState(vz_strings.BundleIds.VZ_ID));
        nativeIosAppsView.generateSMS(vz_strings.Deeplinks.HOME);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.HOME);
        baseControlsHelper.clickOnLabelContainsAndType(vz_strings.Deeplinks.HOME, "XCUIElementTypeOther");
        baseControlsHelper.waitForShow(vz_strings.verizon_cloud);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_appLaunch);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch) == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_networkType + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\"" + " = " + "\"" + vz_strings.logs_networkTypeWifi + "\"") == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_source + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + "\"" + vz_strings.logs_deeplink + "\"") == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_sourceApplication + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\"" + " = " + "\"" + vz_strings.BundleIds.APL_SMS + "\"") == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_target + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_target + " = " + vz_strings.logs_home) == 1);
    }
}