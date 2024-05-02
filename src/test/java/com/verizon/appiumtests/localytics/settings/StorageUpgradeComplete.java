//https://jira.synchronoss.net:8443/jira/browse/VZNFT-382
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 03/07/18.
 */
public class StorageUpgradeComplete extends BaseTestClass {
    //@Test
    public void testStorageUpgradeComplete() throws Exception {
        try {
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan)) {
                settingsView.downgradeStorageTo500GB();
                baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
                settingsView.upgradeStorageToOneTB();
            } else {
                settingsView.upgradeStorageToOneTB();
            }
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_Storage_Upgrade);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Upgrade + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Upgrade));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Change_Plan_Upgrade + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Change_Plan_Upgrade));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Promotion + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Promotion));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Status + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Status));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Type + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Type));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Source + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Source));
        } finally {
            settingsView.downgradeStorageTo500GB();
        }
    }
}
