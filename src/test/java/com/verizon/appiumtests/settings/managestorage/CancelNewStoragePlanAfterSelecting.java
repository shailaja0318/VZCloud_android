//https://jira.synchronoss.net:8443/jira/browse/IV-3350
package com.verizon.appiumtests.settings.managestorage;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by ssam0003 on 06/26/2018.
 */
public class CancelNewStoragePlanAfterSelecting extends BaseTestClass {
    String currentPlan;
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void testCancelNewStoragePlanAfterSelecting() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        softAssert.assertTrue(settingsView.elementVisibleSettings(vz_strings.navi_settings), "Settings page items are not available");
        baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
        baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
        currentPlan = settingsView.getCurrentStoragePlan();
        softAssert.assertTrue(settingsView.cancelStoragePlanChange(), "Unable to cancel and options not displayed");
        baseControlsHelper.waitForPresent(vz_strings.settings_about);
        baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
        softAssert.assertTrue(settingsView.getCurrentStoragePlan().equalsIgnoreCase(currentPlan), "Storage plan changed");
        softAssert.assertAll();
    }
}
