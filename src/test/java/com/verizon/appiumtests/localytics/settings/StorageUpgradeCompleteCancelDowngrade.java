//https://jira.synchronoss.net:8443/jira/browse/VZNFT-384
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;

/**
 * Created by ssam0003 on 09/07/18.
 */
public class StorageUpgradeCompleteCancelDowngrade extends BaseTestClass {
   // @Test
    public void testStorageUpgradeCompleteCancelDowngrade() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
        baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
        if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_500GB_plan))
            settingsView.upgradeStorageToOneTB();
        baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_500GB_plan);
        baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage_500GB_plan);
        baseControlsHelper.clickOn(vz_strings.button_cancel);
        String logs = localyticsHelper.getLogs();
        localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_Storage_Upgrade);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_Storage_Upgrade + " does not exist", 2, localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_Upgrade));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_No_Change + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_No_Change) >= 1 && localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_No_Change) <= 2);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_Storage_Promotion + " does not exist", 2, localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_Promotion));
        TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Cancel_Status + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_Cancel_Status) >= 1 && localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_Cancel_Status) <= 2);
        TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Downgrade_Type + " does not exist",
                localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_Downgrade_Type) >= 1 && localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_Downgrade_Type) <= 2);
        TestCase.assertEquals("Localytics of " + vz_strings.logs_Storage_Source + " does not exist", 2, localyticsHelper.getPatternMatch(logs, vz_strings.logs_Storage_Source));
    }
}
