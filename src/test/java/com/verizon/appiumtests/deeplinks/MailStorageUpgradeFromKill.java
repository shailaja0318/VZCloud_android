//VZNFT-365
package com.verizon.appiumtests.deeplinks;

import com.verizon.appiumtests.constants.vz_strings;
import com.verizon.appiumtests.controls.BaseTestClass;
import com.verizon.appiumtests.driver.BaseDriver;
import org.testng.annotations.Test;

public class MailStorageUpgradeFromKill extends BaseTestClass {

  @Test
    public void testMailStorageUpgradeFromKill() throws Exception {
        BaseDriver.terminateApp(vz_strings.BundleIds.VZ_ID);
        nativeIosAppsView.resetSettingsApp();
        String receiver = nativeIosAppsView.getDeviceEmailAccount();
        //EmailAndMessageUtils.sendEmail("vz", vz_strings.Deeplinks.SETTINGS, receiver);
        BaseDriver.terminateApp(vz_strings.BundleIds.APL_MAIL);
        BaseDriver.lanuchApp(vz_strings.BundleIds.APL_MAIL);
        baseControlsHelper.clickOnNameContains(vz_strings.Deeplinks.MANAGE_STORAGE);
        baseControlsHelper.clickOn(vz_strings.Deeplinks.MANAGE_STORAGE);
        baseControlsHelper.waitForShow(vz_strings.settings_manageStorage);
    }
}
