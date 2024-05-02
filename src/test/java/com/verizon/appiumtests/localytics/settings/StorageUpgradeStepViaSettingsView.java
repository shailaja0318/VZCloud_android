//https://jira.synchronoss.net:8443/jira/browse/VZNFT-371
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 05/07/18.
 */
public class StorageUpgradeStepViaSettingsView extends BaseTestClass {
    //@Test
    public void testStorageUpgradeStepViaSettingsView() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
        baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_ManageStorage);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_ManageStorage + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_ManageStorage));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_step
                + " = " + "\"" + vz_strings.logs_settingsView + "\"" + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_step
                + " = " + "\"" + vz_strings.logs_settingsView + "\""));
    }
}
