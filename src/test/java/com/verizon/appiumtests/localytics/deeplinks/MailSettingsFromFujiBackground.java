//https://jira.synchronoss.net:8443/jira/browse/VZNFT-412
package com.verizon.appiumtests.localytics.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MailSettingsFromFujiBackground extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testMailSettingsFromFujiBackground() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_printshop);
        baseControlsHelper.waitForDismiss(vz_strings.spinner);
        if (baseControlsHelper.getCountById(vz_strings.button_acceptContinue) != 0)
            baseControlsHelper.clickOn(vz_strings.button_acceptContinue);
        BaseDriver.runAppInBackground(-1);
        logger.info(BaseDriver.queryAppState(vz_strings.BundleIds.VZ_ID));
        nativeIosAppsView.resetSettingsApp();
        String receiver = nativeIosAppsView.getDeviceEmailAccount();
        //EmailAndMessageUtils.sendEmail("vz", vz_strings.Deeplinks.SETTINGS, receiver);
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_MAIL);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_MAIL);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.SETTINGS);
        baseControlsHelper.clickOn(vz_strings.Deeplinks.SETTINGS);
        baseControlsHelper.waitForShow(vz_strings.settings_whatToBackUp);

        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent);

        TestCase.assertEquals("Localytics of " + vz_strings.logs_tagEvent + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_appLaunch));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_networkType + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_networkType + "\"" + " = " + "\"" + vz_strings.logs_networkTypeWifi + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_source + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_source + " = " + "\"" + vz_strings.logs_deeplink + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_sourceApplication + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, "\"" + vz_strings.logs_sourceApplication + "\"" + " = " + "\"" + vz_strings.BundleIds.APL_MAIL + "\""));

        TestCase.assertEquals("Localytics of " + vz_strings.logs_target + " is not 1 in logs", 1, localyticsHelper.getPatternMatch(logs, vz_strings.logs_target + " = " + vz_strings.logs_settings));
    }
}
