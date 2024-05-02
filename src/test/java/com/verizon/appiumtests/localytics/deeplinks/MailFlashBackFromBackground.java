//https://jira.synchronoss.net:8443/jira/browse/VZNFT-404
package com.verizon.appiumtests.localytics.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MailFlashBackFromBackground extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testMailFlashBackFromBackground() throws Exception {
        BaseDriver.runAppInBackground(-1);
        nativeIosAppsView.resetSettingsApp();
        String receiver = nativeIosAppsView.getDeviceEmailAccount();
        //EmailAndMessageUtils.sendEmail("vz", vz_strings.Deeplinks.FLASH_BACK, receiver);
        logger.info(BaseDriver.queryAppState(vz_strings.BundleIds.VZ_ID));
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_MAIL);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_MAIL);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.FLASH_BACK);
        baseControlsHelper.clickOn(vz_strings.Deeplinks.FLASH_BACK);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_flashBackTab) == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_networkType + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\"" + " = " + "\"" + vz_strings.logs_networkTypeWifi + "\"") == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_source + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + "\"" + vz_strings.logs_deeplink + "\"") == 2);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_sourceApplication + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\"" + " = " + "\"" + vz_strings.BundleIds.APL_MAIL + "\"") == 1);

        TestCase.assertTrue("Localytics of " + vz_strings.logs_target + " is not 1 in logs",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_target + " = " + "\"" + vz_strings.logs_gallery_flashbacks + "\"") == 1);
    }
}