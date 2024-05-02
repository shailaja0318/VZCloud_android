//https://jira.synchronoss.net:8443/jira/browse/IV-2749
package com.verizon.appiumtests.settings.managestorage;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 28/06/18.
 */
public class UpgradeExistingStorageTierToHigherStorageTier extends BaseTestClass {

    @Test
    public void testUpgradeExistingStorageTierToHigherStorageTier() throws Exception {
        try {
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan)) {
                settingsView.downgradeStorageTo500GB();
                settingsView.upgradeStorageToOneTB();
            } else
                settingsView.upgradeStorageToOneTB();
            TestCase.assertTrue("Storage not upgraded to 1 TB", settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan));
        } finally {
            settingsView.downgradeStorageTo500GB();
        }
    }
}
