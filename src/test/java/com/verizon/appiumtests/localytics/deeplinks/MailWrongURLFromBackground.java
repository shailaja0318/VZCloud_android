//https://jira.synchronoss.net:8443/jira/browse/VZNFT-427
package com.verizon.appiumtests.localytics.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MailWrongURLFromBackground extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testMailWrongURLFromBackground() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_Photosandvideos);
        photosAndVideosView.selectTab(vz_strings.tab_all);
        BaseDriver.runAppInBackground(-1);
        logger.info(BaseDriver.queryAppState(vz_strings.BundleIds.VZ_ID));
        nativeIosAppsView.resetSettingsApp();
        String receiver = nativeIosAppsView.getDeviceEmailAccount();
        //EmailAndMessageUtils.sendEmail("vz", "vzcloud://notcorrecturl", receiver);
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_MAIL);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_MAIL);
        baseControlsHelper.clickOnNameContains("vzcloud://notcorrecturl");
        baseControlsHelper.clickOn("vzcloud://notcorrecturl");

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_networkType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\"" + " = " + "\"" + vz_strings.logs_networkTypeWifi + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + "\"" + vz_strings.logs_deeplink + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_sourceApplication + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\"" + " = " + "\"" + vz_strings.BundleIds.APL_MAIL + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_target + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_target + " = " + "\"" + vz_strings.logs_homeScreen + "\""));
    }
}
