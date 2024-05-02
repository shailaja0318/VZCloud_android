//https://jira.synchronoss.net:8443/jira/browse/IV-3329
package com.verizon.appiumtests.settings.managestorage;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by ssam0003 on 23/05/18.
 */
public class DisplayManageStorageFor1TBPlan extends BaseTestClass {
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void testDisplayManageStorageFor1TBPlan() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
        baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
        settingsView.upgradeStorageToOneTB();
        softAssert.assertEquals(vz_strings.settings_manageStorage_oneTB_plan, settingsView.getCurrentStoragePlan(), "Storage not upgraded to 1 TB");
        softAssert.assertEquals(true, baseControlsHelper.isVisible(vz_strings.settings_manageStorage), "Manage storage page not displayed");
        settingsView.downgradeStorageTo500GB();
        softAssert.assertAll();
    }
}
