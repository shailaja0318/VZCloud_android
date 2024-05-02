//https://jira.synchronoss.net:8443/jira/browse/IV-2751
package com.verizon.appiumtests.settings.managestorage;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 02/07/18.
 */
public class DowngradeHigherStorageTierToLowerStorageTier extends BaseTestClass {

    @Test
    public void testDowngradeHigherStorageTierToLowerStorageTier() throws Exception {
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
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            TestCase.assertTrue("Storage not downgraded to 500 GB", settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_500GB_plan));
        } finally {
            if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan))
                settingsView.downgradeStorageTo500GB();
            else
                System.out.println("Storage already downgraded to 500 GB");
        }
    }

}
