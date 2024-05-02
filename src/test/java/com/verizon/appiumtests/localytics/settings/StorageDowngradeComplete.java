//https://jira.synchronoss.net:8443/jira/browse/VZNFT-381
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 03/07/18.
 */
public class StorageDowngradeComplete extends BaseTestClass {
   // @Test
    public void testStorageDowngradeComplete() throws Exception {
        try {
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan))
                settingsView.downgradeStorageTo500GB();
            else {
                settingsView.upgradeStorageToOneTB();
                settingsView.downgradeStorageTo500GB();
            }
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_Storage_Upgrade);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Upgrade + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Upgrade));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Change_Plan_Downgrade + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Change_Plan_Downgrade));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Promotion + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Promotion));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Status + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Status));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Downgrade_Type + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Downgrade_Type));
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Source + " does not exist", localyticsHelper.isExisted(logs, vz_strings.logs_Storage_Source));
        } finally {
            if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan))
                settingsView.downgradeStorageTo500GB();
            else
                System.out.println("Storage already downgraded to 500 GB");
        }
    }

}
