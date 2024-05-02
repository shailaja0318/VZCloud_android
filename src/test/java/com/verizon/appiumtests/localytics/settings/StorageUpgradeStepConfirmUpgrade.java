//https://jira.synchronoss.net:8443/jira/browse/VZNFT-373
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 04/07/18.
 */
public class StorageUpgradeStepConfirmUpgrade extends BaseTestClass {
   // @Test
    public void testStorageUpgradeStepConfirmUpgrade() throws Exception {
        try {
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan)) {
                settingsView.downgradeStorageTo500GB();
                baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
                settingsView.upgradeStorageToOneTB();
            } else settingsView.upgradeStorageToOneTB();
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_ManageStorage);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_ManageStorage + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_ManageStorage));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Step_Confirmation_Dialog + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Step_Confirmation_Dialog));
        } finally {
            settingsView.downgradeStorageTo500GB();
        }
    }
}
