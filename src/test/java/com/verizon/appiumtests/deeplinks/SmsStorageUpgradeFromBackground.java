//VZNFT-369
package com.verizon.appiumtests.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class SmsStorageUpgradeFromBackground extends BaseTestClass {
    private final static Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testSmsStorageUpgradeFromBackground() throws Exception {
        homeScreenView.navigateTo(vz_strings.navi_settings);
        baseControlsHelper.waitForPresent(vz_strings.settings_manageStorage);
        baseControlsHelper.clickOnNameContainsAndVisibile(vz_strings.settings_manageStorage);
        if (settingsView.getCurrentStoragePlan().equalsIgnoreCase(vz_strings.settings_manageStorage_oneTB_plan)) {
            homeScreenView.backToHome();
            BaseDriver.runAppInBackground(-1);
            logger.info(BaseDriver.queryAppState(vz_strings.BundleIds.VZ_ID));
            nativeIosAppsView.generateSMS(vz_strings.Deeplinks.MANAGE_STORAGE);
            baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.MANAGE_STORAGE);
            baseControlsHelper.clickOnLabelContainsAndType(vz_strings.Deeplinks.MANAGE_STORAGE, "XCUIElementTypeOther");
            baseControlsHelper.waitForShow(vz_strings.verizon_cloud);
        } else {
            homeScreenView.backToHome();
            BaseDriver.runAppInBackground(-1);
            logger.info(BaseDriver.queryAppState(vz_strings.BundleIds.VZ_ID));
            nativeIosAppsView.generateSMS(vz_strings.Deeplinks.MANAGE_STORAGE);
            baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.MANAGE_STORAGE);
            baseControlsHelper.clickOnLabelContainsAndType(vz_strings.Deeplinks.MANAGE_STORAGE, "XCUIElementTypeOther");
            baseControlsHelper.waitForShow(vz_strings.settings_manageStorage);
        }
    }
}
