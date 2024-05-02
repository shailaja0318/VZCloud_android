//https://jira.synchronoss.net:8443/jira/browse/IV-2755
package com.verizon.appiumtests.settings.managestorage;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import junit.framework.TestCase;
import org.testng.annotations.Test;

/**
 * Created by ssam0003 on 29/06/18.
 */
public class SelectNewStoragePlan extends BaseTestClass {
    @Test
    public void testSelectNewStoragePlan() throws Exception {
        boolean storagePlan = false;
        String currentPlan;
        try {
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            currentPlan = settingsView.getCurrentStoragePlan();
            if (currentPlan.equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan)) {
                settingsView.downgradeStorageTo500GB();
                baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            } else {
                settingsView.upgradeStorageToOneTB();
                storagePlan = true;
            }
            TestCase.assertTrue("Storage plan not changes", !settingsView.getCurrentStoragePlan().equalsIgnoreCase(currentPlan));
        } finally {
            if (storagePlan)
                settingsView.downgradeStorageTo500GB();
            else
                System.out.println("Storage plan already downgraded to 500 GB");
        }
    }
}
