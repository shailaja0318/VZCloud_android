//https://jira.synchronoss.net:8443/jira/browse/VZNFT-380
package com.verizon.appiumtests.localytics.settings;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

/**
 * Created by ssam0003 on 10/07/18.
 */
public class StorageUpgradeCompleteFailedDowngrade extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    //@Test
    public void testStorageUpgradeCompleteFailedDowngrade() throws Exception {
        try {
            nativeIosAppsView.resetSettingsApp();
           // BaseDriver.getDriver().launchApp();
            BaseDriver.launchApp();
            homeScreenView.navigateTo(vz_strings.navi_settings);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
            if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_500GB_plan)) {
                settingsView.upgradeStorageToOneTB();
            }
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_500GB_plan);
            baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage_500GB_plan);
            baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage_confirm_popup);
            baseControlsHelper.clickOn(vz_strings.settings_manageStorage_confirm_popup);
            nativeIosAppsView.turnOnAndOffAirplaneMode();
            String logs = localyticsHelper.getLogs();
            localyticsHelper.print(logs, vz_strings.logs_tagEvent + ": " + vz_strings.logs_Storage_Upgrade);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Upgrade + " does not exist",
                    localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Upgrade) >= 1 && localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Upgrade) <= 2);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Change_Plan_Downgrade + " does not exist",
                    localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Change_Plan_Downgrade) == 1);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Promotion + " does not exist",
                    localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Promotion) >= 1 && localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Promotion) <= 2);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Failed_Status + " does not exist",
                    localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Failed_Status) == 1);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Downgrade_Type + " does not exist",
                    localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Downgrade_Type) == 1);
            TestCase.assertTrue("Localytics of " + vz_strings.logs_Storage_Source + " does not exist",
                    localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Source) >= 1 && localyticsHelper.getCountOf(logs, vz_strings.logs_Storage_Source) <= 2);
        } finally {
            if (baseControlsHelper.isSelectedByTypeAndName("XCUIElementTypeSwitch", "Airplane Mode"))
                nativeIosAppsView.turnOnAndOffAirplaneMode();
            else
                logger.info("Airplane mode already in off state");
        }
    }
}
